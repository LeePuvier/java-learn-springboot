package com.leepuvier.learn.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CompanyProperties {

    @Value("${www.leepuvier.com.companyName}")
    private String companyName;

    @Value("${www.leepuvier.com.companyAddress}")
    private String companyAddress;

    @Value("${www.leepuvier.com.companyUrl}")
    private String companyUrl;

    @Value("www.leepuvier.com.companyNumber")
    private String companyNumber;

    @Value("${www.leepuvier.com.emploeeIndex}")
    private String emploeeIndex;

    @Value("${random.int}")
    private String emploeeNumber;

    @Value("${www.leepuvier.com.companyDesc}")
    private String companyDesc;

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }


    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public String getEmploeeIndex() {
        return emploeeIndex;
    }

    public String getEmploeeNumber() {
        return emploeeNumber;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public void setEmploeeIndex(String emploeeIndex) {
        this.emploeeIndex = emploeeIndex;
    }

    public void setEmploeeNumber(String emploeeNumber) {
        this.emploeeNumber = emploeeNumber;
    }
}
