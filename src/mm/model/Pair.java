package mm.model;

import java.sql.Date;

public class Pair {
    private int pairId;
    private int mentorId;
    private int menteeId;
	private	int activeStatuse;
	private	Date startDate;
	private	Date endDate;
	private	String joinMessage;
	private String tsofenMessage;
	
	
	public Pair(int PairId,int mentorId, int menteeId, int activeStatuse,
			Date startDate, Date endDate, String joinMessage,
			String tsofenMessage) {
		super();
		this.pairId=pairId;
		this.mentorId=mentorId;
		this.menteeId =menteeId;
		this.activeStatuse = activeStatuse;
		this.startDate = startDate;
		this.endDate = endDate;
		this.joinMessage = joinMessage;
		this.tsofenMessage = tsofenMessage;
	}


	public Pair(int mentorId, int menteeId) {
		super();
		this.mentorId = mentorId;
		this.menteeId = menteeId;
	}


	public int getMentorId() {
		return mentorId;
	}


	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}


	public int getMenteeId() {
		return menteeId;
	}


	public void setMenteeId(int menteeId) {
		this.menteeId = menteeId;
	}




	public int getActiveStatuse() {
		return activeStatuse;
	}


	public void setActiveStatuse(int activeStatuse) {
		this.activeStatuse = activeStatuse;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getJoinMessage() {
		return joinMessage;
	}


	public void setJoinMessage(String joinMessage) {
		this.joinMessage = joinMessage;
	}


	public String getTsofenMessage() {
		return tsofenMessage;
	}


	public void setTsofenMessage(String tsofenMessage) {
		this.tsofenMessage = tsofenMessage;
	}
}
