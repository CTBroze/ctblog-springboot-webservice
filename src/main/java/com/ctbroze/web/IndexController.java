package com.ctbroze.web;


import com.ctbroze.config.auth.LoginUser;
import com.ctbroze.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        if(user!=null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }
}