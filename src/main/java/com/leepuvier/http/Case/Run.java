package com.leepuvier.http.Case;

import com.leepuvier.http.common.BaseProvider;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.leepuvier.http.utils.HttpClientUtil.httpGetWithJSON;
import static com.leepuvier.http.utils.HttpClientUtil.httpPostWithJSON;

/**
 * @Author : LeePuvier
 * @CreateTime : 2019/12/24  4:26 PM
 * @ContentUse :
 */
@Slf4j
public class Run {


    @Test
    public void getParam() throws Exception {
        Map param = new HashMap();
        param.put("userName", "admin");
        param.put("password", "mao2080");
        String result = httpGetWithJSON("https://www.baidu.com/", param);
        System.out.println("result:" + result);
    }


    @Test(dataProvider = "createOrder", dataProviderClass = BaseProvider.class, description = "创建订单")
    public void postExcel(Map<String, Object> params){
        String caseComment = params.get("Comment").toString();
        String url = params.get("serviceEnv").toString() + params.get("url").toString();
        String baseParamJson = params.get("baseParamJson").toString();
        String expectParamJson = params.get("expectParamJson").toString();
        String exectResult = params.get("exectResult").toString();
        log.info("---------------------> 用例功能描述为：" + caseComment);

        String result = httpPostWithJSON(url, baseParamJson, expectParamJson);
        log.info("---------------------> 期望接口返回为：" + exectResult);
        log.info("---------------------> 接口实际返回为：" + result);
        Assert.assertEquals(result, exectResult);

    }
}
