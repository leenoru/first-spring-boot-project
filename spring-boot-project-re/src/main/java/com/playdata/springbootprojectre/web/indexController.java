package com.playdata.springbootprojectre.web;

import com.playdata.springbootprojectre.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class indexController {
    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model) {
        // Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
        model.addAttribute("posts", postsService.findAllDesc());
        return "index"; // /src/main/resources/templates/ + "index" + .mustache 를 viewresolver가 완성해줌
    }
    @GetMapping("/posts/save")
    public String savePost() {
        return "posts-save";
    }

    @GetMapping("/posts/{id}")
    public String updatePost(Model model, @PathVariable Long id) {
        model.addAttribute("post", postsService.findById(id));
        return "posts-update";
    }
}
