package com.wl.spring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wl.spring.models.User;
import com.wl.spring.models.request.LoginRequest;
import com.wl.spring.services.AuthService;
import com.wl.spring.services.UserService;
import com.wl.spring.validators.WebAppValidator;

@Controller
public class AuthController {

	@Autowired
	private AuthService accountService;
	
	@Autowired
	private UserService userDetailsService;
	@Autowired
    private WebAppValidator loginValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(loginValidator);
    }

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new LoginRequest());
		return "login";
	}
	@PostMapping("/login")
	public String login( @ModelAttribute("loginRequest") @Valid LoginRequest loginRequest, BindingResult bindingResult, Model model) {
	    if (bindingResult.hasErrors()) {
	        return "login";
	    }
	    if (accountService.login(loginRequest.getUsername(), loginRequest.getPassword())) {
	        // Đăng nhập thành công
	        return "forward:/welcome";
	    } else {
	        // Đăng nhập không thành công
	        return "redirect:/login";
	    }
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping("/register")
	public String register(Model model, @ModelAttribute User user) {
		String errMg = "";
		if (user.getPassword().equals(user.getConfirmPassword())) {
			if (userDetailsService.add(user))
				return "redirect:/login";
			else
				errMg = "Da co loi!!!";
		} else
			errMg = "Mat khau khong khop";
		model.addAttribute("errMg", errMg);
		return "register";
	}
}
