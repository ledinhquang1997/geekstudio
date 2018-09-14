package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.Utils.FakeUtils;
import com.codingmanstudio.courses.domain.News;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @GetMapping("/news")
    public List<News> news() {
        return FakeUtils.getAllNews();
    }

    @GetMapping("/fuck")
    public String quang(){
        return "fuck that shit";
    }

    @GetMapping("/quill")
    public String quill(){
        return "quill JS";
    }
}
