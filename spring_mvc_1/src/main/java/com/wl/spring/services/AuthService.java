package com.wl.spring.services;

public interface AuthService {
	
	boolean login(String username , String password);
	boolean changePassword(String username, String curPass, String newPass);
	boolean forgotPassword(String email);
}
