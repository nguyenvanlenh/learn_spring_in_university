package com.watermelon;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String listMembers(Model model) {
		List<User> listUsers = userRepository.findAll();
		model.addAttribute("listUsers", listUsers);
		return "index";
	}

	@GetMapping("/users")
	@ResponseBody
	public List<User> getUsersByGender(
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "email", required = false) String email
			) {
		List<User> listUsers;
		if (gender != null && !gender.isEmpty()) {
			listUsers = userRepository.findByGender(gender);
		}
		else {
			listUsers = userRepository.findAll();
		}
		return listUsers;
	}
	@GetMapping("/users/email")
	@ResponseBody
	public String checkEmailExists(@RequestParam String email) {
	    if(email != null && !email.isEmpty()){
	        boolean exists = userRepository.existsByEmail(email);
	        if (exists) {
	            return "Email đã tồn tại trong danh sách thành viên.";
	        } else {
	            return "Email hợp lệ và chưa được đăng ký.";
	        }
	    } else {
	        return "Email không hợp lệ. Thử lại.";
	    }
	}

	@GetMapping("/register")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	@PostMapping("/register")
	public String registerSubmit(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "index";
		}
		userRepository.save(user);
		model.addAttribute("user", user);
		System.out.println(user);
		return "result";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@GetMapping("users/{id}")
	public String getUser(@PathVariable Long id, Model model) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		model.addAttribute("user", user);
		return "details";
	}

}
