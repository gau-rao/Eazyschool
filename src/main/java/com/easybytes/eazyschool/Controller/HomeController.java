package com.easybytes.eazyschool.Controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = {" ","/","/Home"})
    public String displayHomepage(Model model){
        model.addAttribute("username","John Doe");
        return "home.html";
    }
}
