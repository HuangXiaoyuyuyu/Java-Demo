package SpringBoot_MybatisPlus.controller;

import SpringBoot_MybatisPlus.bean.User;
import SpringBoot_MybatisPlus.service.UserService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    //跳转到登录界面
    @GetMapping({"","login"})
    public String toLogin() {
        return "login";
    }

    //跳转到注册界面
    @GetMapping("/register")
    public String toRegister() {
        return "register";
    }

    //检验用户名是否已经存在
    @PostMapping("/checkLoginName")
    @ResponseBody
    public String checkLoginName(String username) {
        Integer countByName = userService.getCountByName(username);
        if (countByName > 0)
            return "false";
        return "true";
    }

   /* //注册成功之后跳转到登录界面
    //文件后台上传(单文件)
    @PostMapping("/register_form")
    public String register(User user,
                           HttpServletRequest request,
                           HttpSession session) throws IOException {
        MultipartFile upload = user.getUpload();
        //System.out.println(upload.getBytes());  //获取文件数据
        System.out.println(upload.getContentType());    //获取文件MIME类型，如image/jpeg等
        System.out.println(upload.getName());   //获取表单中文件组件的名字
        System.out.println(upload.getOriginalFilename());   //获取上传文件的原名
        System.out.println(upload.getSize());   //获取文件的字节大小，单位为byte
        //System.out.println(upload.isEmpty());   //是否有上传文件
        //System.out.println(upload.getInputStream());    //获取文件流
        //如果文件不为空，写入上传路径
        if (!upload.isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/static/images/");
            //上传文件名
            String fileName = upload.getOriginalFilename();
            File filePath = new File(path,fileName);
            //判断路径是否存在，如果不存在就创建一个
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            upload.transferTo(new File("E:\\MrHuang\\IDEA\\springboot_thymeleaf_mybatisplus_shiro_jquery_ajax\\src\\main\\resources\\static\\images\\" + File.separator + fileName));
            //upload.transferTo(new File(path + File.separator + fileName));
            session.setAttribute("upload",upload.getOriginalFilename());
            user.setIcon("/static/images/" + fileName);
        }
        userService.saveUser(user);
        return "redirect:login";
    }*/


   //抽取保存文件的方法
    private boolean saveFile(HttpServletRequest request,
                             MultipartFile file) {
        if (!file.isEmpty()) {
            String path = request.getServletContext().getRealPath("/static/images");
            String fileName = file.getOriginalFilename();
            File filePath = new File(path,fileName);
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            try {
                file.transferTo(new File(path + File.separator + fileName));
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

   //多文件上传
   @PostMapping("/register_form")
   public String register(User user,@RequestParam("upload") MultipartFile[] upload,
                          HttpServletRequest request,
                          HttpSession session) throws IOException {
       if (upload != null && upload.length > 0) {
           for (MultipartFile file : upload) {
               if (file.getOriginalFilename().indexOf(".doc") > 0){
                   session.setAttribute("upload",file.getOriginalFilename());
               }
                saveFile(request,file);
           }
       }
       userService.saveUser(user);
       return "redirect:login";
   }

    //文件下载
    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> download(@PathVariable("fileName") String fileName,
                                       HttpServletRequest request) throws IOException {
        System.out.println("============="+fileName+"============");
        //下载文件路径
        String path = request.getServletContext().getRealPath("/static/images/");
        //File file = new File("E:\\MrHuang\\IDEA\\springboot_thymeleaf_mybatisplus_shiro_jquery_ajax\\src\\main\\resources\\static\\images\\" + File.separator + fileName);
        File file = new File(path + File.separator + fileName);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFilename = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment(下载方式)打开图片
        headers.setContentDispositionFormData("attachment",downloadFilename);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
    }


    /*//注册成功之后跳转到登录界面
    @PostMapping("/register_form")
    public String register(User user) {
        System.out.println(user);
        userService.saveUser(user);
        return "redirect:login";
    }*/

   /* //用户登录 登录失败重定向到登录界面
    @PostMapping("login_form")
    public String login(@RequestParam("login_name") String loginName,
                        @RequestParam("login_password") String password) {
        List<User> users = userService.selectByLogin(loginName, password);
        //users.forEach(System.out::println);
        if (users.size() > 0)
            return "index";
        return "redirect:/login";
    }*/

    @PostMapping("login_form")
    public String login(HttpServletRequest request,
                        HttpSession session,
                        @RequestParam("login_name") String loginName,
                        @RequestParam("login_password") String password) {
        String rememberMe = request.getParameter("rememberMe");
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName,password,Boolean.valueOf(rememberMe));
        if (rememberMe != null) {
            token.setRememberMe(true);
        }
        user.login(token);
        User u = userService.findUserByLoginName(loginName);
        session.setAttribute("icon",StringUtils.isBlank(u.getIcon())? "/static/images/default.jpg" :u.getIcon());
        System.out.println("username:" + user.getSession().getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
        return "index";
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }

    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

   /* @RequiresPermissions("sys:user:addd")
    @GetMapping("/aaa")
    @ResponseBody
    public String aaa() {
        return "aaa";
    }*/
}
