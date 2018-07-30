package SpringBootWebJsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/aaaaa")
    public String aaaaa(Model model) {
        model.addAttribute("aaaaa","我爱中国");
        return "success";
    }

}
