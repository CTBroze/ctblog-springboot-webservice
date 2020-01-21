package net.ctblog.web;

import lombok.RequiredArgsConstructor;
import net.ctblog.config.auth.LoginUser;
import net.ctblog.config.auth.dto.SessionUser;
import net.ctblog.domain.posts.Posts;
import net.ctblog.service.PostsService;
import net.ctblog.web.dto.PostsListResponseDto;
import net.ctblog.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        List<PostsListResponseDto> list = postsService.findAllDesc();
        model.addAttribute("posts",list);
        if(user!=null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "about";
    }

    @GetMapping("/posting")
    public String posting(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts",postsService.findAllDesc());
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "posting";
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model,@LoginUser SessionUser user){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        if(user!=null){
            if(!dto.getAuthor().equals(user.getName())){
                return "update-error";
            }
            model.addAttribute("userName",user.getName());
        }
        return "posts-update";
    }

    @GetMapping("/posts/read/{id}")
    public String postRead(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "post";
    }
}
