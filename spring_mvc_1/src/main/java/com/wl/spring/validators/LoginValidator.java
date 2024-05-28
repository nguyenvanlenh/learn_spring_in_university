package com.wl.spring.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.wl.spring.models.request.LoginRequest;
// Spring validator
@Component
public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return LoginRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginRequest rq = (LoginRequest) target;
		
//		if(!rq.getUsername().contains("nguyen")) 
//			errors.rejectValue("username", "auth.login.user.error");
//		if((rq.getPassword().length()<8))
//			errors.rejectValue("password", "auth.login.pass.error");
	}

}
