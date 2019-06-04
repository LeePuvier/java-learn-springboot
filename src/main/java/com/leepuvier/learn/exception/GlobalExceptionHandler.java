package com.leepuvier.learn.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest hsr, Exception e) throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e);
        mv.addObject("url", hsr.getRequestURL());
        mv.setViewName("error");
        return mv;
    }

    @ExceptionHandler(value = MyException.class)
    public ErroExceptionInfo<String> jsonErrorHandler(HttpServletRequest hsr, Exception e){
        ErroExceptionInfo<String> errorInfo = new ErroExceptionInfo<>();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setCode(ErroExceptionInfo.ERROR);
        errorInfo.setData("Some data");
        errorInfo.setUrl(hsr.getRequestURL().toString());
        return errorInfo;
    }
}
