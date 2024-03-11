package com.codeinternals.microservices.postservice.controller;

import com.codeinternals.microservices.datamodel.entity.Post;
import com.codeinternals.microservices.datamodel.service.PostService;
import com.codeinternals.microservices.postservice.dto.PostDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
@CrossOrigin
public final class PostController {

    private Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        logger.info("Creating Post with {}", postDto.toString());
        Post post = mapper.map(postDto, Post.class);
        Post savedPost = postService.save(post);
        postDto = mapper.map(savedPost, PostDto.class);
        return ResponseEntity.ok(postDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable long id){
        logger.info("Getting Post with {}", id);
        Post post = postService.get(id);
        PostDto postDto = mapper.map(post, PostDto.class);
        return ResponseEntity.ok(postDto);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(){
        logger.info("Getting all Posts");
        List<PostDto> posts = new ArrayList<>();
        postService.getAll().forEach(x -> posts.add(mapper.map(x, PostDto.class)));
        return ResponseEntity.ok(posts);
    }
}
