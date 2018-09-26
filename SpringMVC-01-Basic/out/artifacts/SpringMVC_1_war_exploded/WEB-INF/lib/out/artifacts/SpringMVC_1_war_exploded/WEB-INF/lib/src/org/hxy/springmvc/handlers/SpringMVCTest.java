package org.hxy.springmvc.handlers;

import org.hxy.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@SessionAttributes(value = {"user"},types = {String.class})
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
    private static final String SUCCESS = "success";

    @RequestMapping("/testViewAndViewResolver")
    public String testViewAndViewResolver(){
        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }

    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false) Integer id,
                        Map<String,Object> map){
        if (id != null) {
            User user = new User(1,"Tom","123456","123456@qq.com",22);
            map.put("user",user);
        }
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println(user);
        return SUCCESS;
    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String,Object> map) {
        User user = new User("Tom","123123","253757635@qq.com",15);
        map.put("user",user);
        map.put("string","hahaah");
        return SUCCESS;
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("names", Arrays.asList("Tom","Jerry","mike"));
        System.out.println(map.getClass().getName());
        return SUCCESS;
    }

    @RequestMapping("/ModelAndView")
    public ModelAndView testModelAndView(){
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("time",new Date());
        return modelAndView;
    }

    @RequestMapping("/testServletAPI Write")
    public void testServletAPIWrite(Writer writer) throws IOException {
        writer.write("hello springmvc");
    }

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request,
                                 HttpServletResponse response){
        System.out.println("testServletAPI:request:" + request +",response:"+response);
        return SUCCESS;
    }

    @RequestMapping("/testPOJO")
    public String testPOJO(User user){
        System.out.println("testPOJO:"+user);
        return SUCCESS;
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId){
        System.out.println("testCookieValue:sessionID :" + sessionId);
        return SUCCESS;
    }

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String username,
        @RequestParam(value = "age" , required = false, defaultValue = "0")  int age){
        System.out.println("testRequestParam:username:" + username + ";age:"+age);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest Put/{id}",method = RequestMethod.PUT)
    public String testRestPut(@PathVariable("id") Integer id){
        System.out.println("testRest Put:" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest Delete/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable("id") Integer id){
        System.out.println("testRest Delete:" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest Post",method = RequestMethod.POST)
    public String testRestPost(){
        System.out.println("testRest Post");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest Get/{id}",method = RequestMethod.GET)
    public String testRestGet(@PathVariable("id") Integer id){
        System.out.println("testRestGet:" + id);
        return SUCCESS;
    }

    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable:"+ id);
        return SUCCESS;
    }

    @RequestMapping("/*/testAntUrl")
    public String testAntUrl(){
        System.out.println("testAntUrl");
        return SUCCESS;
    }

    @RequestMapping(value = "/testParamsAndHeaders",
            params = {"username","age!=10"},headers = {})
    public String testParamsAndHeaders() {
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    @RequestMapping(value = "/testMethod",method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return SUCCESS;
    }

    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("testRequestMapping");
        return SUCCESS;
    }
}
