package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.Utils.FakeUtils;
import com.codingmanstudio.courses.domain.News;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @GetMapping("/news")
    public List<News> news() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        return FakeUtils.getAllNews();
    }

    @GetMapping("/fuck")
    public String quang(){
        return "fuck that shit";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/quill")
    public String quill(){
        return "quill JS";
    }
}
