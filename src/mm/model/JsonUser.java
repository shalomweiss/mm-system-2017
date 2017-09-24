package mm.model;


import org.apache.catalina.Session;

public class JsonUser {
	
	private User user;
	private int code;
	private String message;
	private String token;
	
	
	
	public JsonUser(User user, int code, String message, String token) {
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
