package com.wl.spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.wl.spring.repositories.AuthRepository;
import com.wl.spring.repositories.UserRepository;
import com.wl.spring.services.AuthService;

@Service
@Primary
public class AuthServiceImp implements AuthService{
	
	@Autowired
	private AuthRepository acRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean changePassword(String username, String curPass, String newPass) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean forgotPassword(String email) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}
