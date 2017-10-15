package mm.model;

public class PairsInfo {

	private String menteeName;
	private String mentorName;
	private int pairId;
	private int activeStatus;
	
	
	

	public PairsInfo(String menteeName, String mentorName, int pairId, int activeStatus) {
		super();
		this.menteeName = menteeName;
		this.mentorName = mentorName;
		this.pairId = pairId;
		this.activeStatus = activeStatus;
	}
	public String getMenteeName() {
		return menteeName;
	}
	public void setMenteeName(String menteeName) {
		this.menteeName = menteeName;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public int getPairId() {
		return pairId;
	}
	public void setPairId(int pairId) {
		this.pairId = pairId;
	}
	public int getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}
	@Override
	public String toString() {
		return "PairsInfo [menteeName=" + menteeName + ", mentorName="
				+ mentorName + ", pairId=" + pairId + ", activeStatus="
				+ activeStatus + "]";
	}
	

}
