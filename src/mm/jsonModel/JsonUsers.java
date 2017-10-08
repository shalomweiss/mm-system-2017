package mm.jsonModel;

import java.util.List;

import mm.model.User;

public class JsonUsers {

	private List<User> user;
	private int code;
	private String message;
	private String token;
	
	
	
	public JsonUsers(List<User> user, int code, String message, String token) {
		super();
		this.user = user;
		this.code = code;
		this.message = message;
		this.token=token;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
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
	@Override
	
	public String toString() {
		return "JsonUser [user=" + user + ", code=" + code + ", message="
				+ message + ", token=" + token + "]";
	}

}
