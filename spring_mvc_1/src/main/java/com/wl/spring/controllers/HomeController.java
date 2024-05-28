package com.wl.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wl.spring.models.User;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}

	@GetMapping("/welcome")
	public String welcome(Model model) {
		return "welcome";
	}
}
