package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Post;
import com.example.service.LoginUserDetails;
import com.example.service.NewsFeedService;

@Controller
@RequestMapping("newsfeeds")
public class NewsFeedController {
    @Autowired
    NewsFeedService newsFeedService;
    
    @RequestMapping(method = RequestMethod.GET)
    String list(@AuthenticationPrincipal LoginUserDetails userDetails
    			, Model model) {
    	List<Post> newsfeeds = newsFeedService.findAll(userDetails.getUsername());
    	model.addAttribute("posts",newsfeeds);
    	return "newsfeeds/newsFeedList";    	
    }
}
