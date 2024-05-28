package com.wl.spring.models.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginRequest {

	@NotNull
	@Size(min=10,max = 50, message = "{auth.login.user.sizeErr}")
	private String username;
	@NotNull
	@Size(min=10,max = 50, message = "{auth.login.pass.sizeErr}")
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
