package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Post;
import com.example.repository.NewsFeedRepository;

@Service
@Transactional
public class NewsFeedService {
    @Autowired
    NewsFeedRepository newsFeedRepository;

    public List<Post> findAll(String follower_id) {
        return newsFeedRepository.findAllOrderByName(follower_id);
    }
}
