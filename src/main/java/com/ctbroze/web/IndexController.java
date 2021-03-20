package com.ctbroze.web;


import com.ctbroze.config.auth.LoginUser;
import com.ctbroze.config.auth.dto.SessionUser;
import com.ctbroze.service.PostsService;
import com.ctbroze.web.dto.PostsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    @Autowired
    PostsService postsService;
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        List<PostsListResponseDto> list = postsService.findAllDesc();
        model.addAttribute("postList",list);
        if(user!=null){
            model.addAttribute("userName",user.getName());
        } else{
            model.addAttribute("userName","noLogin");
        }
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/loginError")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        return "login";
    }
}
