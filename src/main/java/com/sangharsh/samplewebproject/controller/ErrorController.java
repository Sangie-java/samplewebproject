package com.sangharsh.samplewebproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("error")
public class ErrorController {
    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(HttpServletRequest request, Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", exception.getStackTrace());
        modelAndView.addObject("url", request.getRequestURI());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
