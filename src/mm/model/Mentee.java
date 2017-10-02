package mm.model;

public class Mentee extends User {

	private float remainingSemesters;
	private String graduationStatus;
	private String academiclnstitution;
	private float average;
	private String academicDicipline;
	private String academicDicipline2;
	private boolean signedEULA;
	private String resume;
	private String gradeSheet;
	

	public Mentee(){}

	

	public Mentee(int id, String firstName, String lastName, String email, String phoneNumber, String password,
			int gender, String address, String profilePicture, String note, boolean active, userType type, float remainingSemesters,
			String graduationStatus, String academiclnstitution, float average, String academicDicipline,
			String academicDicipline2, boolean signedEULA, String resume, String gradeSheet) {
		super(id, firstName, lastName, email, phoneNumber, password, gender, address, note, profilePicture, active, type);
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

	public String getAcademiclnstitution() {
		return academiclnstitution;
	}

	public void setAcademiclnstitution(String academiclnstitution) {
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

	public boolean isGuarantee() {
		return signedEULA;
	}

	public void setGuarantee(boolean isGuarantee) {
		this.signedEULA = isGuarantee;
	}

	public String getGradeSheet() {
		return gradeSheet;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public void setGradeSheet(String gradeSheet) {
		this.gradeSheet = gradeSheet;
	}

	@Override
	public String toString() {
		return "Mentee [remainingSemesters=" + remainingSemesters
				+ ", graduationStatus=" + graduationStatus
				+ ", academiclnstitution=" + academiclnstitution + ", average="
				+ average + ", academicDicipline=" + academicDicipline
				+ ", academicDicipline2=" + academicDicipline2
				+ ", isGraduate=" + signedEULA + ", resume=" + resume
				+ ", gradeSheet=" + gradeSheet + ", getType()=" + getType()
				+ ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getEmail()="
				+ getEmail() + ", getPhoneNumber()=" + getPhoneNumber()
				+ ", getPassword()=" + getPassword() + ", getGender()="
				+ getGender() + ", getAddress()=" + getAddress()
				+ ", getNote()=" + getNote() + ", isActive()=" + isActive()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}  
}
