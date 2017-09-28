package mm.model;

import java.sql.Date;
public class Pair {
    private int pairId;
    private int mentorId;
    private int menteeId;
    private User mentor;
    private User mentee;
	private	int activeStatuse;
	private	Date startDate;
	private	Date endDate;
	private	String joinMessage;
	private String tsofenMessage;
	
	

	public Pair(int pairId, int mentorId, int menteeId, User mentor, User mentee, int activeStatuse, Date startDate,
			Date endDate, String joinMessage, String tsofenMessage) {
		super();
		this.pairId = pairId;
		this.mentorId = mentorId;
		this.menteeId = menteeId;
		this.mentor = mentor;
		this.mentee = mentee;
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


	public int getPairId() {
		return pairId;
	}


	public void setPairId(int pairId) {
		this.pairId = pairId;
	}


	public User getMentor() {
		return mentor;
	}


	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}


	public User getMentee() {
		return mentee;
	}


	public void setMentee(Mentee mentee) {
		this.mentee = mentee;
	}
	
}
