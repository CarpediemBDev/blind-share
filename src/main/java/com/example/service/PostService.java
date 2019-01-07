package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Post;
import com.example.domain.User;
import com.example.repository.PostRepository;

@Service
@Transactional
public class PostService {
    @Autowired
    PostRepository postRepository;
    
    public List<Post> findAll() {
        return postRepository.findAllOrderByName();
    }

    public Optional<Post> findById(Integer id) {
        return postRepository.findById(id);
    }

    public Post create(Post post) {
        return postRepository.save(post);
    }

    public Post update(Post post) {
        return postRepository.save(post);
    }

    public void delete(Integer id) {
        postRepository.deleteById(id);
    }
}
