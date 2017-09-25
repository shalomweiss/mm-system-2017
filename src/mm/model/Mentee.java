package mm.model;

public class Mentee extends User{

	private float remainingSemesters;
	private String graduationStatus;
	private String academiclnstitution;
	private float average;
	private String academicDicipline;
	private String academicDicipline2;
	private boolean isGuarantee;
	private String resume;
	private String gradeSheet;

	

	public Mentee(int id, String firstName, String lastName, String email, String phoneNumber, String password,
			String gender, String address, String note, boolean active, userType type, float remainingSemesters,
			String graduationStatus, String academiclnstitution, float average, String academicDicipline,
			String academicDicipline2, boolean isGuarantee, String resume, String gradeSheet) {
		super(id, firstName, lastName, email, phoneNumber, password, gender, address, note, active, type);
		this.remainingSemesters = remainingSemesters;
		this.graduationStatus = graduationStatus;
		this.academiclnstitution = academiclnstitution;
		this.average = average;
		this.academicDicipline = academicDicipline;
		this.academicDicipline2 = academicDicipline2;
		this.isGuarantee = isGuarantee;
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
		return isGuarantee;
	}

	public void setGuarantee(boolean isGuarantee) {
		this.isGuarantee = isGuarantee;
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
	
}
