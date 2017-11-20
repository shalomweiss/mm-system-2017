package mm.model;

import java.sql.Date;

public class Mentor extends User {
	private String experience;
	private String role;
	private int company;
	private String volunteering;
	private String workHistory;
	private String companyName;
	
	
	public Mentor(){
		super();
	}

	public Mentor(String firstName, String lastName, String experience) {
		super(firstName, lastName);
		this.experience = experience;
	}

	public Mentor(String firstName, String lastName) {
		super(firstName, lastName);
	}
	

	public Mentor(int id, String firstName, String lastName, String email, String phoneNumber, String password,
			int gender, String address, String note, String profilePicture, boolean active, userType type, int areaId, String area, int cityId, String city, Date date, String personalId, String experience,
			String role, int company, String volunteering, String workHistory) {
		super(id, firstName, lastName, email, phoneNumber, password, gender, address, note, profilePicture, active, type, areaId, area, cityId, city, date, personalId);
		this.experience = experience;
		this.role = role;
		this.company = company;
		this.volunteering = volunteering;
		this.workHistory = workHistory;
		
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getCompany() {
		return company;
	}

	public void setCompany(int company) {
		this.company = company;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getWorkHistory() {
		return workHistory;
	}

	public void setWorkHistory(String workHistory) {
		this.workHistory = workHistory;
	}

	public String getVolunteering() {
		return volunteering;
	}

	public void setVolunteering(String volunteering) {
		this.volunteering = volunteering;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Mentor [experience=" + experience + ", role=" + role + ", company=" + company + ", volunteering="
				+ volunteering + ", workHistory=" + workHistory + ", Role=" + getRole() + ", Company="
				+ getCompany() + ", Experience=" + getExperience() + ", WorkHistory=" + getWorkHistory()
				+ ", Volunteering=" + getVolunteering() + ", Type=" + getType() + ", Id=" + getId()
				+ ", FirstName=" + getFirstName() + ", LastName=" + getLastName() + ", Email="
				+ getEmail() + ", PhoneNumber=" + getPhoneNumber() + ", Password=" + getPassword()
				+ ",Gender=" + getGender() + ", Address=" + getAddress() + ", Note=" + getNote()
				+ ", isActive=" + isActive() + ", ProfilePicture=" + getProfilePicture() 
				+ super.toString() + ", Class=" + getClass() + "]";
	}

	
}
