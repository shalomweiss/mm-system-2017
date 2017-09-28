package mm.model;

public class Pair {
    private int pairId;
    private int mentorId;
    private int menteeId;
    private User mentor;
    private User mentee;
	private	int activeStatus;
	private	long startDate;
	private	long endDate;
	private	String joinMessage;
	private String tsofenMessage;
	
	public Pair(){}
	
	public Pair(int pairId, int mentorId, int menteeId, User mentor, User mentee, int activeStatus, long startDate,
			long endDate, String joinMessage, String tsofenMessage) {
		super();
		this.pairId = pairId;
		this.mentorId = mentorId;
		this.menteeId = menteeId;
		this.mentor = mentor;
		this.mentee = mentee;
		this.activeStatus = activeStatus;
		this.startDate = startDate;
		this.endDate = endDate;
		this.joinMessage = joinMessage;
		this.tsofenMessage = tsofenMessage;
	}

	public Pair(int pairId, int mentorId, int menteeId, int activeStatus, long startDate,
			long endDate, String joinMessage, String tsofenMessage) {
		super();
		this.pairId = pairId;
		this.mentorId = mentorId;
		this.menteeId = menteeId;
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




	public int getActiveStatuse() {
		return activeStatus;
	}


	public void setActiveStatuse(int activeStatus) {
		this.activeStatus = activeStatus;
	}


	public long getStartDate() {
		return startDate;
	}


	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}


	public long getEndDate() {
		return endDate;
	}


	public void setEndDate(long endDate) {
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
