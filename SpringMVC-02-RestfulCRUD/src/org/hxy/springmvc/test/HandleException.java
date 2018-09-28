package org.hxy.springmvc.test;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView testArithmeticException(Exception e) {
        System.out.println("---->出错了：" + e);
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception",e);
        return modelAndView;
    }
}
