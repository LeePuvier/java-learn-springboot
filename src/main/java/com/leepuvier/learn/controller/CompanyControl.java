package com.leepuvier.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class CompanyControl {
    /**
     * 公司-新增：companyAdd
     */

    @RequestMapping("/companyAdd")
    public Map<String, String> companyAdd(String address, String companyValue){
        Map<String, String> companyAddInfos = new HashMap<String, String>();
        companyAddInfos.put(address, companyValue);
        return companyAddInfos;
    }

    /**
     * 公司-查询：companyAuery
     */

    @RequestMapping("/companyQuery")
    public String companyList(Map<String, String> companyMap, String companyAddress, String companyName){

        String companyInfo = "";

        if (null != companyAddress && !companyAddress.equals("") && null != companyName && !companyName.equals("")){

            companyInfo = companyMap.get(companyAddress);

            if (companyInfo.equals(companyName)){
                return companyInfo;
            }
        }
        return companyInfo;
    }

    @ResponseBody
    @RequestMapping("/index")
    public String index(){return "Hello Leepuvier, Spring Boot";}

    @RequestMapping("/thymeleaf")
        public String thymeleaf(ModelMap map) {
            map.addAttribute("hello", "Hello World");
            return "thymeleaf";
    }

    @RequestMapping("/freemarker")
    public String freemarker(ModelMap map) {
        map.addAttribute("host", "http://www.leepuvier.com");
        return "freemarker";
    }

    @RequestMapping("/velocity")
    public String velocity(ModelMap map) {
        map.addAttribute("page", "http://www.leepuvier.com");
        return "velocity";
    }
}
