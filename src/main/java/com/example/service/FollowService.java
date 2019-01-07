package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Follow;
import com.example.repository.FollowRepository;

@Service
@Transactional
public class FollowService {
    @Autowired
    FollowRepository followRepository;

    public List<Follow> findAll(String username) {
        return followRepository.findAllOrderByName(username);
    }

    public Optional<Follow> findById(Integer id) {
        return followRepository.findById(id);
    }

    public Follow create(Follow follow, String username) {
    	follow.setFollower_id(username);
        return followRepository.save(follow);
    }

    public Follow update(Follow follow, String username) {
    	follow.setFollower_id(username);
        return followRepository.save(follow);
    }

    public void delete(String follower_id, String followed_id) {
    	followRepository.deleteFollow_id(follower_id, followed_id);
    }
}
