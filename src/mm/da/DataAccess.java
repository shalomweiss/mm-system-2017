package mm.da;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;

import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import mm.constants.SQLStatements;
import mm.model.AcademicInstitute;
import mm.model.Meeting;
import mm.model.Meeting.meetingStatus;
import mm.model.Meeting.meetingType;
import mm.model.Mentee;
import mm.model.Mentor;
import mm.model.Pair;
import mm.model.Session;
import mm.model.TsofenT;
import mm.model.User;
import mm.model.User.userType;
import mm.model.WorkPlace;

public class DataAccess implements DataInterface {

	private Connection c;

	final String selectLogin = "Select * From users where email=?";
	final String selectLogin1 = "Select * From mentors where id=?";
	final String selectLogin2 = "Select * From mentees where id=?";
	final String selectByType = "Select * from users where type=?";
//	final String selectCorrespondingMentors = "Select * From mentors where address=?, gender=?, company=?,  ";
//	final String selectCorrespondingMentees = "Select * From mentees where  =?";
//	final String selectCorrespondingPairs = "Select * From pairs where id=?";
	final String selectByID = "Select * From users where id=?";
	final String selectMentor = "Select * from users RIGHT JOIN mentors ON users.id = mentors.id";
	final String selectMentee = "Select * from users RIGHT JOIN mentees ON users.id = mentees.id";
	final String sessionId = "Select * From sessions where userId=?"; // to
																		// check
	final String getMenteeofPair = "Select * From pairs where menteeId=?, activeStatus=?";
	final String getMentorofPair = "Select * From pairs where mentorId=?, activeStatus=?";
	final String updateUserBase = "UPDATE users SET firstName=?, lastName=?, phoneNumber=?, gender=?, address=?, notes=?, profilePicture=?, active=? WHERE id=?";
	final String updateUserMentor = "UPDATE mentors SET experience=?, role=?, company=?, volunteering=?, workHistory=? WHERE id=?";
	final String updateUserMentee = "UPDATE mentees SET remainingSemesters=?, graduationStatus=?, academicInstitute=?, average=?, academicDicipline1=?, academicDicipline2=?, signedEULA=?, resume=?, gradeSheet=? WHERE id=?";
	final String deactivateUser = "UPDATE users SET active=0 WHERE id=?";
	final String addBaseUser = "INSERT INTO users (type, firstName, lastName, email, phoneNumber, password, gender, address, notes, profilePicture, active) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	final String addMenteeUser = "INSERT INTO mentees (id, remainingSemesters, graduationStatus, academicInstitute, average, academicDicipline1, academicDicipline2, signedEULA, resume, gradeSheet) VALUES (?,?,?,?,?,?,?,?,?,?)";
	final String addMentorUser = "INSERT INTO mentors (id, experience, role, company, volunteering, workHistory) VALUES (?,?,?,?,?,?)";
	final String insertPair = "INSERT INTO pairs (mentorId, menteeId, activeStatus, startDate) VALUES (?,?,?,?)";
	final String selectAllPairs = "Select * from pairs";
	final String selectPairId = "Select * From pairs Where pairId=?"; 
	final String updateActiveStatus = "UPDATE pairs SET activeStatus=0 WHERE pairId=?";
	final String selectMeeting = "Select * From activities where mentorId=? ";
	final String selectMeeting2 = "Select * From activites where menteeId=? ";
	final String addUserSession = "INSERT INTO sessions (userId, token, creationDate, expirationDate, deviceId) VALUES (?,?,?,?,?)";
	final String selectMeetingById = "Select * From activities where activityId=?";
	final String selectMeetingByPair = "Select * From activities where pairId=?";
	final String addMeeting = "INSERT INTO activities (mentorId,menteeId,pairId,note,status,menteeReport,mentorReport,menteePrivateReport,mentorPrivateReport,meetingType,subject,location,date,startingTime,endingTime,mentorComplete,menteeComplete)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	final String getAllMentorsWithoutMentees = "select u.*,m.* from users as u right JOIN mentors as m ON u.id = m.id where (m.id  in (select mentorId from pairs where mentorId = m.id  and activeStatus = 0	) and NOT EXISTS(select mentorId	from pairs where mentorId = m.id  and activeStatus = 1)) or not exists(select * from pairs where mentorId=m.id)";
	final String getAllMenteesWithoutMentor = "select u.*,m.* from users as u right JOIN mentees as m ON u.id = m.id  where (m.id  in (select menteeId from pairs where menteeId = m.id  and activeStatus = 0	)and NOT EXISTS(select menteeId	from pairs	where menteeId = m.id  and activeStatus = 1)) or not exists(select * from pairs where menteeId=m.id)";
	final String insertAcademicinstitute = "INSERT INTO academicinstitute (name, area, city) VALUES (?,?,?)";
	
	final String getMeetings1 = "Select * From activities where mentorId=? AND status=? ORDER BY date DESC LIMIT ?, ?";
	final String insertWorkPlace = "INSERT INTO workplaces (name,area,city,address ) VALUES (?,?,?,?)";
	final String getMeetings2 = "Select * From activities where menteeId=? AND status=? ORDER BY date DESC LIMIT ?, ? ";
    final String  selectAcademicInstitute ="Select * From academicinstitute";
	final String selectWorkPlace ="Select * From workplaces";
	final String selectWorkPlaceId="Select * From workplaces where id=? ";
	final String selectAcademicInstituteId = "Select * From academicinstitute where id =?";
	
	public DataAccess() {

		Logger logger = Logger.getLogger(DataAccess.class.getName());
		logger.log(Level.INFO, "DataAccess c'tor: attempting connection...");
		c = util.DBUtil.getConnection();
		if (c == null) {
			logger.log(Level.SEVERE, "Connection Failed");
		} else {
			logger.log(Level.INFO, "Connection Established");
		}
	}

	public User login(String email) throws SQLException {
		Logger logger = Logger.getLogger(DataAccess.class.getName());
		if (c == null) {
			logger.log(Level.SEVERE, "Connection Failed");
			return null;
		}
		PreparedStatement stm = c.prepareStatement(SQLStatements.selectUserByEmail);
		stm.setString(1, email);

		ResultSet rs = stm.executeQuery();
		User u = null;
		if (rs.next()) {
			int type = rs.getInt(DataContract.UsersTable.COL_TYPE);
			switch (type) {

			case 0: // Admin
				logger.log(Level.WARNING, "User type Admin, no admins exist in the system at this time");
				break;
			case 1: // Tsofen member
				logger.log(Level.INFO, "User type Tsofen");
				u = new TsofenT(rs.getInt(DataContract.UsersTable.COL_ID),
						rs.getString(DataContract.UsersTable.COL_FIRSTNAME),
						rs.getString(DataContract.UsersTable.COL_LASTNAME),
						rs.getString(DataContract.UsersTable.COL_EMAIL),
						rs.getString(DataContract.UsersTable.COL_PHONENUMBER),
						rs.getString(DataContract.UsersTable.COL_PASSWORD),
						rs.getInt(DataContract.UsersTable.COL_GENDER),
						rs.getString(DataContract.UsersTable.COL_ADDRESS),
						rs.getString(DataContract.UsersTable.COL_NOTES),
						rs.getString(DataContract.UsersTable.COL_PROFILEPICTURE),
						rs.getBoolean(DataContract.UsersTable.COL_ACTIVE), userType.TSOFEN);
				break;
			case 2:// Mentor
				logger.log(Level.INFO, "User type Mentor");
				PreparedStatement stm2 = c.prepareStatement(SQLStatements.selectMentorById);
				stm2.setInt(1, rs.getInt(DataContract.MentorsTable.COL_ID));

				ResultSet rs2 = stm2.executeQuery();
				if(rs2.next())
				u = new Mentor(rs.getInt(DataContract.UsersTable.COL_ID),
						rs.getString(DataContract.UsersTable.COL_FIRSTNAME),
						rs.getString(DataContract.UsersTable.COL_LASTNAME),
						rs.getString(DataContract.UsersTable.COL_EMAIL),
						rs.getString(DataContract.UsersTable.COL_PHONENUMBER),
						rs.getString(DataContract.UsersTable.COL_PASSWORD),
						rs.getInt(DataContract.UsersTable.COL_GENDER),
						rs.getString(DataContract.UsersTable.COL_ADDRESS),
						rs.getString(DataContract.UsersTable.COL_NOTES),
						rs.getString(DataContract.UsersTable.COL_PROFILEPICTURE),
						rs.getBoolean(DataContract.UsersTable.COL_ACTIVE), userType.MENTOR,
						rs2.getString(DataContract.MentorsTable.COL_EXPERIENCE),
						rs2.getString(DataContract.MentorsTable.COL_ROLE),
						rs2.getInt(DataContract.MentorsTable.COL_COMPANY),
						rs2.getString(DataContract.MentorsTable.COL_VOLUNTEERING),
						rs2.getString(DataContract.MentorsTable.COL_WORKHISTORY));
				rs2.close();
				stm2.close();
				break;
			case 3:// Mentee
				logger.log(Level.INFO, "User type Mentee");
				PreparedStatement stm3 = c.prepareStatement(SQLStatements.selectMenteeById);
				stm3.setInt(1, rs.getInt(DataContract.MenteeTable.COL_ID));

				ResultSet rs3 = stm3.executeQuery();
				if (rs3.next())
					u = new Mentee(rs.getInt(DataContract.UsersTable.COL_ID),
							rs.getString(DataContract.UsersTable.COL_FIRSTNAME),
							rs.getString(DataContract.UsersTable.COL_LASTNAME),
							rs.getString(DataContract.UsersTable.COL_EMAIL),
							rs.getString(DataContract.UsersTable.COL_PHONENUMBER),
							rs.getString(DataContract.UsersTable.COL_PASSWORD),
							rs.getInt(DataContract.UsersTable.COL_GENDER),
							rs.getString(DataContract.UsersTable.COL_ADDRESS),
							rs.getString(DataContract.UsersTable.COL_PROFILEPICTURE),
							rs.getString(DataContract.UsersTable.COL_NOTES),
							rs.getBoolean(DataContract.UsersTable.COL_ACTIVE), userType.MENTEE,
							rs3.getFloat(DataContract.MenteeTable.COL_REMAININGSEMESTERS),
							rs3.getString(DataContract.MenteeTable.COL_GRADUATIONSTATUS),
							rs3.getInt(DataContract.MenteeTable.COL_ACADEMICINSTITUTE),
							rs3.getFloat(DataContract.MenteeTable.COL_AVERAGE),
							rs3.getString(DataContract.MenteeTable.COL_ACADEMICDICIPLINE1),
							rs3.getString(DataContract.MenteeTable.COL_ACADEMICDICIPLINE2),
							rs3.getBoolean(DataContract.MenteeTable.COL_SIGNEDEULA),
							rs3.getString(DataContract.MenteeTable.COL_RESUME),
							rs3.getString(DataContract.MenteeTable.COL_GRADESHEET));
				break;

			default:
				logger.log(Level.WARNING, "User type unknown");
				break;
			}
		}

		rs.close();
		stm.close();
		return u;
	}

	public boolean editUser(User user) throws SQLException {
		PreparedStatement stm = c.prepareStatement(SQLStatements.selectUserById);
		stm.setInt(1, user.getId());
		ResultSet rs = stm.executeQuery();
		if (!rs.next()) // user does not exist
			return false;

		PreparedStatement stm2 = c.prepareStatement(SQLStatements.updateUserById);
		stm2.setString(1, user.getFirstName());
		stm2.setString(2, user.getLastName());
		stm2.setString(3, user.getPhoneNumber());
		stm2.setInt(4, user.getGender());
		stm2.setString(5, user.getAddress());
		stm2.setString(6, user.getNote());
		stm2.setString(7, user.getProfilePicture());
		stm2.setInt(8, user.isActive() ? 1 : 0);
		stm2.setInt(9, user.getId());
		stm2.executeUpdate();

		if (user.getType() == userType.TSOFEN || user.getType() == userType.ADMIN)
			return true;

		if (user.getType() == userType.MENTOR) {
			PreparedStatement stm3 = c.prepareStatement(SQLStatements.updateMentorById);
			
			stm3.setString(1, ((Mentor) user).getExperience());
			stm3.setString(2, ((Mentor) user).getRole());
			stm3.setInt(3, ((Mentor) user).getCompany());
			stm3.setString(4, ((Mentor) user).getVolunteering());
			stm3.setString(5, ((Mentor) user).getWorkHistory());
			stm3.setInt(6, user.getId());
			stm3.executeUpdate();
			return true;
		}

		if (user.getType() == userType.MENTEE) {
			PreparedStatement stm4 = c.prepareStatement(SQLStatements.updaterMenteeById);
			stm4.setFloat(1, ((Mentee) user).getRemainingSemesters());
			stm4.setString(2, ((Mentee) user).getGraduationStatus());
			stm4.setInt(3, ((Mentee) user).getAcademiclnstitution());
			stm4.setFloat(4, ((Mentee) user).getAverage());
			stm4.setString(5, ((Mentee) user).getAcademicDicipline());
			stm4.setString(6, ((Mentee) user).getAcademicDicipline2());
			stm4.setInt(7, ((Mentee) user).getSignedEULA() ? 1 : 0);
			stm4.setString(8, ((Mentee) user).getResume());
			stm4.setString(9, ((Mentee) user).getGradeSheet());
			stm4.setInt(10, user.getId());
			stm4.executeUpdate();
			return true;
		}

		return false;
	}

	public boolean deactivateUser(int id) throws SQLException {
		PreparedStatement stm = c.prepareStatement(SQLStatements.selectUserById);
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			PreparedStatement stm2 = c.prepareStatement(SQLStatements.setUserDeactiveById);
			stm2.setInt(1, id);
			return true;
		}
		return false;
	}

	/*
	 * public ArrayList<User> getAllMentors(int id) throws SQLException {
	 * ArrayList<User> list= new ArrayList<User>(); PreparedStatement stm =
	 * c.prepareStatement(findMentorsOfMentee); stm.setInt(1, id); ResultSet rs
	 * = stm.executeQuery(); while (rs.next()) { list.add(new
	 * Mentor(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5),
	 * rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
	 * rs.getString(10), rs.getBoolean(11), userType.MENTOR, rs2.getString(2),
	 * rs2.getString(3), rs2.getInt(4), rs2.getString(5), rs2.getString(6))); }
	 * return null; }
	 */

	@Override
	public boolean addUser(User u) throws SQLException {
		PreparedStatement stm = c.prepareStatement(SQLStatements.selectUserByEmail);
		stm.setString(1, u.getEmail());
		ResultSet rs = stm.executeQuery();
		if (rs.next()) // user exists
		{
			System.out.println("rs.next(): " + rs.getString(3));
			System.out.println("BAD, USER ALREADY EXISTS");
			return false;
		}
		PreparedStatement stm2 = c.prepareStatement(SQLStatements.insertUser);
		stm2.setInt(1, u.getType().getValue());
		stm2.setString(2, u.getFirstName());
		stm2.setString(3, u.getLastName());
		stm2.setString(4, u.getEmail());
		stm2.setString(5, u.getPhoneNumber());
		stm2.setString(6, u.getPassword());
		stm2.setInt(7, u.getGender());
		stm2.setString(8, u.getAddress());
		stm2.setString(9, u.getNote());
		stm2.setString(10, u.getProfilePicture());
		stm2.setInt(11, u.isActive() ? 1 : 0);
		stm2.executeUpdate();

		stm = c.prepareStatement(selectLogin);
		stm.setString(1, u.getEmail());
		rs = stm.executeQuery();
		int id = 0;
		if (rs.next()) // user exists
		{
			id = rs.getInt(1);
		} else {
			return false;
		}

		if (u.getType() == userType.TSOFEN || u.getType() == userType.ADMIN)
			return true;

		if (u.getType() == userType.MENTOR) {
			PreparedStatement stm3 = c.prepareStatement(SQLStatements.insertMentor);
			stm3.setInt(1, id);
			stm3.setString(2, ((Mentor) u).getExperience());
			stm3.setString(3, ((Mentor) u).getRole());
			stm3.setInt(4, ((Mentor) u).getCompany());
			stm3.setString(5, ((Mentor) u).getVolunteering());
			stm3.setString(6, ((Mentor) u).getWorkHistory());

			stm3.executeUpdate();
			return true;
		}

		if (u.getType() == userType.MENTEE) {
			PreparedStatement stm4 = c.prepareStatement(SQLStatements.insertMentee);
			stm4.setInt(1, id);
			stm4.setFloat(2, ((Mentee) u).getRemainingSemesters());
			stm4.setString(3, ((Mentee) u).getGraduationStatus());
			stm4.setInt(4, ((Mentee) u).getAcademiclnstitution());
			stm4.setFloat(5, ((Mentee) u).getAverage());
			stm4.setString(6, ((Mentee) u).getAcademicDicipline());
			stm4.setString(7, ((Mentee) u).getAcademicDicipline2());
			stm4.setInt(8, ((Mentee) u).getSignedEULA() ? 1 : 0);
			stm4.setString(9, ((Mentee) u).getResume());
			stm4.setString(10, ((Mentee) u).getGradeSheet());
			stm4.executeUpdate();
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<User> getUsers(userType type) throws SQLException {
		User u = null;
		ArrayList<User> users = new ArrayList<User>();
		switch (type) {
		case ADMIN:
			break;
		case TSOFEN:
			PreparedStatement stm = c.prepareStatement(SQLStatements.selectUserByType);
			stm.setInt(1, type.getValue());
			ResultSet r = stm.executeQuery();
			while (r.next()) {
				u = new TsofenT(r.getInt(DataContract.UsersTable.COL_ID),
						r.getString(DataContract.UsersTable.COL_FIRSTNAME),
						r.getString(DataContract.UsersTable.COL_LASTNAME),
						r.getString(DataContract.UsersTable.COL_EMAIL),
						r.getString(DataContract.UsersTable.COL_PHONENUMBER),
						r.getString(DataContract.UsersTable.COL_PASSWORD),
						r.getInt(DataContract.UsersTable.COL_GENDER),
						r.getString(DataContract.UsersTable.COL_ADDRESS),
						r.getString(DataContract.UsersTable.COL_NOTES),
						r.getString(DataContract.UsersTable.COL_PROFILEPICTURE),
						r.getBoolean(DataContract.UsersTable.COL_ACTIVE), userType.TSOFEN);
			}

			break;
		case MENTOR:

			Statement stm2 = c.createStatement();
			stm2.executeQuery(SQLStatements.selectMentor);
			ResultSet r2 = stm2.getResultSet();
			while (r2.next()) {
				u = new Mentor(r2.getInt(DataContract.UsersTable.COL_ID),
						r2.getString(DataContract.UsersTable.COL_FIRSTNAME),
						r2.getString(DataContract.UsersTable.COL_LASTNAME),
						r2.getString(DataContract.UsersTable.COL_EMAIL),
						r2.getString(DataContract.UsersTable.COL_PHONENUMBER),
						r2.getString(DataContract.UsersTable.COL_PASSWORD),
						r2.getInt(DataContract.UsersTable.COL_GENDER),
						r2.getString(DataContract.UsersTable.COL_ADDRESS),
						r2.getString(DataContract.UsersTable.COL_NOTES),
						r2.getString(DataContract.UsersTable.COL_PROFILEPICTURE),
						r2.getBoolean(DataContract.UsersTable.COL_ACTIVE), userType.MENTOR, 
						r2.getString(DataContract.MentorsTable.COL_EXPERIENCE),
						r2.getString(DataContract.MentorsTable.COL_ROLE),
						r2.getInt(DataContract.MentorsTable.COL_COMPANY),
						r2.getString(DataContract.MentorsTable.COL_VOLUNTEERING),
						r2.getString(DataContract.MentorsTable.COL_WORKHISTORY));
				users.add(u);
			}

			break;
		case MENTEE:

			Statement stm3 = c.createStatement();
			stm3.executeQuery(SQLStatements.selectMentee);
			ResultSet r3 = stm3.getResultSet();
			while (r3.next()) {
				u = new Mentee(r3.getInt(DataContract.UsersTable.COL_ID),
						r3.getString(DataContract.UsersTable.COL_FIRSTNAME),
						r3.getString(DataContract.UsersTable.COL_LASTNAME),
						r3.getString(DataContract.UsersTable.COL_EMAIL),
						r3.getString(DataContract.UsersTable.COL_PHONENUMBER),
						r3.getString(DataContract.UsersTable.COL_PASSWORD),
						r3.getInt(DataContract.UsersTable.COL_GENDER),
						r3.getString(DataContract.UsersTable.COL_ADDRESS),
						r3.getString(DataContract.UsersTable.COL_PROFILEPICTURE),
						r3.getString(DataContract.UsersTable.COL_NOTES),
						r3.getBoolean(DataContract.UsersTable.COL_ACTIVE), userType.MENTEE,
						r3.getFloat(DataContract.MenteeTable.COL_REMAININGSEMESTERS),
						r3.getString(DataContract.MenteeTable.COL_GRADUATIONSTATUS),
						r3.getInt(DataContract.MenteeTable.COL_ACADEMICINSTITUTE),
						r3.getFloat(DataContract.MenteeTable.COL_AVERAGE),
						r3.getString(DataContract.MenteeTable.COL_ACADEMICDICIPLINE1),
						r3.getString(DataContract.MenteeTable.COL_ACADEMICDICIPLINE2),
						r3.getBoolean(DataContract.MenteeTable.COL_SIGNEDEULA),
						r3.getString(DataContract.MenteeTable.COL_RESUME),
						r3.getString(DataContract.MenteeTable.COL_GRADESHEET));
				users.add(u);
			}
			break;

		default:
			break;
		}
		return users;
	}

	@Override
	public ArrayList<Pair> getAllPairs() throws SQLException {
		Pair p = new Pair();
		ArrayList<Pair> pair = new ArrayList<Pair>();
		Statement stm = c.createStatement();
		stm.executeQuery(SQLStatements.selectPairs);
		ResultSet r = stm.getResultSet();

		while (r.next()) {
			p = new Pair(r.getInt(DataContract.PairsTable.COL_PAIRID),
					r.getInt(DataContract.PairsTable.COL_MENTORID),
					r.getInt(DataContract.PairsTable.COL_MENTEEID),
					r.getInt(DataContract.PairsTable.COL_ACTIVESTATUS),
					r.getLong(DataContract.PairsTable.COL_STARTDATE), 
					r.getLong(DataContract.PairsTable.COL_ENDDATE),
					r.getString(DataContract.PairsTable.COL_JOINTMESSAGE),
					r.getString(DataContract.PairsTable.COL_TSOFENMESSAGE));
			pair.add(p);
		}
		return pair;
	}

	@Override
	public User getUser(int id) throws SQLException {
		User user = null;
		PreparedStatement stm = c.prepareStatement(SQLStatements.selectUserById);
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			int type = rs.getInt(2);
			switch (type) {
	
			case 0:
				break;
			case 1:
				user = new TsofenT(rs.getInt(DataContract.UsersTable.COL_ID),
						rs.getString(DataContract.UsersTable.COL_FIRSTNAME),
						rs.getString(DataContract.UsersTable.COL_LASTNAME),
						rs.getString(DataContract.UsersTable.COL_EMAIL),
						rs.getString(DataContract.UsersTable.COL_PHONENUMBER),
						rs.getString(DataContract.UsersTable.COL_PASSWORD),
						rs.getInt(DataContract.UsersTable.COL_GENDER),
						rs.getString(DataContract.UsersTable.COL_ADDRESS),
						rs.getString(DataContract.UsersTable.COL_NOTES),
						rs.getString(DataContract.UsersTable.COL_PROFILEPICTURE),
						rs.getBoolean(DataContract.UsersTable.COL_ACTIVE), userType.TSOFEN);
				
				break;
			case 2:
				PreparedStatement stm2 = c.prepareStatement(SQLStatements.selectMentorById);
				stm2.setInt(1, rs.getInt(DataContract.UsersTable.COL_ID));
	
				ResultSet rs2 = stm2.executeQuery();
				if (rs2.next())
					user = new Mentor(rs.getInt(DataContract.UsersTable.COL_ID),
							rs.getString(DataContract.UsersTable.COL_FIRSTNAME),
							rs.getString(DataContract.UsersTable.COL_LASTNAME),
							rs.getString(DataContract.UsersTable.COL_EMAIL),
							rs.getString(DataContract.UsersTable.COL_PHONENUMBER),
							rs.getString(DataContract.UsersTable.COL_PASSWORD),
							rs.getInt(DataContract.UsersTable.COL_GENDER),
							rs.getString(DataContract.UsersTable.COL_ADDRESS),
							rs.getString(DataContract.UsersTable.COL_NOTES),
							rs.getString(DataContract.UsersTable.COL_PROFILEPICTURE),
							rs.getBoolean(DataContract.UsersTable.COL_ACTIVE), userType.MENTOR,
							rs2.getString(DataContract.MentorsTable.COL_EXPERIENCE),
							rs2.getString(DataContract.MentorsTable.COL_ROLE),
							rs2.getInt(DataContract.MentorsTable.COL_COMPANY),
							rs2.getString(DataContract.MentorsTable.COL_VOLUNTEERING),
							rs2.getString(DataContract.MentorsTable.COL_WORKHISTORY));
				break;
			case 3:
				PreparedStatement stm3 = c.prepareStatement(SQLStatements.selectMenteeById);
				stm3.setInt(1, rs.getInt(1));
	
				ResultSet rs3 = stm3.executeQuery();
				if (rs3.next())
					user = new Mentee(rs.getInt(DataContract.UsersTable.COL_ID),
							rs.getString(DataContract.UsersTable.COL_FIRSTNAME),
							rs.getString(DataContract.UsersTable.COL_LASTNAME),
							rs.getString(DataContract.UsersTable.COL_EMAIL),
							rs.getString(DataContract.UsersTable.COL_PHONENUMBER),
							rs.getString(DataContract.UsersTable.COL_PASSWORD),
							rs.getInt(DataContract.UsersTable.COL_GENDER),
							rs.getString(DataContract.UsersTable.COL_ADDRESS),
							rs.getString(DataContract.UsersTable.COL_PROFILEPICTURE),
							rs.getString(DataContract.UsersTable.COL_NOTES),
							rs.getBoolean(DataContract.UsersTable.COL_ACTIVE), userType.MENTEE,
							rs3.getFloat(DataContract.MenteeTable.COL_REMAININGSEMESTERS),
							rs3.getString(DataContract.MenteeTable.COL_GRADUATIONSTATUS),
							rs3.getInt(DataContract.MenteeTable.COL_ACADEMICINSTITUTE),
							rs3.getFloat(DataContract.MenteeTable.COL_AVERAGE),
							rs3.getString(DataContract.MenteeTable.COL_ACADEMICDICIPLINE1),
							rs3.getString(DataContract.MenteeTable.COL_ACADEMICDICIPLINE2),
							rs3.getBoolean(DataContract.MenteeTable.COL_SIGNEDEULA),
							rs3.getString(DataContract.MenteeTable.COL_RESUME),
							rs3.getString(DataContract.MenteeTable.COL_GRADESHEET));
				break;
			default:
				break;
			}
	
		}
		return user;
	}

	@Override
	public boolean addPair(int mentorId, int menteeId) throws SQLException {
		PreparedStatement stm = c.prepareStatement(SQLStatements.selectMentorById);
		stm.setInt(1, mentorId);
		ResultSet rs = stm.executeQuery();
		if (!rs.next()) // user does not exist
			return false;
		stm = c.prepareStatement(SQLStatements.selectMenteeById);
		stm.setInt(1, menteeId);
		ResultSet rs1 = stm.executeQuery();
		if (!rs1.next()) // user does not exist
			return false;
		stm = c.prepareStatement(SQLStatements.selectMenteeInPair);
		stm.setInt(1, menteeId);
		ResultSet rs2 = stm.executeQuery();
		if (!rs2.next()) // user does not exist
			return false;
		stm = c.prepareStatement(SQLStatements.insertPair);
		// checking witch user is the mentor and witch is the mentee
		stm.setInt(1, mentorId);
		stm.setInt(2, menteeId);
		stm.setInt(3, 1);
		stm.setDate(4, Date.valueOf(LocalDate.now()));
		stm.executeUpdate();
		return true;

	}

	@Override
	public Pair addPair1(int mentorId, int menteeId) throws SQLException {
		Pair p = null;
		PreparedStatement stm = c.prepareStatement(selectLogin1);
		stm.setInt(1, mentorId);
		ResultSet rs = stm.executeQuery();
		if (!rs.next()) // user does not exist
			throw new SQLException("user-mentor does not exist");
		stm = c.prepareStatement(selectLogin2);
		stm.setInt(1, menteeId);
		ResultSet rs1 = stm.executeQuery();
		if (!rs1.next()) // user does not exist
			throw new SQLException("user-mentee does not exist");
		stm = c.prepareStatement(insertPair, Statement.RETURN_GENERATED_KEYS);
		// checking witch user is the mentor and witch is the mentee
		stm.setInt(1, mentorId);
		stm.setInt(2, menteeId);
		stm.setInt(3, 1);
		stm.setDate(4, Date.valueOf(LocalDate.now()));
		int num = stm.executeUpdate();
		if (num == 0) {
			throw new SQLException("Creating pair failed, no rows affected.");

		}

		try (ResultSet generatedKeys = stm.getGeneratedKeys()) {
			if (generatedKeys.next()) {
				p = getPair(generatedKeys.getInt(1));
			} else {
				throw new SQLException("Creating user failed, no ID obtained.");

			}

		}
		return p;

	}

	@Override
	public boolean disconnectPair(int pairId) {
		try {
			PreparedStatement stm = c.prepareStatement(SQLStatements.setPairDeactiveById);
			stm.setInt(1, pairId);
			stm.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	@Override
	public Pair getPair(int pairId) throws SQLException {
		PreparedStatement stm = c.prepareStatement(SQLStatements.selectPairById);

		stm.setInt(1, pairId);

		ResultSet rs = stm.executeQuery();

		if (!rs.next()) // user does not exist
			return null;
		Date d = rs.getDate(DataContract.PairsTable.COL_ENDDATE);
		long l = -1 ;
		if(d!=null) l=d.getTime();			
		return new Pair(rs.getInt(DataContract.PairsTable.COL_PAIRID),
				rs.getInt(DataContract.PairsTable.COL_MENTORID),
				rs.getInt(DataContract.PairsTable.COL_MENTEEID),
				getUser(rs.getInt(DataContract.PairsTable.COL_MENTORID)),
				getUser(rs.getInt(DataContract.PairsTable.COL_MENTEEID)),
				rs.getInt(DataContract.PairsTable.COL_ACTIVESTATUS),
				rs.getDate(DataContract.PairsTable.COL_STARTDATE).getTime(), l,
				rs.getString(DataContract.PairsTable.COL_JOINTMESSAGE),
				rs.getString(DataContract.PairsTable.COL_TSOFENMESSAGE));
	}

	@Override
	public ArrayList<Session> getUserSessions(int id) throws SQLException {
		ArrayList<Session> session = new ArrayList<Session>();
		Session s = null;
		PreparedStatement stm = c.prepareStatement(SQLStatements.selectSessionByUserId);

		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			s = new Session(id, rs.getString(DataContract.SessionsTable.COL_TOKEN),
					rs.getLong(DataContract.SessionsTable.COL_CREATIONDATE), 
					rs.getLong(DataContract.SessionsTable.COL_EXPIRATIONDATE),
					rs.getString(DataContract.SessionsTable.COL_DEVICEID));
			session.add(s);
			
		}
		
		return session;
	}

	@Override
	public ArrayList<Meeting> getUserMeetings(int id) throws SQLException {
		ArrayList<Meeting> meeting = new ArrayList<Meeting>();
		Meeting meet = null;
		PreparedStatement stm = c.prepareStatement(SQLStatements.selectMeetingsByMentorId);
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {

			meet = new Meeting(rs.getInt(DataContract.MeetingTable.COL_ACTIVITYID),
					rs.getInt(DataContract.MeetingTable.COL_PAIRID),
					rs.getInt(DataContract.MeetingTable.COL_MENTORID),
					rs.getInt(DataContract.MeetingTable.COL_MENTEEID),
					rs.getString(DataContract.MeetingTable.COL_NOTE),
					meetingStatus.valueOf(rs.getInt(DataContract.MeetingTable.COL_STATUS)),
					rs.getString(DataContract.MeetingTable.COL_MENTEEREPORT),
					rs.getString(DataContract.MeetingTable.COL_MENTORREPORT),
					rs.getString(DataContract.MeetingTable.COL_MENTEEPRIVREPORT),
					rs.getString(DataContract.MeetingTable.COL_MENTORPRIVREPORT),
					meetingType.getByValue(rs.getInt(DataContract.MeetingTable.COL_MEETINGTYPE)),
					rs.getString(DataContract.MeetingTable.COL_SUBJECT),
					rs.getString(DataContract.MeetingTable.COL_LOCATION),
					rs.getLong(DataContract.MeetingTable.COL_DATE), 
					rs.getTime(DataContract.MeetingTable.COL_STARTINGTIME),
					rs.getTime(DataContract.MeetingTable.COL_ENDINGTIME),
					rs.getBoolean(DataContract.MeetingTable.COL_MENTORCOMPLETE),
					rs.getBoolean(DataContract.MeetingTable.COL_MENTEECOMPLETE));
			
		} else {
			PreparedStatement stm1 = c.prepareStatement(SQLStatements.selectMeetingsByMenteeId);
			stm1.setInt(1, id);
			ResultSet rs1 = stm.executeQuery();
			if (rs1.next()) {
				meet = new Meeting(rs.getInt(DataContract.MeetingTable.COL_ACTIVITYID),
						rs.getInt(DataContract.MeetingTable.COL_PAIRID),
						rs.getInt(DataContract.MeetingTable.COL_MENTORID),
						rs.getInt(DataContract.MeetingTable.COL_MENTEEID),
						rs.getString(DataContract.MeetingTable.COL_NOTE),
						meetingStatus.valueOf(rs.getInt(DataContract.MeetingTable.COL_STATUS)),
						rs.getString(DataContract.MeetingTable.COL_MENTEEREPORT),
						rs.getString(DataContract.MeetingTable.COL_MENTORREPORT),
						rs.getString(DataContract.MeetingTable.COL_MENTEEPRIVREPORT),
						rs.getString(DataContract.MeetingTable.COL_MENTORPRIVREPORT),
						meetingType.getByValue(rs.getInt(DataContract.MeetingTable.COL_MEETINGTYPE)),
						rs.getString(DataContract.MeetingTable.COL_SUBJECT),
						rs.getString(DataContract.MeetingTable.COL_LOCATION),
						rs.getLong(DataContract.MeetingTable.COL_DATE), 
						rs.getTime(DataContract.MeetingTable.COL_STARTINGTIME),
						rs.getTime(DataContract.MeetingTable.COL_ENDINGTIME),
						rs.getBoolean(DataContract.MeetingTable.COL_MENTORCOMPLETE),
						rs.getBoolean(DataContract.MeetingTable.COL_MENTEECOMPLETE));
				meeting.add(meet);

			}
		}

		return meeting;
	}

	@Override
	public Mentor getMentorOfMentee(int menteeId) throws SQLException {
		PreparedStatement stm = c.prepareStatement(SQLStatements.selectPairsByMenteeIdAndActiveStats);
		stm.setInt(1, menteeId);
		
		stm.setInt(2, 1);
		ResultSet rs = stm.executeQuery();
		if(rs.next()) {
		return (Mentor) getUser(rs.getInt(2));
		}
		return null;

	}

	@Override
	public ArrayList<Mentee> getMenteesOfMentor(int mentorId) throws SQLException {
		ArrayList<Mentee> mentees = new ArrayList<Mentee>();
		PreparedStatement stm = c.prepareStatement(SQLStatements.selectPairsByMentorIdAndActiveStats);
		stm.setInt(1, mentorId);
		stm.setInt(2, 1);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {	
			
			mentees.add((Mentee) getUser(rs.getInt(3)));
		}
	
		return mentees;
	}

	@Override
	public Meeting getMeetingById(int meetingId) throws SQLException {
		Meeting m = null;
		PreparedStatement stm = c.prepareStatement(SQLStatements.selectMeetingById);
		stm.setInt(1, meetingId);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			m = new Meeting(rs.getInt(DataContract.MeetingTable.COL_ACTIVITYID),
					rs.getInt(DataContract.MeetingTable.COL_PAIRID),
					rs.getInt(DataContract.MeetingTable.COL_MENTORID),
					rs.getInt(DataContract.MeetingTable.COL_MENTEEID),
					rs.getString(DataContract.MeetingTable.COL_NOTE),
					meetingStatus.valueOf(rs.getInt(DataContract.MeetingTable.COL_STATUS)),
					rs.getString(DataContract.MeetingTable.COL_MENTEEREPORT),
					rs.getString(DataContract.MeetingTable.COL_MENTORREPORT),
					rs.getString(DataContract.MeetingTable.COL_MENTEEPRIVREPORT),
					rs.getString(DataContract.MeetingTable.COL_MENTORPRIVREPORT),
					meetingType.getByValue(rs.getInt(DataContract.MeetingTable.COL_MEETINGTYPE)),
					rs.getString(DataContract.MeetingTable.COL_SUBJECT),
					rs.getString(DataContract.MeetingTable.COL_LOCATION),
					rs.getLong(DataContract.MeetingTable.COL_DATE), 
					rs.getTime(DataContract.MeetingTable.COL_STARTINGTIME),
					rs.getTime(DataContract.MeetingTable.COL_ENDINGTIME),
					rs.getBoolean(DataContract.MeetingTable.COL_MENTORCOMPLETE),
					rs.getBoolean(DataContract.MeetingTable.COL_MENTEECOMPLETE));

			

		}
		return m;
	}

	@Override
	public boolean startUserSession(Session session) throws SQLException {
		PreparedStatement stm = c.prepareStatement(SQLStatements.insertSession);
		stm.setInt(1, session.getUserId());
		stm.setString(2, session.getToken());
		stm.setLong(3, session.getCreationDate());
		stm.setLong(4, session.getExpirationDate());
		stm.setString(5, session.getDeviceId());
		stm.executeUpdate();

		return true;

	}

	@Override
	public boolean addMeeting(Meeting meeting) {
		try
		{
			String d=null;
			PreparedStatement stm = c.prepareStatement(SQLStatements.addMeeting);
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			try {
			     d= f.format(new Date(meeting.getDate()));
			
			} catch (Exception e) {
				e.printStackTrace();
			}
//			mentorId,menteeId,pairId,note,status,menteeReport,
//			mentorReport,menteePrivateReport,mentorPrivateReport,
//			meetingType,subject,location,date,startingTime,endingTime,mentorComplete,menteeComplete
//			
System.out.println(meeting.toString());
			stm.setInt(3, meeting.getPairId());
			System.out.println(meeting.getPairId());
			stm.setInt(1,meeting.getMentorId());
			System.out.println(meeting.getMentorId());
			stm.setInt(2, meeting.getMenteeId());
			System.out.println( meeting.getMenteeId());
			stm.setString(4, meeting.getNote());
			
			stm.setInt(5, meeting.getStatus().ordinal());
			System.out.println(meeting.getStatus().ordinal());
			stm.setString(6, meeting.getMenteeReport());
			stm.setString(7, meeting.getMentorReport());
			stm.setString(8, meeting.getMenteePrivateReport());
			stm.setString(9, meeting.getMentorPrivateReport());
			stm.setInt(10, meeting.getMeetingType().ordinal());
			stm.setString(11,meeting.getSubject());
			stm.setString(12,meeting.getLocation());
		

			stm.setString(13, d.toString());
			System.out.println(d.toString());
			stm.setString(14,meeting.getStartingDate().toString());
			stm.setString(15,meeting.getEndingDate().toString());
			stm.setBoolean(16,meeting.getMentorComplete());
			stm.setBoolean(17,meeting.getMenteeComplete());
			stm.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Meeting> getMeetingsByPairId(int pairId) throws SQLException {
		ArrayList<Meeting> m = new ArrayList<Meeting>();
		Meeting meeting = null;
		PreparedStatement stm = c.prepareStatement(SQLStatements.selectMeetingByPairId);
		stm.setInt(1, pairId);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			meeting = new Meeting(rs.getInt(DataContract.MeetingTable.COL_ACTIVITYID),
					rs.getInt(DataContract.MeetingTable.COL_PAIRID),
					rs.getInt(DataContract.MeetingTable.COL_MENTORID),
					rs.getInt(DataContract.MeetingTable.COL_MENTEEID),
					rs.getString(DataContract.MeetingTable.COL_NOTE),
					meetingStatus.valueOf(rs.getInt(DataContract.MeetingTable.COL_STATUS)),
					rs.getString(DataContract.MeetingTable.COL_MENTEEREPORT),
					rs.getString(DataContract.MeetingTable.COL_MENTORREPORT),
					rs.getString(DataContract.MeetingTable.COL_MENTEEPRIVREPORT),
					rs.getString(DataContract.MeetingTable.COL_MENTORPRIVREPORT),
					meetingType.getByValue(rs.getInt(DataContract.MeetingTable.COL_MEETINGTYPE)),
					rs.getString(DataContract.MeetingTable.COL_SUBJECT),
					rs.getString(DataContract.MeetingTable.COL_LOCATION),
					rs.getLong(DataContract.MeetingTable.COL_DATE), 
					rs.getTime(DataContract.MeetingTable.COL_STARTINGTIME),
					rs.getTime(DataContract.MeetingTable.COL_ENDINGTIME),
					rs.getBoolean(DataContract.MeetingTable.COL_MENTORCOMPLETE),
					rs.getBoolean(DataContract.MeetingTable.COL_MENTEECOMPLETE));
 m.add(meeting);
		}
		return m;
	}

	@Override
	public ArrayList<Mentee> getAllMenteesWithoutMentor() throws SQLException {
		Mentee u = null;
		ArrayList<Mentee> menteesList = new ArrayList<Mentee>();
		Statement stm = c.createStatement();
		stm.executeQuery(getAllMenteesWithoutMentor);
		ResultSet r = stm.getResultSet();
		while (r.next()) {
			u = new Mentee(r.getInt(DataContract.UsersTable.COL_ID), r.getString(DataContract.UsersTable.COL_FIRSTNAME),
					r.getString(DataContract.UsersTable.COL_LASTNAME), r.getString(DataContract.UsersTable.COL_EMAIL),
					r.getString(DataContract.UsersTable.COL_PHONENUMBER),
					r.getString(DataContract.UsersTable.COL_PASSWORD), r.getInt(DataContract.UsersTable.COL_GENDER),
					r.getString(DataContract.UsersTable.COL_ADDRESS),
					r.getString(DataContract.UsersTable.COL_PROFILEPICTURE),
					r.getString(DataContract.UsersTable.COL_NOTES), r.getBoolean(DataContract.UsersTable.COL_ACTIVE),
					userType.MENTEE, r.getFloat(DataContract.MenteeTable.COL_REMAININGSEMESTERS),
					r.getString(DataContract.MenteeTable.COL_GRADUATIONSTATUS),
					r.getInt(DataContract.MenteeTable.COL_ACADEMICINSTITUTE),
					r.getFloat(DataContract.MenteeTable.COL_AVERAGE),
					r.getString(DataContract.MenteeTable.COL_ACADEMICDICIPLINE1),
					r.getString(DataContract.MenteeTable.COL_ACADEMICDICIPLINE2),
					r.getBoolean(DataContract.MenteeTable.COL_SIGNEDEULA),
					r.getString(DataContract.MenteeTable.COL_RESUME),
					r.getString(DataContract.MenteeTable.COL_GRADESHEET));
			menteesList.add(u);
		}

		return menteesList;

	}

	@Override
	public ArrayList<Mentor> getAllMentorsWithoutMentees() throws SQLException {
		Mentor u = null;
		ArrayList<Mentor> mentorList = new ArrayList<Mentor>();
		Statement stm = c.createStatement();
		stm.executeQuery(getAllMentorsWithoutMentees);
		ResultSet r = stm.getResultSet();
		while (r.next()) {
			u = new Mentor(r.getInt(DataContract.UsersTable.COL_ID),
					r.getString(DataContract.UsersTable.COL_FIRSTNAME),
					r.getString(DataContract.UsersTable.COL_LASTNAME),
					r.getString(DataContract.UsersTable.COL_EMAIL),
					r.getString(DataContract.UsersTable.COL_PHONENUMBER),
					r.getString(DataContract.UsersTable.COL_PASSWORD),
					r.getInt(DataContract.UsersTable.COL_GENDER),
					r.getString(DataContract.UsersTable.COL_ADDRESS),
					r.getString(DataContract.UsersTable.COL_NOTES),
					r.getString(DataContract.UsersTable.COL_PROFILEPICTURE),
					r.getBoolean(DataContract.UsersTable.COL_ACTIVE), userType.MENTOR, 
					r.getString(DataContract.MentorsTable.COL_EXPERIENCE),
					r.getString(DataContract.MentorsTable.COL_ROLE),
					r.getInt(DataContract.MentorsTable.COL_COMPANY),
					r.getString(DataContract.MentorsTable.COL_VOLUNTEERING),
					r.getString(DataContract.MentorsTable.COL_WORKHISTORY));
			mentorList.add(u);
		}

		return mentorList;
	}

	@Override
	public boolean addWorkPlace(WorkPlace workplace) throws SQLException {

		PreparedStatement stm = c.prepareStatement(insertWorkPlace);
		stm.setString(1, workplace.getCompany());
		stm.setString(2, workplace.getArea());
		stm.setString(3, workplace.getCity());
		stm.setString(4, workplace.getAddress());
		stm.executeUpdate();
		return true;
	}

	@Override
	public ArrayList<Meeting> getMeetingByStatus(int userId, meetingStatus status, int count, int page)
			throws SQLException {
		ArrayList<Meeting> m = new ArrayList<Meeting>();
		PreparedStatement stm = null;

		userType type = getUser(userId).getType();

		if (type == userType.MENTEE) {
			stm = c.prepareStatement(getMeetings2);
		}
		if (type == userType.MENTOR) {
			stm = c.prepareStatement(getMeetings1);
		}
		if (stm != null) {

			stm.setInt(1, userId);
			stm.setInt(2, status.ordinal());
			stm.setInt(3, (page - 1) * (count));
			stm.setInt(4, count);
			ResultSet rs=stm.executeQuery();
			m=new ArrayList<Meeting>();
			while (rs.next())
			{				
				Meeting meet = new Meeting(rs.getInt(DataContract.MeetingTable.COL_ACTIVITYID),
						rs.getInt(DataContract.MeetingTable.COL_PAIRID),
						rs.getInt(DataContract.MeetingTable.COL_MENTORID),
						rs.getInt(DataContract.MeetingTable.COL_MENTEEID),
						rs.getString(DataContract.MeetingTable.COL_NOTE),
						meetingStatus.valueOf(rs.getInt(DataContract.MeetingTable.COL_STATUS)),
						rs.getString(DataContract.MeetingTable.COL_MENTEEREPORT),
						rs.getString(DataContract.MeetingTable.COL_MENTORREPORT),
						rs.getString(DataContract.MeetingTable.COL_MENTEEPRIVREPORT),
						rs.getString(DataContract.MeetingTable.COL_MENTORPRIVREPORT),
						meetingType.getByValue(rs.getInt(DataContract.MeetingTable.COL_MEETINGTYPE)),
						rs.getString(DataContract.MeetingTable.COL_SUBJECT),
						rs.getString(DataContract.MeetingTable.COL_LOCATION),
						rs.getLong(DataContract.MeetingTable.COL_DATE), 
						rs.getTime(DataContract.MeetingTable.COL_STARTINGTIME),
						rs.getTime(DataContract.MeetingTable.COL_ENDINGTIME),
						rs.getBoolean(DataContract.MeetingTable.COL_MENTORCOMPLETE),
						rs.getBoolean(DataContract.MeetingTable.COL_MENTEECOMPLETE));
				m.add(meet);
			}
		}

		return m;
	}

	@Override
	public boolean addAcademicInstitute(AcademicInstitute a) throws SQLException {
		PreparedStatement stm = c.prepareStatement(insertAcademicinstitute);
		stm.setString(1, a.getName());
		stm.setString(2, a.getArea());
		stm.setString(3, a.getCity());
		stm.executeUpdate();
		return true;
	}

	@Override
	public ArrayList<AcademicInstitute> getAllAcademiclnstitution() throws SQLException {
		ArrayList<AcademicInstitute> a = new ArrayList<AcademicInstitute>();
		AcademicInstitute academic = null;
		PreparedStatement stm = c.prepareStatement(selectAcademicInstitute);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			academic = new AcademicInstitute(rs.getInt(DataContract.AcademicInstituteTable.COL_ID),
					rs.getString(DataContract.AcademicInstituteTable.COL_NAME),
					rs.getString(DataContract.AcademicInstituteTable.COL_AREA),
					rs.getString(DataContract.AcademicInstituteTable.COL_CITY));
			a.add(academic);
		}
		return a;
	}



	@Override
	public ArrayList<WorkPlace> getAllWorkingPlace() throws SQLException {
		ArrayList<WorkPlace> workplace = new ArrayList<>();
		WorkPlace w = null;
		PreparedStatement stm = c.prepareStatement(selectWorkPlace);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			w = new WorkPlace(rs.getInt(DataContract.WorkplacesTable.COL_ID),
					rs.getString(DataContract.WorkplacesTable.COL_NAME),
					rs.getString(DataContract.WorkplacesTable.COL_AREA),
					rs.getString(DataContract.WorkplacesTable.COL_CITY),
					rs.getString(DataContract.WorkplacesTable.COL_ADDRESS));
			workplace.add(w);
		}
		return workplace;
	}


	@Override
	public ArrayList<User> getAllCorrespondingMentees(String address, String gender, String academicInstitution,
			boolean inPair, String academicDicipline1, String academicDicipline2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> getAllCorrespondingMentors(String address, String gender, String workPlace, boolean inPair) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ArrayList<Meeting> getMeetingByStatus(int userId, int status, int count, int page) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Pair> getAllCorrespondingPairs(String mentorName,
			String menteeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkPlace getWorkPlaceById(int id) throws SQLException {
		// TODO Auto-generated method stub
		WorkPlace work= null;
		PreparedStatement stm = c.prepareStatement(selectWorkPlaceId);
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			work = new WorkPlace(id, rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5));
		}
		
		return work;
	}

	@Override
	public AcademicInstitute getAcademicInstituteById(int id) throws SQLException {
		// TODO Auto-generated method stub
		AcademicInstitute a = null;
		PreparedStatement stm = c.prepareStatement(selectAcademicInstituteId);
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if(rs.next())
		{
			a= new AcademicInstitute(id, rs.getString(2), rs.getString(3), rs.getString(4));
		}
		return a;
	}

	@Override
	public void changeMeetingStatus(int meetingId, int userId, meetingStatus status) throws SQLException {
		PreparedStatement stm1 = c.prepareStatement(SQLStatements.updateStatus);
		stm1.setInt(1, status.ordinal());
		stm1.setInt(2, meetingId);
		stm1.executeUpdate();
		
		if(status.ordinal() == 2) {	//in case of confirm meeting
			PreparedStatement stm2 = c.prepareStatement(SQLStatements.completeMentor);
			stm2.setInt(1, meetingId);
			stm2.setInt(2, userId);
			stm2.executeUpdate();
			PreparedStatement stm3 = c.prepareStatement(SQLStatements.completeMentee);
			stm3.setInt(1, meetingId);
			stm3.setInt(2, userId);
			stm3.executeUpdate();
			
			PreparedStatement stm4 = c.prepareStatement(SQLStatements.checkIfComplete);
			stm4.setInt(1, meetingId);
			ResultSet rs = stm4.executeQuery();
			if (rs.next()) {
				if(rs.getBoolean(DataContract.MeetingTable.COL_MENTORCOMPLETE) == true &&
						rs.getBoolean(DataContract.MeetingTable.COL_MENTEECOMPLETE) == true);
				//both Mentor and Mentee confirmed meeting, change meeting status to CONFIRM
				PreparedStatement stm5 = c.prepareStatement(SQLStatements.updateStatus);
				stm5.setInt(1, status.ordinal());
				stm5.setInt(2, meetingId);
				stm5.executeUpdate();
			}
			
		}
	}








}
