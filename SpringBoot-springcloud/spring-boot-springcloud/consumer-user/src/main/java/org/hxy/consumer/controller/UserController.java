package org.hxy.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/buy")
    public String buy() {
        String s = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
        return "购买了：" + s;
    }

}
