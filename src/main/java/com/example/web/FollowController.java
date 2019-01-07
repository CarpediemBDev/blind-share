package com.example.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Follow;
import com.example.service.FollowService;
import com.example.service.LoginUserDetails;

@Controller
@RequestMapping("follows")
public class FollowController {
    @Autowired
    FollowService followService;
    
    @ModelAttribute
    FollowForm setUpForm() {
    	return new FollowForm();
    }
    
    @RequestMapping(method = RequestMethod.GET)
    String list(@AuthenticationPrincipal LoginUserDetails userDetails, Model model) {
    	List<Follow> follows = followService.findAll(userDetails.getUsername());
    	model.addAttribute("users",follows);
    	return "follows/userList";    	
    }
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated FollowForm form, BindingResult result, Model model,
                  @AuthenticationPrincipal LoginUserDetails userDetails) {

        Follow follow = new Follow();
        BeanUtils.copyProperties(form, follow);
        followService.create(follow, userDetails.getUsername());
        return "redirect:/follows";
    }
    
   
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    String edit(@RequestParam String userFormName, @AuthenticationPrincipal LoginUserDetails userDetails) {
    	followService.delete(userDetails.getUsername(), userFormName);
    	return "redirect:/follows";
    }
}
