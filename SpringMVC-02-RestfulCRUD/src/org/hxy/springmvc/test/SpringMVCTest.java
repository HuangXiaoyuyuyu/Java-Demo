package org.hxy.springmvc.test;

import org.hxy.springmvc.dao.EmployeeDao;
import org.hxy.springmvc.model.Employee;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

@Controller
public class SpringMVCTest {

    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private ResourceBundleMessageSource messageSource;

    @ResponseStatus(reason = "测试",value = HttpStatus.NOT_FOUND)
    @RequestMapping("/testResponseStatusExceptionResolver")
    public String testResponseStatusExceptionResolver(@RequestParam("i") int i) {
        if (i == 13) {
            throw new UserNameNotMatchPasswordException();
        } else {
            System.out.println("testResponseStatusExceptionResolver...");
        }
        return "success";
    }

//    @ExceptionHandler(value = ArithmeticException.class)
//    public ModelAndView testArithmeticException(Exception e) {
//        System.out.println("出错了：" + e);
//        ModelAndView modelAndView = new ModelAndView("error");
//        modelAndView.addObject("exception",e);
//        return modelAndView;
//    }

    @RequestMapping("/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i) {
        System.out.println(10/i);
        return "success";
    }

    @RequestMapping("/testFileUpLoad")
    public String testFileUpLoad(@RequestParam("desc") String desc,
                                 @RequestParam("file")MultipartFile  file) throws IOException {
        System.out.println("desc:" + desc);
        System.out.println(" file.getOriginalFilename:" + file.getOriginalFilename());
        System.out.println(" file.getInputStream:" + file.getInputStream());
        return "success";
    }

    @RequestMapping("/i18n")
    public String testI18n(Locale locale) {
        String val = messageSource.getMessage("i18n.user",null,locale);
        System.out.println(val);
        return "i18n";
    }

    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("files/abc.txt");
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename=abc.txt");

        HttpStatus httpStatus = HttpStatus.OK;

        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body,headers,httpStatus);
        return response;
    }

    @ResponseBody
    @RequestMapping("/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body) {
        System.out.println(body);
        return "helloworld" + new Date();
    }

    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson() {
        return employeeDao.getAll();
    }

    @RequestMapping("/testConversionServiceConverter")
    public String testConversionServiceConverter(@RequestParam("employee") Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
