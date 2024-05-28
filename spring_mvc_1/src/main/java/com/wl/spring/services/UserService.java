package com.wl.spring.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.wl.spring.models.User;

public interface UserService extends UserDetailsService{
	boolean add(User user);
	List<User> getUsers(String username);
}
