package mm.jsonModel;

import java.util.List;

import mm.model.Meeting;

public class JsonMeeting {
	
	//private Meeting meeting;
	private int code;
	private String message;
	private String token;
	private List <Meeting> meetings;
	@Override
	public String toString() {
		return "JsonMeeting [code=" + code + ", message=" + message + ", token=" + token + ", meetings=" + meetings
				+ "]";
	}
	public JsonMeeting(int code, String message, String token, List<Meeting> meetings) {
		super();
		this.code = code;
		this.message = message;
		this.token = token;
		this.meetings = meetings;
	}
	
	
	
	

}
