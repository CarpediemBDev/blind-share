package com.example.web;

import java.util.List;

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

import com.example.domain.User;
import com.example.service.LoginUserDetails;
import com.example.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
    
    @ModelAttribute
    UserForm setUpForm() {
    	return new UserForm();
    }
    
    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
    	List<User> users = userService.findAll();
    	model.addAttribute("users",users);
    	return "users/userList";    	
    }
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated UserForm form, BindingResult result, Model model,
                  @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return list(model);
        }
        User user = new User();
        BeanUtils.copyProperties(form, user);
        userService.create(user, userDetails.getUsername());
        return "redirect:/users";
    }
    
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    String edit(@RequestParam String id) {
    	userService.delete(id);
    	return "redirect:/users";
    }
}
