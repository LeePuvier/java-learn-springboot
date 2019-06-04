package com.leepuvier.web;

import com.leepuvier.unittest.orm.mybatis.entity.JunitTestDO;
import com.leepuvier.unittest.service.impl.JunitTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcase")
public class JunitTestController {


    @Autowired
    private JunitTestServiceImpl junitTestServiceImpl;

    @GetMapping("/getJunitTestById")
    public JunitTestDO getJunitTestById(Integer id){
        JunitTestDO junitTestDO = null;
        if(id != null){

            junitTestDO = junitTestServiceImpl.getJunitTestById(id);
            if (junitTestDO != null && !junitTestDO.equals("")){
                return junitTestDO;
            }
        }
        return junitTestDO;
    }

    @GetMapping("/getJunitTestByCaseName")
    public JunitTestDO getJunitTestByCaseName(String caseName){
        JunitTestDO junitTestDO = null;
        if(caseName != null && !caseName.equals("")) {
            junitTestDO = junitTestServiceImpl.getJunitTestByCaseName(caseName);
            return junitTestDO;
        }
        return junitTestDO;
    }

    @GetMapping("/getJunitTestList")
    public List<JunitTestDO> getJunitTestList(Integer caseResult){
        List<JunitTestDO> junitTestDOList = null;
        if(caseResult != null){
            junitTestDOList = junitTestServiceImpl.getJunitTestList(caseResult);
            return junitTestDOList;
        }
        return junitTestDOList;
    }


    @RequestMapping(value = "/updateJunitTestById", method = RequestMethod.POST)
    public boolean updateJunitTestById(@RequestParam(value = "id", required = true)  Integer id, Integer caseResult, String caseName, String caseResultDec){
        boolean junitTestDO = false;
        if(id != null && caseName != null && !caseName.equals("")) {

            return junitTestServiceImpl.updateById(id, caseName, caseResult, caseResultDec);
        }
        return junitTestDO;
    }

    @RequestMapping(value = "/createJunitTest", method = RequestMethod.POST)
    public Integer createJunitTest(@RequestParam(value = "id", required = true)  Integer id, Integer caseResult, String caseName, String caseResultDec){
            return  junitTestServiceImpl.saveJunitTest(id, caseName, caseResult, caseResultDec);
    }


}
