package org.hxy.shiro.handlers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.hxy.shiro.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shiro")
public class ShiroHandler {

    @Autowired
    private ShiroService shiroService;

    @RequestMapping("/testShiroAnnotation")
    public String testShiroAnnotation(HttpSession session) {
        session.setAttribute("key","value12345");
        shiroService.testShiroAnnotation();
        return "redirect:/list.jsp";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            token.setRememberMe(true);
           try {
               System.out.println("1." + token.hashCode());
               currentUser.login(token);
           }catch (Exception e) {
               System.out.println("登录失败：" + e.getMessage());
           }
        }
        return "redirect:/list.jsp";
    }

}
