package mm.model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LocalDateTimeStringConverter;

public class Session {
  
	private int userId;
	private String token;
	private long creationDate;
	private long expirationDate;
	private String deviceId;
	
	@SuppressWarnings("deprecation")
	public Session(int userId, String token, String deviceId) {
		super();
		this.userId = userId;
		this.token = token;
		this.deviceId = deviceId;	
		this.creationDate=new Date().getDate();
			
	}
	
	
	public Session(int userId, String token, long creationDate, long expirationDate, String deviceId) {
		super();
		this.userId = userId;
		this.token = token;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
		this.deviceId = deviceId;
	}




	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}
	public long getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(long expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	

}
