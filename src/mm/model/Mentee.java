package mm.model;

import java.sql.Date;

public class Mentee extends User {

	private float remainingSemesters;
	private String graduationStatus;
	private int academiclnstitution;
	private float average;
	private String academicDicipline;
	private String academicDicipline2;
	private boolean signedEULA;
	private boolean resume;
	private boolean gradeSheet;
	private String academiclnstitutionName;
	

	public Mentee(){
		super();
	}
	public Mentee(int id, String firstName, String lastName, String email, String phoneNumber, String password,
			int gender, String address, boolean profilePicture, String note, boolean active, userType type, int areaId, String area, int cityId, String city, Date date, String personalId, float remainingSemesters,
			String graduationStatus, int academiclnstitution, float average, String academicDicipline,
			String academicDicipline2, boolean signedEULA, boolean resume, boolean gradeSheet) {
		super(id, firstName, lastName, email, phoneNumber, password, gender, address, note, profilePicture, active, type, areaId, area, cityId, city, date, personalId);
		this.remainingSemesters = remainingSemesters;
		this.graduationStatus = graduationStatus;
		this.academiclnstitution = academiclnstitution;
		this.average = average;
		this.academicDicipline = academicDicipline;
		this.academicDicipline2 = academicDicipline2;
		this.signedEULA = signedEULA;
		this.resume = resume;
		this.gradeSheet = gradeSheet;
	}
	

	public float getRemainingSemesters() {
		return remainingSemesters;
	}

	public void setRemainingSemesters(float remainingSemesters) {
		this.remainingSemesters = remainingSemesters;
	}

	public String getGraduationStatus() {
		return graduationStatus;
	}

	public void setGraduationStatus(String graduationStatus) {
		this.graduationStatus = graduationStatus;
	}

	public int getAcademiclnstitution() {
		return academiclnstitution;
	}

	public void setAcademiclnstitution(int academiclnstitution) {
		this.academiclnstitution = academiclnstitution;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	public String getAcademicDicipline() {
		return academicDicipline;
	}

	public void setAcademicDicipline(String academicDicipline) {
		this.academicDicipline = academicDicipline;
	}

	public String getAcademicDicipline2() {
		return academicDicipline2;
	}

	public void setAcademicDicipline2(String academicDicipline2) {
		this.academicDicipline2 = academicDicipline2;
	}

	public boolean getSignedEULA() {
		return signedEULA;
	}

	public void setSignedEULA(boolean signedEULA) {
		this.signedEULA = signedEULA;
	}

	public boolean getGradeSheet() {
		return gradeSheet;
	}

	public boolean getResume() {
		return resume;
	}

	public void setResume(boolean resume) {
		this.resume = resume;
	}

	public void setGradeSheet(boolean gradeSheet) {
		this.gradeSheet = gradeSheet;
	}
	
	public String getAcademiclnstitutionName() {
		return academiclnstitutionName;
	}
	public void setAcademiclnstitutionName(String academiclnstitutionName) {
		this.academiclnstitutionName = academiclnstitutionName;
	}
	@Override
	public String toString() {
		return "Mentee [remainingSemesters=" + remainingSemesters
				+ ", graduationStatus=" + graduationStatus
				+ ", academiclnstitution=" + academiclnstitution + ", average="
				+ average + ", academicDicipline=" + academicDicipline
				+ ", academicDicipline2=" + academicDicipline2
				+ ", isGraduate=" + signedEULA + ", resume=" + resume
				+ ", gradeSheet=" + gradeSheet + ", Type=" + getType()
				+ ", Id=" + getId() + ", FirstName=" + getFirstName()
				+ ", LastName=" + getLastName() + ", Email="
				+ getEmail() + ", PhoneNumber=" + getPhoneNumber()
				+ ",Password=" + getPassword() + ", Gender="
				+ getGender() + ", Address=" + getAddress()
				+ ", Note=" + getNote() + ", isActive=" + isActive()
				+ super.toString() + ", Class=" + getClass() + "]";
	}  
}
