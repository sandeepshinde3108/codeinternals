package com.codeinternals.microservices.datamodel.service;

import com.codeinternals.microservices.datamodel.entity.Post;
import com.codeinternals.microservices.datamodel.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class PostService implements CrudOperations<Post> {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post post) {
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    @Override
    public Post get(long id) {
        return postRepository.getById(id);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public void delete(long id) {
        try {
            postRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
