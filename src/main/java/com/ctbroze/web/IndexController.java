package com.ctbroze.web;


import com.ctbroze.config.auth.LoginUser;
import com.ctbroze.config.auth.dto.SessionUser;
import com.ctbroze.domain.posts.Posts;
import com.ctbroze.service.PostsService;
import com.ctbroze.web.dto.PostsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
        List<PostsListResponseDto> list = postsService.findTop10ByOrderByIdDesc();
        model.addAttribute("postList",list);
        if(user!=null){
            model.addAttribute("userName",user.getName());
        } else{
            model.addAttribute("userName","noLogin");
        }
        return "index";
    }

    @GetMapping("/dailylife")
    public String dailyList(@PageableDefault Pageable pageable, Model model, @LoginUser SessionUser user){
        Page<Posts> postList = postsService.getBoardList(pageable, new Long(1));
        model.addAttribute("postList",postList);
        if(user!=null){
            model.addAttribute("userName",user.getName());
        } else{
            model.addAttribute("userName","noLogin");
        }
        return "dailyLife";
    }

    @GetMapping("/study")
    public String studyList(@PageableDefault Pageable pageable, Model model, @LoginUser SessionUser user){
        Page<Posts> postList = postsService.getBoardList(pageable, new Long(2));
        model.addAttribute("postList",postList);
        if(user!=null){
            model.addAttribute("userName",user.getName());
        } else{
            model.addAttribute("userName","noLogin");
        }
        return "study";
    }

    @GetMapping("/hobby")
    public String hobbyList(@PageableDefault Pageable pageable, Model model, @LoginUser SessionUser user){
        Page<Posts> postList = postsService.getBoardList(pageable, new Long(3));
        model.addAttribute("postList",postList);
        if(user!=null){
            model.addAttribute("userName",user.getName());
        } else{
            model.addAttribute("userName","noLogin");
        }
        return "hobby";
    }

    @GetMapping("/info")
    public String info(Model model,@LoginUser SessionUser user){
        if(user!=null){
            model.addAttribute("userName",user.getName());
        } else{
            model.addAttribute("userName","noLogin");
        }
        return "info";
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
