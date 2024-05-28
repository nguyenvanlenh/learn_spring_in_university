package com.wl.spring.repositories.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wl.spring.repositories.AuthRepository;

@Repository
@Primary
@Transactional
public class AuthRepositoryImp implements AuthRepository {

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

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

}
