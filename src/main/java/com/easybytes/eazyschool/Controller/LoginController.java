package com.easybytes.eazyschool.Controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LoginController {

    @RequestMapping(value="/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String displayLoginPage(@RequestParam(value = "error", required = false)  String error, @RequestParam(value = "logout",required = false) String logout, Model model){
        String errorMessage =null;
        if(error!= null){
            errorMessage="UserName or Password is Incorrect !!";
        }
        if(logout!= null){
            errorMessage="You have been successfully Logged out !!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest req, HttpServletResponse res){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth !=null){
            new SecurityContextLogoutHandler().logout(req, res, auth);
        }
        return "redirect:/login?logout=true";
    }

}
