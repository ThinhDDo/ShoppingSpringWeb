package com.spring.exam.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.exam.sys.model.UserInfo;
import com.spring.exam.sys.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	/**
	 * Welcome page, Profile page
	 * @param model
	 * @return
	 */
	@GetMapping(value= {"/", "/index"})
	public String profile(Model model, Authentication auth) {
		User loginUser = (User) auth.getPrincipal();
		
		UserInfo userProfile = userService.selectUserByName(loginUser.getUsername());
		model.addAttribute("profile", userProfile);
		
		return "index";
	}
	
	
}
