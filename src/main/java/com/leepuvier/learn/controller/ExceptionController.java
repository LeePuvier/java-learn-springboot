package com.leepuvier.learn.controller;

import com.leepuvier.learn.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    @RequestMapping("/exception/default")
    public String exceptionDefault() throws Exception{
        throw  new Exception("Default Exception");
    }


    @RequestMapping("/exception/define")
    public String exceptionDefine() throws MyException{
        throw new MyException("Define Exception");
    }
}
