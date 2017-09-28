package mm.model;

public class Session {
  
	private int userId;
	private String token;
	private long creationDate;
	private long expirationDate;
	private String deviceId;
	
	public Session(int userId, String token, String deviceId) {
		super();
		this.userId = userId;
		this.token = token;
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
