package com.wl.spring.repositories;

public interface AuthRepository {
	boolean login(String username, String password);

	boolean changePassword(String username, String curPass, String newPass);

	boolean forgotPassword(String email);

}
