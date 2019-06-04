package com.leepuvier.unittest.service;

import com.leepuvier.unittest.orm.mybatis.entity.JunitTestDO;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface JunitTestService  {

    /**
     * 依据ID获取Case
     * @param id
     * @return
     */
    JunitTestDO getJunitTestById(@NotNull Integer id);


    /**
     * 依据caseName获取Case
     * @param caseName
     * @return
     */

    JunitTestDO getJunitTestByCaseName(@NotNull String caseName);


    /**
     * 依据执行结果获取列表
     * @param caseResult
     * @return
     */
    List<JunitTestDO> getJunitTestList(Integer caseResult);


    /**
     * 新增
     * @param id
     * @param caseName
     * @param caseResult
     * @param caseResultDec
     * @return
     */

    Integer saveJunitTest(Integer id, String caseName, Integer caseResult, String caseResultDec);


    /**
     * 更新-依据ID更新
     * @param id
     * @return
     */
    boolean updateById(@NotNull Integer id, @NotNull String caseName, @NotNull Integer caseResult, @NotNull String caseResultDec);
}
