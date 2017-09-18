package mm.model;

import java.util.ArrayList;

public class Mentor extends User{
	   private String experience; 
	   private String role;
	   private int company;
	   private String volunteering;
	   private String workHistory;
	 

		public Mentor(int id, String firstName, String lastName, String email, String phoneNumber, String password,
			String gender, String address, String note, boolean active, userType type, String experience, String role,
			int company, String volunteering, String workHistory) {
		super(id, firstName, lastName, email, phoneNumber, password, gender, address, note, active, type);
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


}
