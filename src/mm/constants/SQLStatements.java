package mm.constants;

import mm.da.DataContract;

public class SQLStatements {
	public final static String selectLoginUser = "Select * From "
			+ DataContract.UsersTable.TABLE_NAME + " where "
			+ DataContract.UsersTable.COL_EMAIL + "=?";
	public final static String selectLoginMentor = "Select * From "
			+ DataContract.MentorsTable.TABLE_NAME + " where "
			+ DataContract.MentorsTable.COL_ID + "=?";
	public final static String selectLoginMentee = "Select * From "
			+ DataContract.MenteeTable.TABLE_NAME + " where "
			+ DataContract.MenteeTable.COL_ID + "=?";
	public final static String selectByID = "Select * From "
			+ DataContract.UsersTable.TABLE_NAME + " where "
			+ DataContract.UsersTable.COL_ID + "=?";
	public final static String updateUserBase = "UPDATE "
			+ DataContract.UsersTable.TABLE_NAME + " SET "
			+ DataContract.UsersTable.COL_FIRSTNAME + "=?, "
			+ DataContract.UsersTable.COL_LASTNAME + "=?, "
			+ DataContract.UsersTable.COL_EMAIL + "=?, "
			+ DataContract.UsersTable.COL_PASSWORD + "=?, "
			+ DataContract.UsersTable.COL_ADDRESS + "=? WHERE "
			+ DataContract.UsersTable.COL_ID + "=?";
	public final static String updateUserMentor = "UPDATE "
			+ DataContract.MentorsTable.TABLE_NAME + " SET "
			+ DataContract.MentorsTable.COL_EXPERIENCE + "=?, "
			+ DataContract.MentorsTable.COL_ROLE + "=?, "
			+ DataContract.MentorsTable.COL_COMPANY + "=?, "
			+ DataContract.MentorsTable.COL_VOLUNTEERING + "=?, "
			+ DataContract.MentorsTable.COL_WORKHISTORY + "=? WHERE "
			+ DataContract.MentorsTable.COL_ID + "=?";
	public final static String updateUserMentee = "UPDATE "
			+ DataContract.MenteeTable.TABLE_NAME + " SET "
			+ DataContract.MenteeTable.COL_REMAININGSEMESTERS + "=?, "
			+ DataContract.MenteeTable.COL_GRADUATIONSTATUS + "=?, "
			+ DataContract.MenteeTable.COL_ACADEMICINSTITUTE + "=?, "
			+ DataContract.MenteeTable.COL_AVERAGE + "=?, "
			+ DataContract.MenteeTable.COL_ACADEMICDICIPLINE1 + "=?, "
			+ DataContract.MenteeTable.COL_ACADEMICDICIPLINE2 + "=?, "
			+ DataContract.MenteeTable.COL_ISGRADUATE + "=?, "
			+ DataContract.MenteeTable.COL_RESUME + "=?, "
			+ DataContract.MenteeTable.COL_GRADESHEET + "=? WHERE "
			+ DataContract.MenteeTable.COL_ID + "=?";
	public final static String deactivateUser = "UPDATE "
			+ DataContract.UsersTable.TABLE_NAME + " SET "
			+ DataContract.UsersTable.COL_ACTIVE + "=0 WHERE "
			+ DataContract.UsersTable.COL_ID + "=?";
}
