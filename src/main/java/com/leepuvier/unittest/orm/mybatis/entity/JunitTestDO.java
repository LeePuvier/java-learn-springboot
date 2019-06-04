package com.leepuvier.unittest.orm.mybatis.entity;

import java.time.LocalDateTime;

public class JunitTestDO {

    public JunitTestDO(){

    }

    public JunitTestDO(Integer id, String caseName, Integer caseResult, String caseResultDec) {
        this.id = id;
        this.caseName = caseName;
        this.caseResult = caseResult;
        this.caseResultDec = caseResultDec;
        this.caseStartTime = LocalDateTime.now();
        this.caseEndTime = LocalDateTime.now();
    }

    /**
     *   用例ID
     */
    private Integer id;

    /**
     *  用例名称
     */

    private String caseName;

    /**
     *  用例执行结果
     */

    private Integer caseResult;

    /**
     *  用例执行结果描述/原因
     */

    private String caseResultDec;

    /**
     *  用例执行开始时间
     */

    private LocalDateTime caseStartTime;


    /**
     *  用例执行结束时间
     */

    private LocalDateTime caseEndTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public Integer getCaseResult() {
        return caseResult;
    }

    public void setCaseResult(Integer caseResult) {
        this.caseResult = caseResult;
    }

    public String getCaseResultDec() {
        return caseResultDec;
    }

    public void setCaseResultDec(String caseResultDec) {
        this.caseResultDec = caseResultDec;
    }

    public LocalDateTime getCaseStartTime() {
        return caseStartTime;
    }

    public void setCaseStartTime(LocalDateTime caseStartTime) {
        this.caseStartTime = caseStartTime;
    }

    public LocalDateTime getCaseEndTime() {
        return caseEndTime;
    }

    public void setCaseEndTime(LocalDateTime caseEndTime) {
        this.caseEndTime = caseEndTime;
    }


}
