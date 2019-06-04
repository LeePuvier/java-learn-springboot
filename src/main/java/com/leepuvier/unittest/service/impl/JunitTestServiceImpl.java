package com.leepuvier.unittest.service.impl;

import com.leepuvier.unittest.orm.mybatis.entity.JunitTestDO;
import com.leepuvier.unittest.orm.mybatis.mapper.JunitTestMapper;
import com.leepuvier.unittest.service.JunitTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class JunitTestServiceImpl implements JunitTestService {

    @Autowired
    private JunitTestMapper junitTestMapper;

    @Override
    public JunitTestDO getJunitTestById(@NotNull Integer id) {
        return junitTestMapper.getJunitTestById(id);
    }

    @Override
    public JunitTestDO getJunitTestByCaseName(@NotNull String caseName) {
        return junitTestMapper.getJunitTestByCaseName(caseName);
    }

    @Override
    public List<JunitTestDO> getJunitTestList(Integer caseResult) {
        return junitTestMapper.getJunitTestList(caseResult);
    }

    @Override
    public Integer saveJunitTest(@NotNull Integer id, @NotNull String caseName, @NotNull Integer caseResult, @NotNull String caseResultDec) {
        JunitTestDO junitTestDO = new JunitTestDO();
        junitTestDO.setId(id);
        junitTestDO.setCaseName(caseName);
        junitTestDO.setCaseResult(caseResult);
        junitTestDO.setCaseResultDec(caseResultDec);
//        junitTestDO.setCaseStartTime(caseStartTime);
//        junitTestDO.setCaseEndTime(caseEndTime);
        return junitTestMapper.inserJunitTest(junitTestDO);
    }



    @Override
    public boolean updateById(@NotNull Integer id, @NotNull String caseName, @NotNull Integer caseResult, @NotNull String caseResultDec) {
        JunitTestDO junitTestDO = junitTestMapper.getJunitTestById(id);
        junitTestDO.setCaseName(caseName);
        junitTestDO.setCaseResult(caseResult);
        junitTestDO.setCaseResultDec(caseResultDec);
        return junitTestMapper.updateById(junitTestDO) > 0;
    }

}
