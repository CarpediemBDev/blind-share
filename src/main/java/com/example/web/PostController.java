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

import com.example.domain.Post;
import com.example.service.LoginUserDetails;
import com.example.service.PostService;

@Controller
@RequestMapping("posts")
public class PostController {
    @Autowired
    PostService postService;
    
    @ModelAttribute
    PostForm setUpForm() {
    	return new PostForm();
    }
    
    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
    	List<Post> posts = postService.findAll();
    	model.addAttribute("posts",posts);
    	return "posts/postList";    	
    }
    
    @RequestMapping(value = "create", params = "form", method = RequestMethod.GET)
    String createForm(@AuthenticationPrincipal LoginUserDetails userDetails, Model model) {
    	Post post = new Post();
    	model.addAttribute("post", post);
    	model.addAttribute("user",userDetails.getUser());
    	model.addAttribute("page", "create");
    	return "posts/editPost";
    }
    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated PostForm form, BindingResult result, Model model,
                  @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return list(model);
        }
        Post post = new Post();
        BeanUtils.copyProperties(form, post);
        post.setUsername(userDetails.getUsername());
        postService.create(post);
        return "redirect:/posts";
    }
    
    @RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
    String editForm(@RequestParam Integer id, @AuthenticationPrincipal LoginUserDetails userDetails,
    				Model model) {
    	Optional<Post> post = postService.findById(id);
    	model.addAttribute("post", post);
    	model.addAttribute("user",userDetails.getUser());
    	model.addAttribute("page", "edit");
    	return "posts/editPost";
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    String edit(@RequestParam Integer id, @Validated PostForm form, BindingResult result,
    		@AuthenticationPrincipal LoginUserDetails userDetails, Model model) {
    	if(result.hasErrors()) {
    		return editForm(id,userDetails,model);
    	}
    	Post post = new Post();
    	BeanUtils.copyProperties(form, post);
    	post.setId(id);
    	post.setUsername(userDetails.getUsername());
    	postService.update(post);
    	return "redirect:/posts";
    }
    
    @RequestMapping(value = "edit", params = "goToTop")
    String goToTop() {
    	return "redirect:/posts";
    }
    
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    String edit(@RequestParam Integer id) {
    	postService.delete(id);
    	return "redirect:/posts";
    }
}
