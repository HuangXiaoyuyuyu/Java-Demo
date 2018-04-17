package org.hxy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

//    @RequestMapping({"/","index.html"})
//    public String index() {
//        return "login";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {

        return "Hello World";
    }


    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("hello","<h1>HelloWorld</h1>");
        map.put("users", Arrays.asList("张三","李四","王五"));
        return "success";
    }

}
