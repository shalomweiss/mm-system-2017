package mm.model;

public class JsonMeeting {
	
	//private Meeting meeting;
	private int code;
	private String message;
	private String token;
	public JsonMeeting(Meeting meeting, int code, String message, String token) {
		super();
		this.meeting = meeting;
		this.code = code;
		this.message = message;
		this.token = token;
	}
	
	
	

}
