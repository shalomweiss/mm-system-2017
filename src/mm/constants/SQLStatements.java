package mm.constants;

import mm.da.DataContract;

public class SQLStatements {
	public final static String selectUserByEmail = "Select * From "
			+ DataContract.UsersTable.TABLE_NAME + " where "
			+ DataContract.UsersTable.COL_EMAIL + "=?";
	public final static String selectMentorById = "Select * From "
			+ DataContract.MentorsTable.TABLE_NAME + " where "
			+ DataContract.MentorsTable.COL_ID + "=?";
	public final static String selectMenteeById = "Select * From "
			+ DataContract.MenteeTable.TABLE_NAME + " where "
			+ DataContract.MenteeTable.COL_ID + "=?";
	public final static String selectUserByType = "Select * From "
			+ DataContract.UsersTable.TABLE_NAME + " where "
			+ DataContract.UsersTable.COL_TYPE + "=?";	
	public final static String selectUserById = "Select * From "
			+ DataContract.UsersTable.TABLE_NAME + " where "
			+ DataContract.UsersTable.COL_ID + "=?";
	public final static String selectMentor = "Select * from " 
			+ DataContract.UsersTable.TABLE_NAME + " RIGHT JOIN "
			+ DataContract.MentorsTable.TABLE_NAME + " ON "
			+ DataContract.UsersTable.TABLE_NAME + "." + DataContract.UsersTable.COL_ID 
			+ " = " 
			+ DataContract.MentorsTable.TABLE_NAME + "." + DataContract.MentorsTable.COL_ID
			;
	public final static String selectMentee = "Select * from " 
			+ DataContract.UsersTable.TABLE_NAME + " RIGHT JOIN "
			+ DataContract.MenteeTable.TABLE_NAME + " ON "
			+ DataContract.UsersTable.TABLE_NAME + "." + DataContract.UsersTable.COL_ID 
			+ " = " 
			+ DataContract.MenteeTable.TABLE_NAME + "." + DataContract.MenteeTable.COL_ID
			;
	public final static String selectSessionByUserId = "Select * From "
			+ DataContract.SessionsTable.TABLE_NAME + " where "
			+ DataContract.SessionsTable.COL_USERID + "=?";
	
	public final static String selectPairsByMenteeIdAndActiveStats = "Select * From "
			+ DataContract.PairsTable.TABLE_NAME + " where "
			+ DataContract.PairsTable.COL_MENTEEID + "=? and "
			+ DataContract.PairsTable.COL_ACTIVESTATUS + "=?";
	public final static String selectPairsByMentorIdAndActiveStats = "Select * From "
			+ DataContract.PairsTable.TABLE_NAME + " where "
			+ DataContract.PairsTable.COL_MENTORID + "=? and "
			+ DataContract.PairsTable.COL_ACTIVESTATUS + "=?";
	public final static String insertSession = "INSERT INTO " 
			+ DataContract.SessionsTable.TABLE_NAME + " ("
			+ DataContract.SessionsTable.COL_USERID + ", "
			+ DataContract.SessionsTable.COL_TOKEN + ", "
			+ DataContract.SessionsTable.COL_CREATIONDATE + ", "
			+ DataContract.SessionsTable.COL_EXPIRATIONDATE + ", "
			+ DataContract.SessionsTable.COL_DEVICEID + ") "
			+ "VALUES (?,?,?,?,?)";
	
	public final static String updateUserById = "UPDATE "
			+ DataContract.UsersTable.TABLE_NAME + " SET "
			+ DataContract.UsersTable.COL_FIRSTNAME + "=?, "
			+ DataContract.UsersTable.COL_LASTNAME + "=?, "
			+ DataContract.UsersTable.COL_PHONENUMBER + "=?, "
			+ DataContract.UsersTable.COL_GENDER + "=?, "
			+ DataContract.UsersTable.COL_ADDRESS + "=?, "
			+ DataContract.UsersTable.COL_NOTES + "=?, "
			+ DataContract.UsersTable.COL_PROFILEPICTURE + "=?, "
			+ DataContract.UsersTable.COL_ACTIVE + "=? WHERE "
			+ DataContract.UsersTable.COL_ID + "=?";
	public final static String updateMentorById = "UPDATE "
			+ DataContract.MentorsTable.TABLE_NAME + " SET "
			+ DataContract.MentorsTable.COL_EXPERIENCE + "=?, "
			+ DataContract.MentorsTable.COL_ROLE + "=?, "
			+ DataContract.MentorsTable.COL_COMPANY + "=?, "
			+ DataContract.MentorsTable.COL_VOLUNTEERING + "=?, "
			+ DataContract.MentorsTable.COL_WORKHISTORY + "=? WHERE "
			+ DataContract.MentorsTable.COL_ID + "=?";
	public final static String updaterMenteeById = "UPDATE "
			+ DataContract.MenteeTable.TABLE_NAME + " SET "
			+ DataContract.MenteeTable.COL_REMAININGSEMESTERS + "=?, "
			+ DataContract.MenteeTable.COL_GRADUATIONSTATUS + "=?, "
			+ DataContract.MenteeTable.COL_ACADEMICINSTITUTE + "=?, "
			+ DataContract.MenteeTable.COL_AVERAGE + "=?, "
			+ DataContract.MenteeTable.COL_ACADEMICDICIPLINE1 + "=?, "
			+ DataContract.MenteeTable.COL_ACADEMICDICIPLINE2 + "=?, "
			+ DataContract.MenteeTable.COL_SIGNEDEULA + "=?, "
			+ DataContract.MenteeTable.COL_RESUME + "=?, "
			+ DataContract.MenteeTable.COL_GRADESHEET + "=? WHERE "
			+ DataContract.MenteeTable.COL_ID + "=?";
	public final static String setUserDeactiveById = "UPDATE "
			+ DataContract.UsersTable.TABLE_NAME + " SET "
			+ DataContract.UsersTable.COL_ACTIVE + "=0 WHERE "
			+ DataContract.UsersTable.COL_ID + "=?";
	public final static String insertUser = "INSERT INTO "
			+ DataContract.UsersTable.TABLE_NAME + " ("
			+ DataContract.UsersTable.COL_TYPE + ", "
			+ DataContract.UsersTable.COL_FIRSTNAME + ", "
			+ DataContract.UsersTable.COL_LASTNAME + ", "
			+ DataContract.UsersTable.COL_EMAIL + ", "
			+ DataContract.UsersTable.COL_PHONENUMBER + ", "
			+ DataContract.UsersTable.COL_PASSWORD + ", "
			+ DataContract.UsersTable.COL_GENDER + ", "
			+ DataContract.UsersTable.COL_ADDRESS + ", "
			+ DataContract.UsersTable.COL_NOTES + ", "
			+ DataContract.UsersTable.COL_PROFILEPICTURE + ", "
			+ DataContract.UsersTable.COL_ACTIVE
			+ ") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	public final static String insertMentee = "INSERT INTO "
			+ DataContract.MenteeTable.TABLE_NAME + " ("
			+ DataContract.MenteeTable.COL_ID + ", "
			+ DataContract.MenteeTable.COL_REMAININGSEMESTERS + ", "
			+ DataContract.MenteeTable.COL_GRADUATIONSTATUS + ", "
			+ DataContract.MenteeTable.COL_ACADEMICINSTITUTE + ", "
			+ DataContract.MenteeTable.COL_AVERAGE + ", "
			+ DataContract.MenteeTable.COL_ACADEMICDICIPLINE1 + ", "
			+ DataContract.MenteeTable.COL_ACADEMICDICIPLINE2 + ", "
			+ DataContract.MenteeTable.COL_SIGNEDEULA + ", "
			+ DataContract.MenteeTable.COL_RESUME + ", "
			+ DataContract.MenteeTable.COL_GRADESHEET
			+ ") VALUES (?,?,?,?,?,?,?,?,?,?)";
	public final static String insertMentor = "INSERT INTO "
			+ DataContract.MentorsTable.TABLE_NAME + " ("
			+ DataContract.MentorsTable.COL_ID + ", "
			+ DataContract.MentorsTable.COL_EXPERIENCE + ", "
			+ DataContract.MentorsTable.COL_ROLE + ", "
			+ DataContract.MentorsTable.COL_COMPANY + ", "
			+ DataContract.MentorsTable.COL_VOLUNTEERING + ", "
			+ DataContract.MentorsTable.COL_WORKHISTORY
			+ ") VALUES (?,?,?,?,?,?)";
	public final static String insertPair = "INSERT INTO "
			+ DataContract.PairsTable.TABLE_NAME + " ("
			+ DataContract.PairsTable.COL_MENTORID + ", "
			+ DataContract.PairsTable.COL_MENTEEID + ", "
			+ DataContract.PairsTable.COL_ACTIVESTATUS + ", "
			+ DataContract.PairsTable.COL_STARTDATE + ") VALUES (?,?,?,?)";

	public final static String selectPairs = "Select * From "
			+ DataContract.PairsTable.TABLE_NAME;

	public final static String selectPairById  = "Select * From "
			+ DataContract.PairsTable.TABLE_NAME + " Where "+DataContract.PairsTable.COL_PAIRID+"=?";
	
	public final static String setPairDeactiveById = "UPDATE " 
			+ DataContract.PairsTable.TABLE_NAME + " SET "
			+ DataContract.PairsTable.COL_ACTIVESTATUS + "=0 WHERE "
			+ DataContract.PairsTable.COL_PAIRID+ "=?";

	
	public final static String selectMeetingsByMentorId = "Select * From "
			+ DataContract.MeetingTable.TABLE_NAME+ " Where "+DataContract.MeetingTable.COL_MENTORID+"=?";
	
	public final static String selectMeetingsByMenteeId = "Select * From "
			+ DataContract.MeetingTable.TABLE_NAME+ " Where "+DataContract.MeetingTable.COL_MENTEEID+"=?";
	

	public final static String selectMeetingById = "Select * From "
			+ DataContract.MeetingTable.TABLE_NAME+ " Where "+DataContract.MeetingTable.COL_ACTIVITYID+"=?";
	
	public final static String selectMeetingByPairId = "Select * From "
			+ DataContract.MeetingTable.TABLE_NAME+ " Where "+DataContract.MeetingTable.COL_PAIRID+"=?";
	

	public final static String insertMeeting = "INSERT INTO "
			+ DataContract.MeetingTable.TABLE_NAME + " ("
			+ DataContract.MeetingTable.COL_PAIRID + ", "
			+ DataContract.MeetingTable.COL_MENTORID + ", "
			+ DataContract.MeetingTable.COL_MENTEEID + ", "
			+ DataContract.MeetingTable.COL_NOTE + ", "
			+ DataContract.MeetingTable.COL_STATUS + ", "
			+ DataContract.MeetingTable.COL_MENTEEREPORT + ", "			
			+ DataContract.MeetingTable.COL_MENTORREPORT + ", "
			+ DataContract.MeetingTable.COL_MENTEEPRIVREPORT + ", "
			+ DataContract.MeetingTable.COL_MENTORPRIVREPORT + ", "
			+ DataContract.MeetingTable.COL_MEETINGTYPE + ", "
			+ DataContract.MeetingTable.COL_SUBJECT + ", "
			+ DataContract.MeetingTable.COL_LOCATION + ", "
			+ DataContract.MeetingTable.COL_DATE + ", "
			+ DataContract.MeetingTable.COL_STARTINGTIME + ", "
			+ DataContract.MeetingTable.COL_ENDINGTIME + ", "
			+ DataContract.MeetingTable.COL_MENTORCOMPLETE + ", "
			+ DataContract.MeetingTable.COL_MENTEECOMPLETE + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

}

