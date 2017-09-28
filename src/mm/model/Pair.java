package mm.model;

import java.sql.Date;
public class Pair {
	int pairId;
	int mentorId;
	int menteeId;
	private Mentor mentor;
	private Mentee mentee;
	int activeStatus;
	Date startDate;
	Date endDate;
	String joinMessage;
	String tsofenMessage;
	
	public Pair(){}
	public Pair(int PairId,Mentor mentor, Mentee mentee, int activeStatus,
			Date startDate, Date endDate, String joinMessage,
			String tsofenMessage) {
		super();
		this.pairId=PairId;
		this.mentor = mentor;
		this.mentee = mentee;
		this.activeStatus = activeStatus;
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


	public Mentor getMentor() {
		return mentor;
	}


	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}


	public Mentee getMentee() {
		return mentee;
	}


	public void setMentee(Mentee mentee) {
		this.mentee = mentee;
	}


	public int getActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
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
	@Override
	public String toString() {
		return "Pair [pairId=" + pairId + ", mentorId=" + mentorId
				+ ", menteeId=" + menteeId + ", mentor=" + mentor + ", mentee="
				+ mentee + ", activeStatus=" + activeStatus + ", startDate="
				+ startDate + ", endDate=" + endDate + ", joinMessage="
				+ joinMessage + ", tsofenMessage=" + tsofenMessage + "]";
	}
	
	
	public int getPairId() {
		return pairId;
	}
	public void setPairId(int pairId) {
		this.pairId = pairId;
	}
	
	
}
