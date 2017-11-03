package mm.da;

public final class DataContract {

	public static class UsersTable{
		public static final String TABLE_NAME = "users";
		public static final String COL_ID = "id";
		public static final String COL_TYPE = "type";
		public static final String COL_FIRSTNAME = "firstName";
		public static final String COL_LASTNAME = "lastName";
		public static final String COL_EMAIL = "email";
		public static final String COL_PHONENUMBER = "phoneNumber";
		public static final String COL_PASSWORD = "password";
		public static final String COL_GENDER = "gender";
		public static final String COL_ADDRESS = "address";
		public static final String COL_NOTES = "notes";
		public static final String COL_PROFILEPICTURE = "profilePicture";
		public static final String COL_ACTIVE = "active";
		public static final String COL_CITYID = "cityId";
		public static final String COL_AREAID = "areaId";
	}
	
	public static class MentorsTable{
		public static final String TABLE_NAME = "mentors";
		public static final String COL_ID = "id";
		public static final String COL_EXPERIENCE = "experience";
		public static final String COL_ROLE = "role";
		public static final String COL_COMPANY = "company";
		public static final String COL_VOLUNTEERING = "volunteering";
		public static final String COL_WORKHISTORY = "workHistory";
	}
	
	public static class MenteeTable{
		public static final String TABLE_NAME = "mentees";
		public static final String COL_ID = "id";
		public static final String COL_REMAININGSEMESTERS = "remainingSemesters";
		public static final String COL_GRADUATIONSTATUS = "graduationStatus";
		public static final String COL_ACADEMICINSTITUTE = "academicInstitute";
		public static final String COL_AVERAGE = "average";
		public static final String COL_ACADEMICDICIPLINE1 = "academicDicipline1";
		public static final String COL_ACADEMICDICIPLINE2 = "academicDicipline2";
		public static final String COL_SIGNEDEULA = "signedEULA";
		public static final String COL_RESUME = "resume";
		public static final String COL_GRADESHEET = "gradeSheet";
	}
	
	public static class SessionsTable{
		public static final String TABLE_NAME = "sessions";
		public static final String COL_USERID = "userId";
		public static final String COL_TOKEN = "token";
		public static final String COL_CREATIONDATE = "creationDate";
		public static final String COL_EXPIRATIONDATE = "expirationDate";
		public static final String COL_DEVICEID = "deviceId";
	}
	
	public static class PairsTable{
		public static final String TABLE_NAME = "pairs";
		public static final String COL_PAIRID = "pairId";
		public static final String COL_MENTORID = "mentorId";
		public static final String COL_MENTEEID = "menteeId";
		public static final String COL_ACTIVESTATUS = "activeStatus";
		public static final String COL_STARTDATE = "startDate";
		public static final String COL_ENDDATE = "endDate";
		public static final String COL_JOINTMESSAGE = "jointMessage";
		public static final String COL_TSOFENMESSAGE = "tsofenMessage";
	}
	
	public static class MeetingTable{
		public static final String TABLE_NAME = "activities";
		public static final String COL_MENTORID = "mentorId";
		public static final String COL_MENTEEID = "menteeId";
		public static final String COL_ACTIVITYID = "activityId";
		public static final String COL_PAIRID = "pairId";
		public static final String COL_NOTE = "note";
		public static final String COL_STATUS = "status";
		public static final String COL_MENTEEREPORT = "menteeReport";
		public static final String COL_MENTORREPORT = "mentorReport";
		public static final String COL_MENTEEPRIVREPORT = "menteePrivateReport";
		public static final String COL_MENTORPRIVREPORT = "mentorPrivateReport";
		public static final String COL_MEETINGTYPE = "meetingType";
		public static final String COL_SUBJECT = "subject";
		public static final String COL_LOCATION = "location";
		public static final String COL_DATE = "date";
		public static final String COL_STARTINGTIME = "startingTime";
		public static final String COL_ENDINGTIME = "endingTime";
		public static final String COL_MENTORCOMPLETE = "mentorComplete";
		public static final String COL_MENTEECOMPLETE = "menteeComplete";
	}
	
	public static class AcademicInstituteTable{
		public static final String TABLE_NAME = "academicinstitute";
		public static final String COL_ID = "id";
		public static final String COL_NAME = "name";
		public static final String COL_AREA = "area";
		public static final String COL_CITY = "city";
	}
	
	public static class WorkplacesTable{
		public static final String TABLE_NAME = "workplaces";
		public static final String COL_ID = "id";
		public static final String COL_NAME = "name";
		public static final String COL_AREA = "area";
		public static final String COL_CITY = "city";
		public static final String COL_ADDRESS = "address";
	}
	
	public static class CitiesTable{
		public static final String TABLE_NAME = "cities";
		public static final String COL_ID = "id";
		public static final String COL_NAME = "name";
	}
	
	public static class AreasTable{
		public static final String TABLE_NAME = "areas";
		public static final String COL_ID = "id";
		public static final String COL_NAME = "name";
	}
}
