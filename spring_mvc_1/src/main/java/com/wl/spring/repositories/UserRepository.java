package com.wl.spring.repositories;

import java.util.List;

import com.wl.spring.models.User;

public interface UserRepository {

	boolean add(User user);

	List<User> getUsers(String username);
}
