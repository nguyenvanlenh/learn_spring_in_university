package com.nlu.example.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nlu.example.model.Topic;
import com.nlu.example.model.User;
import com.nlu.example.service.ForumService;

@Controller
@CrossOrigin("*")
public class ForumController {

	@Autowired
	private ForumService forumService;

	@GetMapping("/")
	public String home(Model model) {
//		model.addAttribute("user", new LoginRequest());
		return "index";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session,
			Model model) {
		User user = forumService.checkUser(username, password);
		if (user != null) {
			session.setAttribute("user", user);
			return "redirect:/listTopics";
		} else {
			model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng. Vui lòng thử lại.");
			return "index";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/listTopics")
	public String listTopics(Model model) {
	    Collection<Topic> topicCollection = forumService.getTopics();
	    List<Topic> topics = new ArrayList<>(topicCollection); 
	    model.addAttribute("topics", topics);
	    return "listTopics";
	}
	@GetMapping("/topics")
	@ResponseBody
	public Topic getTopic() {
		Collection<Topic> topicCollection = forumService.getTopics();
		List<Topic> topics = new ArrayList<>(topicCollection); 
		return topics.get(0);
	}
	@GetMapping("/details/{topicId}")
	public String getDetails(Model model, @PathVariable Integer topicId) {
		Topic topic = forumService.findTopic(topicId);
		model.addAttribute("topic", topic);
		return "showTopic";
	}
	@GetMapping("/new-topic")
	public String newTopic(Model model) {
		return "newTopic";
	}
	

}
