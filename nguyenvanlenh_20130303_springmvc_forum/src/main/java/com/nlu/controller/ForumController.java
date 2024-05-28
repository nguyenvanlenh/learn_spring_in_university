package com.nlu.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nlu.model.Category;
import com.nlu.model.Message;
import com.nlu.model.Topic;
import com.nlu.model.User;
import com.nlu.service.ForumService;

import jakarta.servlet.http.HttpSession;

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
	public String listTopics(Model model,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user== null)
			return "redirect:/";
	    Collection<Topic> topicCollection = forumService.getTopics();
	    List<Topic> topics = new ArrayList<>(topicCollection); 
	    model.addAttribute("topics", topics);
	    return "listTopics";
	}
	@GetMapping("/topics/{topicId}")
	@ResponseBody
	public Topic getTopic(@PathVariable int topicId) {
	    Collection<Topic> topicCollection = forumService.getTopics();
	    List<Topic> topics = new ArrayList<>(topicCollection);
	    
	    if(topicId < 0 || topicId >= topicCollection.size()) {
	        topicId = topicCollection.size()-1;
	    }
	    
	    return topics.get(topicId);
	}

	@GetMapping("/details/{topicId}")
	public String getDetails(Model model, @PathVariable Integer topicId,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user== null)
			return "redirect:/";
		Collection<Topic> topicCollection = forumService.getTopics();
		if(topicId < 0 || topicId >  topicCollection.size()) {
			topicId = topicCollection.size();
		}
		Topic topic = forumService.findTopic(topicId);
		model.addAttribute("topic", topic);
		return "showTopic";
	}
	@GetMapping("/new-topic")
	public String newTopic(Model model,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user== null)
			return "redirect:/";
		return "newTopic";
	}
	
	@PostMapping("/add-topic")
	public String addTopic(@RequestParam String title,
	                       @RequestParam String content,
	                       HttpSession session) {
	    User user = (User) session.getAttribute("user");
	    if (user == null)
	        return "redirect:/";

	    Category cat = new Category("Học hành");
	    Collection<Topic> topicCollection = forumService.getTopics();
	    Topic newTopic = new Topic(topicCollection.size() + 1, title, content, user, cat);
	    
	    int newTopicId = forumService.addTopic(newTopic);
	    topicCollection = forumService.getTopics();
	    
	    System.out.println("New topic added with ID: " + newTopicId);
	    
	    return "redirect:/listTopics";
	}

	@GetMapping("/reply")
	public String showReplyTopic(Model model,
			@RequestParam int id,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user== null)
			return "redirect:/";
		Topic topic = forumService.findTopic(id);
		model.addAttribute("topic", topic);
		return "replyTopic";
	}
	@PostMapping("/reply")
	public String replyTopic(
			Model model,
			@RequestParam int id,
			@RequestParam String title,
            @RequestParam String content,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user== null)
			return "redirect:/";
		Topic topic = forumService.findTopic(id);
		topic.addMessage(new Message(title,
				content,
				user));
	return "redirect:/details/"+topic.getId();
		
	
	}
}
