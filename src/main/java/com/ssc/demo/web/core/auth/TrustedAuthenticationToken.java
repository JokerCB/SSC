package com.ssc.demo.web.core.auth;

import org.apache.shiro.authc.AuthenticationToken;

public class TrustedAuthenticationToken implements AuthenticationToken {


	private static final long serialVersionUID = -9018794922812670179L;
	
	private String username;

	public TrustedAuthenticationToken() {
	}
	
	public TrustedAuthenticationToken(String username) {
		this.username = username;
	}

	public Object getPrincipal() {
		return this.username;
	}
	
	public Object getCredentials() {
		return null;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void clear() {
		this.username = null;
	}

	public String toString() {
		return "username=" + this.username;
	}
}