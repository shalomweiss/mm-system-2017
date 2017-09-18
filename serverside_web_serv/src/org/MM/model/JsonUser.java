package org.MM.model;

import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

public class JsonUser {
	
	private User user;
	private int code;
	private String message;
	private HttpSession token;
	
	
	
	public JsonUser(User user, int code, String message, HttpSession token) {
		super();
		this.user = user;
		this.code = code;
		this.message = message;
		this.token=token;
	}
	public HttpSession getToken() {
		return token;
	}
	public void setToken(HttpSession token) {
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
