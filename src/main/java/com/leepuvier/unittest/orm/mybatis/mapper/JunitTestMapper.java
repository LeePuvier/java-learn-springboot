package com.leepuvier.unittest.orm.mybatis.mapper;

import com.leepuvier.unittest.orm.mybatis.entity.JunitTestDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Mapper
public interface JunitTestMapper {

    /**
     *  依据ID获取
     */

    JunitTestDO getJunitTestById(@RequestParam(value = "id") Integer id);


    /**
     *  依据caseName获取
     */

    JunitTestDO getJunitTestByCaseName(@RequestParam(value = "caseName") String caseName);


    /**
     *  获取列表
     */

    List<JunitTestDO> getJunitTestList(Integer caseResult);


    /**
     *  插入
     */

    int inserJunitTest(JunitTestDO junitTestDO);


    /**
     *  更新-依据Id更新
     */

    int updateById(JunitTestDO junitTestDO);
}
