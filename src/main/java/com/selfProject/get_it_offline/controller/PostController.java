package com.selfProject.get_it_offline.controller;

import com.selfProject.get_it_offline.entity.PostEntity;
import com.selfProject.get_it_offline.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostEntity> getAllPosts() {
        return postService.findAll();
    }

    @PostMapping
    public void createPost(@RequestBody PostEntity postEntity) {
        postService.save(postEntity);
    }
}