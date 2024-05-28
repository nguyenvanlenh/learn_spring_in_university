package com.wl.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wl.spring.models.User;
import com.wl.spring.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userDetailsService;
	

	@GetMapping("/user/add")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "user-add";
	}

	@PostMapping("/user/add")
	public String addUser(@ModelAttribute User user) {

		return userDetailsService.add(user) ? "redirect:/login" : "addUser";
	}

}
