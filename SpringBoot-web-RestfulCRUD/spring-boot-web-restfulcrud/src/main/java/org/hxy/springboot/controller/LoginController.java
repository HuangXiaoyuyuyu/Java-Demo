package org.hxy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && password.equals("123456")) {
            session.setAttribute("exitUser",username);
            //登陆成功，防止表单重复提交，可以进行重定向
            return "redirect:/main.html";
        }else {
            //登录失败
            map.put("msg","用户名或者密码不正确");
            return "login";
        }
    }
}
