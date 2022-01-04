package com.bs.bs.model.payload.request;

import javax.validation.constraints.NotBlank;

/**
 * model which used on signin request
 * userName and password must take values not allowed to be null or blank
 */

public class LoginRequest {
	@NotBlank
	private String userName;

	@NotBlank
	private String password;

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
