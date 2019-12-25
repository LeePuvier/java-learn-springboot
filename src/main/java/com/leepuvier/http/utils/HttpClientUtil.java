package com.leepuvier.http.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : LeePuvier
 * @CreateTime : 2019/12/24  2:35 PM
 * @ContentUse :
 */
@Slf4j
public class HttpClientUtil {


    /**请求编码*/
    private static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 执行HTTP POST请求
     * @param url url
     * @param param 参数
     * @return
     */
    public static String httpPostWithParam(String url, Map<String, ?> param) {
        CloseableHttpClient client = null;
        try {
            if(url == null || url.trim().length() == 0){
                throw new Exception("URL is null");
            }
            HttpPost httpPost = new HttpPost(url);
            client = HttpClients.createDefault();
            if(param != null){
                StringEntity entity = new StringEntity(JSON.toJSONString(param), DEFAULT_CHARSET);//解决中文乱码问题
                entity.setContentEncoding(DEFAULT_CHARSET);
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            HttpResponse resp = client.execute(httpPost);
            if(resp.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(resp.getEntity(), DEFAULT_CHARSET);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(client);
        }
        return null;
    }

    /**
     *
     * @param url
     * @param baseParamJson 基础数据
     * @param expectParamJson   需要替换的数据
     * @return
     */
    public static String httpPostWithJSON(String url, String baseParamJson, String expectParamJson){

        CloseableHttpClient client = null;
        try {
            if(url == null || url.trim().length() == 0){
                throw new Exception("URL 为空，请确认配置内容是否正确！！！");
            }
            HttpPost httpPost = new HttpPost(url);
            client = HttpClients.createDefault();
            if(baseParamJson != null){
                StringEntity entity = null;
                if(expectParamJson != null && expectParamJson.length() != 0){
                    //替换 baseParamJson Json 中 存在 expectParamJson Json Key 对应的值
                    JSONObject replaceJson = compareJson(JSON.parseObject(baseParamJson), JSON.parseObject(expectParamJson));
                    log.info("---------------------> 替换后提交数据为：" + replaceJson.toString());
                    entity = new StringEntity(replaceJson.toString(), DEFAULT_CHARSET);//解决中文乱码问题
                }else {
                    entity = new StringEntity(baseParamJson, DEFAULT_CHARSET);//解决中文乱码问题
                }
                entity.setContentEncoding(DEFAULT_CHARSET);
                entity.setContentType("text/plain");
                httpPost.setEntity(entity);
            }
            HttpResponse resp = client.execute(httpPost);
            if(resp.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(resp.getEntity(), DEFAULT_CHARSET);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(client);
        }
        return null;
    }

    /**
     * 执行HTTP GET请求
     * @param url url
     * @param param 参数
     * @return
     */
    public static String httpGetWithJSON(String url, Map<String, ?> param) {
        CloseableHttpClient client = null;
        try {
            if(url == null || url.trim().length() == 0){
                throw new Exception("URL is null");
            }
            client = HttpClients.createDefault();
            if(param != null){
                StringBuffer sb = new StringBuffer("?");
                for (String key : param.keySet()){
                    sb.append(key).append("=").append(param.get(key)).append("&");
                }
                url = url.concat(sb.toString());
                url = url.substring(0, url.length()-1);
            }
            HttpGet httpGet = new HttpGet(url);
            HttpResponse resp = client.execute(httpGet);
            if(resp.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(resp.getEntity(), DEFAULT_CHARSET);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(client);
        }
        return null;
    }

    /**
     * 关闭HTTP请求
     * @param client
     */
    private static void close(CloseableHttpClient client){
        if(client == null){
            return;
        }
        try {
            client.close();
        } catch (Exception e) {
        }
    }

    /**
     *  遍历Json 兼容多层级的Json
     *
     *  需要考虑的就是 JSONObject 和 JSONArray 两种情况，
     *
     *  对这两种情况做处理，采用递归向下遍历，用instanceof判断递归到的类型，做不同处理
     *
     * @param object
     */

    private static void jsonLoop(Object object) {

        if(object instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) object;
            for (Map.Entry<String, Object> entry: jsonObject.entrySet()) {
                Object o = entry.getValue();
                if(o instanceof String) {
                    log.info("--------------------->Key：" + entry.getKey() + "  对应的Value为： " + entry.getValue());
                } else {
                    jsonLoop(o);
                }
            }
        }

        if(object instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) object;
            for (int i = 0; i < jsonArray.size(); i ++) {
                jsonLoop(jsonArray.get(i));
            }
        }
    }

    /**
     * 判断第一个Json中Key是否包含第二个Json中Key，包含则替换指定Key 的 Value
     * @param object1
     * @param object2
     */
    private static JSONObject compareJson(Object object1, Object object2) {
        //遍历第二个Json Key，在第一个Json中取对应Key，替换对应的Value
        if(object1 instanceof JSONObject && object2 instanceof JSONObject) {
            JSONObject jsonObject1 = (JSONObject) object1;
            JSONObject jsonObject2 = (JSONObject) object2;
            for (Map.Entry<String, Object> entry: jsonObject2.entrySet()) {
                Object o2 = entry.getValue();
                if(o2 instanceof String) {
                    log.info("--------------------->期望替换内容：Key：" + entry.getKey() + "  对应的Value为： " + entry.getValue());
                    jsonObject1.put(entry.getKey(), entry.getValue());
                    log.info("--------------------->已经替换内容：Key：" + entry.getKey() + "  对应的Value为： " + jsonObject1.get(entry.getKey()));

                } else {
                    compareJson(jsonObject1.get(entry.getKey()), o2);
                }
            }
            return jsonObject1;
        }

        //TODO: JsonArray替换逻辑待完善
        if(object2 instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) object2;
            for (int i = 0; i < jsonArray.size(); i ++) {
                jsonLoop(jsonArray.get(i));
            }
            return null;
        }
        return null;
    }

}
