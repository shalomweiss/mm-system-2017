package mm.da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;

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

public class DataAccess implements DataInterface {

	private Connection c;

	final String selectLogin = "Select * From users where email=?";
	final String selectLogin1 = "Select * From mentor where id=?";
	final String selectLogin2 = "Select * From mentee where id=?";
	final String selectByID = "Select * From users where id=?";
	final String getMenteeofPair = "Select * From pairs where menteeId=?, activeStatus=?";
	final String getMentorofPair = "Select * From pairs where mentorId=?, activeStatus=?";
	final String updateUserBase = "UPDATE users SET firstName=?, lastName=?, email=?, phoneNumber=?, password=?, gender=?, address=?, notes=?, profilePicture=?, active=? WHERE id=?";
	final String updateUserMentor = "UPDATE mentors SET experience=?, role=?, company=?, volunteering=?, workHistory=? WHERE id=?";
	final String updateUserMentee = "UPDATE mentees SET remainingSemesters=?, graduationStatus=?, academicInstitute=?, average=?, academicDicipline1=?, academicDecipline2=?, isGuarantee=?, resume=?, gradeSheet=? WHERE id=?";
	final String deactivateUser = "UPDATE users SET active=0 WHERE id=?";
	final String addBaseUser = "INSERT INTO users (type, firstName, lastName, email, phoneNumber, password, gender, address, notes, profilePicture, active) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	final String addMenteeUser = "INSERT INTO mentees (id, remainingSemesters, graduationStatus, academicInstitute, average, academicDicipline1, academicDecipline2, isGuarantee, resume, gradeSheet) VALUES (?,?,?,?,?,?,?,?,?,?)";
	final String addMentorUser = "INSERT INTO mentors (id, experience, role, company, volunteering, workHistory) VALUES (?,?,?,?,?,?)";
	final String insertPair = "INSERT INTO pairs (mentorId, menteeId, activeStatus, startDate) VALUES (?,?,?,?)";
	final String selectPairId = "Select * From pair Where id=?";
	final String selectMeeting = "Select * From activity where mentoId=? ";
	final String selectMeeting2 = "Select * From activity where menteeId=? ";
	final String sessionId = "Select * From session where userId=?";
	final String addUserSession = "INSERT INTO session (userId, token, creationDate, expirationDate, deviceId) VALUES (?,?,?,?,?)";
	final String selectMeetingById = ""; //TODO: write statement
    final String selectMeetingByPair="Select * From activities where pairId=?" ; 
    final String addMeeting = "INSERT INTO activities (pairId,mentorId,menteeId,note,status,menteeReport,mentorReport,menteePrivateReport,mentorPrivateReport,meetingType,subject,location,date,startingTime,endingTime,mentorComplete,menteeComplete)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    final String getAllMenteesWithoutMentor="select m.* user RIGHT JOIN mentee as m ON user.id = m.id as m where m.id  in (select menteeID from pairs	where menteeId = m.id  and activeStatus = 0	) or	NOT EXISTS(select menteeID	from pairs	where menteeId = m.id  and activeStatus != 0)";
    final String getAllMentorsWithoutMentees="select m.* user RIGHT JOIN mentors "
			+ "as m ON user.id = m.id as m where m.id  in (select mentorId from pairs	"
			+ "where mentorId = m.id  and activeStatus = 0	) or	"
			+ "NOT EXISTS(select mentorId	from pairs	where mentorId = m.id  and activeStatus != 0)";
    
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
		PreparedStatement stm = c.prepareStatement(selectLogin);
		stm.setString(1, email);

		ResultSet rs = stm.executeQuery();
		User u = null;
		if (rs.next()) {
			int type = rs.getInt(2);
			switch (type) {

			case 0: // Admin
				logger.log(Level.WARNING,
						"User type Admin, no admins exist in the system at this time");
				break;
			case 1: // Tsofen member
				logger.log(Level.INFO, "User type Tsofen");
				u = new TsofenT(rs.getInt(1), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getBoolean(12), userType.TSOFEN);
				break;
			case 2:// Mentor
				logger.log(Level.INFO, "User type Mentor");
				PreparedStatement stm2 = c.prepareStatement(selectLogin1);
				stm2.setInt(1, rs.getInt(1));

				ResultSet rs2 = stm.executeQuery();
				u = new Mentor(rs.getInt(1), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getBoolean(12), userType.MENTOR,
						rs2.getString(2), rs2.getString(3), rs2.getInt(4),
						rs2.getString(5), rs2.getString(6));
				rs2.close();
				stm2.close();
				break;
			case 3:// Mentee
				logger.log(Level.INFO, "User type Mentee");
				PreparedStatement stm3 = c.prepareStatement(selectLogin2);
				stm3.setInt(1, rs.getInt(1));

				ResultSet rs3 = stm.executeQuery();
				u = new Mentee(rs.getInt(1), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getInt(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getBoolean(12), userType.MENTEE,
						rs3.getFloat(2), rs3.getString(3), rs3.getString(4),
						rs3.getFloat(5), rs3.getString(6), rs3.getString(7),
						rs3.getBoolean(8), rs3.getString(9), rs3.getString(10));
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
		PreparedStatement stm = c.prepareStatement(selectByID);
		stm.setInt(1, user.getId());
		ResultSet rs = stm.executeQuery();
		if (!rs.next()) // user does not exist
			return false;

		PreparedStatement stm2 = c.prepareStatement(updateUserBase);
		stm2.setInt(1, user.getType().getValue());
		stm2.setString(2, user.getFirstName());
		stm2.setString(3, user.getEmail());
		stm2.setString(4, user.getPhoneNumber());
		stm2.setString(5, user.getPassword());
		stm2.setInt(6, user.getGender());
		stm2.setString(7, user.getAddress());
		stm2.setString(8, user.getNote());
		stm2.setString(9, user.getProfilePicture());
		stm2.setInt(10, user.isActive() ? 1 : 0);
		stm2.setInt(11, user.getId());
		stm2.executeUpdate();

		if (user.getType() == userType.TSOFEN
				|| user.getType() == userType.ADMIN)
			return true;

		if (user.getType() == userType.MENTOR) {
			PreparedStatement stm3 = c.prepareStatement(updateUserMentor);
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
			PreparedStatement stm4 = c.prepareStatement(updateUserMentee);
			stm4.setFloat(1, ((Mentee) user).getRemainingSemesters());
			stm4.setString(2, ((Mentee) user).getGraduationStatus());
			stm4.setString(3, ((Mentee) user).getAcademiclnstitution());
			stm4.setString(4, ((Mentee) user).getAcademicDicipline());
			stm4.setString(5, ((Mentee) user).getAcademicDicipline2());
			stm4.setInt(6, ((Mentee) user).isGuarantee() ? 1 : 0);
			stm4.setString(7, ((Mentee) user).getResume());
			stm4.setString(8, ((Mentee) user).getGradeSheet());
			stm4.setInt(9, user.getId());
			stm4.executeUpdate();
			return true;
		}

		return false;
	}

	public boolean deactivateUser(int id) throws SQLException {
		PreparedStatement stm = c.prepareStatement(selectByID);
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			PreparedStatement stm2 = c.prepareStatement(deactivateUser);
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
		PreparedStatement stm = c.prepareStatement(selectLogin);
		stm.setString(1, u.getEmail());
		ResultSet rs = stm.executeQuery();
		if (rs.next()) // user exists
			return false;
		PreparedStatement stm2 = c.prepareStatement(addBaseUser);
		stm2.setInt(1, u.getType().getValue());
		stm2.setString(2, u.getFirstName());
		stm2.setString(3, u.getEmail());
		stm2.setString(4, u.getPhoneNumber());
		stm2.setString(5, u.getPassword());
		stm2.setInt(6, u.getGender());
		stm2.setString(7, u.getAddress());
		stm2.setString(8, u.getNote());
		stm2.setString(9, u.getProfilePicture());
		stm2.setInt(10, u.isActive() ? 1 : 0);
		stm2.executeUpdate();

		if (u.getType() == userType.TSOFEN || u.getType() == userType.ADMIN)
			return true;

		if (u.getType() == userType.MENTOR) {
			PreparedStatement stm3 = c.prepareStatement(addMentorUser);
			stm3.setString(1, ((Mentor) u).getExperience());
			stm3.setString(2, ((Mentor) u).getRole());
			stm3.setInt(3, ((Mentor) u).getCompany());
			stm3.setString(4, ((Mentor) u).getVolunteering());
			stm3.setString(5, ((Mentor) u).getWorkHistory());
			stm3.setInt(6, u.getId());
			stm3.executeUpdate();
			return true;
		}

		if (u.getType() == userType.MENTEE) {
			PreparedStatement stm4 = c.prepareStatement(addMenteeUser);
			stm4.setFloat(1, ((Mentee) u).getRemainingSemesters());
			stm4.setString(2, ((Mentee) u).getGraduationStatus());
			stm4.setString(3, ((Mentee) u).getAcademiclnstitution());
			stm4.setString(4, ((Mentee) u).getAcademicDicipline());
			stm4.setString(5, ((Mentee) u).getAcademicDicipline2());
			stm4.setInt(6, ((Mentee) u).isGuarantee() ? 1 : 0);
			stm4.setString(7, ((Mentee) u).getResume());
			stm4.setString(8, ((Mentee) u).getGradeSheet());
			stm4.setInt(9, u.getId());
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

			Statement stm = c.createStatement();
			stm.executeQuery("select * from user where type =" + type);
			ResultSet r = stm.getResultSet();
			while (r.next()) {
				u = new TsofenT(r.getInt(1), r.getString(3), r.getString(4),
						r.getString(5), r.getString(6), r.getString(7),
						r.getInt(8), r.getString(9), r.getString(10),
						r.getString(11), r.getBoolean(12), userType.TSOFEN);
				users.add(u);
			}

			break;
		case MENTOR:

			Statement stm2 = c.createStatement();
			stm2.executeQuery("select * from user RIGHT JOIN mentor ON user.id = mentor.id");
			ResultSet r2 = stm2.getResultSet();
			while (r2.next()) {
				u = new Mentor(r2.getInt(1), r2.getString(3), r2.getString(4),
						r2.getString(5), r2.getString(6), r2.getString(7),
						r2.getInt(8), r2.getString(9), r2.getString(10),
						r2.getString(11), r2.getBoolean(12), userType.MENTOR,
						r2.getString(2), r2.getString(3), r2.getInt(4),
						r2.getString(5), r2.getString(6));
				users.add(u);
			}

			break;
		case MENTEE:

			Statement stm3 = c.createStatement();
			stm3.executeQuery("select * from user RIGHT JOIN mentee ON user.id = mentee.id");
			ResultSet r3 = stm3.getResultSet();
			while (r3.next()) {
				u = new Mentee(r3.getInt(1), r3.getString(3), r3.getString(4),
						r3.getString(5), r3.getString(6), r3.getString(7),
						r3.getInt(8), r3.getString(9), r3.getString(10),
						r3.getString(11), r3.getBoolean(12), userType.MENTEE,
						r3.getFloat(2), r3.getString(3), r3.getString(4),
						r3.getFloat(5), r3.getString(6), r3.getString(7),
						r3.getBoolean(8), r3.getString(9), r3.getString(10));
				users.add(u);
			}
			break;

		default:
			break;
		}
		return users;
	}

	@Override
	public User getUser(int id) throws SQLException {
		User user = null;
		PreparedStatement stm = c.prepareStatement(selectByID);
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			int type = rs.getInt(2);
			switch (type) {

			case 0:
				break;
			case 1:
				user = new TsofenT(rs.getInt(1), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getInt(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getBoolean(12),
						userType.TSOFEN);
				break;
			case 2:
				PreparedStatement stm2 = c.prepareStatement(selectLogin1);
				stm2.setInt(1, rs.getInt(1));

				ResultSet rs2 = stm.executeQuery();
				user = new Mentor(rs.getInt(1), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getInt(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getBoolean(12),
						userType.MENTOR, rs2.getString(2), rs2.getString(3),
						rs2.getInt(4), rs2.getString(5), rs2.getString(6));
				break;
			case 3:
				PreparedStatement stm3 = c.prepareStatement(selectLogin2);
				stm3.setInt(1, rs.getInt(1));

				ResultSet rs3 = stm.executeQuery();
				user = new Mentee(rs.getInt(1), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getInt(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getBoolean(12),
						userType.MENTEE, rs3.getFloat(2), rs3.getString(3),
						rs3.getString(4), rs3.getFloat(5), rs3.getString(6),
						rs3.getString(7), rs3.getBoolean(8), rs3.getString(9),
						rs3.getString(10));
				break;
			default:
				break;
			}

		}
		return user;
	}

	@Override
	public ArrayList<Pair> getAllPairs() throws SQLException {
		Pair p = new Pair();
		ArrayList<Pair> pair = new ArrayList<Pair>();
		Statement stm = c.createStatement();
		stm.executeQuery("select * pairs");
		ResultSet r = stm.getResultSet();

		while (r.next()) {
			p = new Pair(r.getInt(1), r.getInt(2), r.getInt(3), r.getInt(4),
					r.getLong(5), r.getLong(6), r.getString(7), r.getString(8));
			pair.add(p);
		}
		return pair;
	}

	@Override
	public boolean addPair(int mentorId, int menteeId) throws SQLException {
		if (getUser(mentorId).getType() == userType.MENTOR) {
			int tmp = menteeId;
			menteeId = mentorId;
			mentorId = tmp;
		}
		PreparedStatement stm = c.prepareStatement(selectLogin1);
		stm.setInt(1, mentorId);
		ResultSet rs = stm.executeQuery();
		if (!rs.next()) // user does not exist
			return false;
		stm = c.prepareStatement(selectLogin2);
		stm.setInt(1, menteeId);
		ResultSet rs1 = stm.executeQuery();
		if (!rs1.next()) // user does not exist
			return false;
		stm = c.prepareStatement(insertPair);
		// checking witch user is the mentor and witch is the mentee
		stm.setInt(1, mentorId);
		stm.setInt(2, menteeId);
		stm.setInt(3, 1);
		stm.setLong(4, System.currentTimeMillis());
		stm.executeUpdate();
		return true;

	}

	@Override
	public boolean disconnectPair(int pairId) throws SQLException {
		PreparedStatement stm = c.prepareStatement(selectPairId);

		stm.setInt(1, pairId);
		ResultSet rs = stm.executeQuery();

		if (rs.next()) {
			int active = rs.getInt(4);

			if (active == 1)

			{
				active = 0;
			}
		}
		return true;
	}

	@Override
	public Pair getPair(int pairId) throws SQLException {
		PreparedStatement stm = c.prepareStatement(selectPairId);

		stm.setInt(1, pairId);

		ResultSet rs = stm.executeQuery();

		if (!rs.next()) // user does not exist

			return new Pair(rs.getInt(1), rs.getInt(2), rs.getInt(3),
					getUser(rs.getInt(2)), getUser(rs.getInt(3)), rs.getInt(4),
					rs.getLong(5), rs.getLong(6), rs.getString(7),
					rs.getString(8));

		return null;

	}

	@Override
	public ArrayList<Session> getUserSessions(int id) throws SQLException {
		ArrayList<Session> session = null;
		Session s = null;
		PreparedStatement stm = c.prepareStatement(sessionId);

		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			s = new Session(id, rs.getString(2), rs.getLong(3), rs.getLong(4),
					rs.getString(5));
			session.add(s);
		}
		return session;
	}

	@Override
	public ArrayList<Meeting> getUserMeetings(int id) throws SQLException {
		ArrayList<Meeting> meeting = null;
		Meeting meet = null;
		PreparedStatement stm = c.prepareStatement(selectMeeting);
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {

			meet = new Meeting(rs.getInt(1), rs.getInt(2), rs.getInt(3),
					rs.getInt(4), rs.getString(5),
					mm.model.Meeting.meetingStatus.APPROVED, rs.getString(7),
					rs.getString(8), rs.getString(9), rs.getString(10),
					mm.model.Meeting.meetingType.SMS, rs.getString(12),
					rs.getString(13), rs.getLong(14), rs.getTime(15),
					rs.getTime(16), rs.getBoolean(17), rs.getBoolean(18));
			switch (rs.getInt(6)/* meetingStatus */) {
			case 0: // PENDING
				meet.setStatus(meetingStatus.PENDING);
				break;
			case 1: // APPRVED
				meet.setStatus(meetingStatus.APPROVED);
				break;
			case 2: // COMPLETE
				meet.setStatus(meetingStatus.COMPLETE);
				break;
			default: // ERROR
				break;
			}

			switch (rs.getInt(11)/* meetingType */) {
			case 0: // PHONE
				meet.setMeetingType(meetingType.PHONE);
				break;
			case 1: // FACE_TO_FACE
				meet.setMeetingType(meetingType.FACE_TO_FACE);
				break;
			case 2: // SMS
				meet.setMeetingType(meetingType.SMS);
				break;
			default: // ERROR
				break;
			}
		} else {
			PreparedStatement stm1 = c.prepareStatement(selectMeeting2);
			stm1.setInt(1, id);
			ResultSet rs1 = stm.executeQuery();
			if (rs1.next()) {
				meet = new Meeting(rs1.getInt(1), rs1.getInt(2), rs1.getInt(3),
						rs1.getInt(4), rs1.getString(5),
						mm.model.Meeting.meetingStatus.APPROVED, rs1.getString(7),
						rs1.getString(8), rs1.getString(9), rs1.getString(10),
						mm.model.Meeting.meetingType.SMS, rs1.getString(12),
						rs1.getString(13), rs1.getLong(14), rs1.getTime(15),
						rs1.getTime(16), rs1.getBoolean(17), rs1.getBoolean(18));
				switch (rs1.getInt(6)/* meetingStatus */) {
				case 0: // PENDING
					meet.setStatus(meetingStatus.PENDING);
					break;
				case 1: // APPRVED
					meet.setStatus(meetingStatus.APPROVED);
					break;
				case 2: // COMPLETE
					meet.setStatus(meetingStatus.COMPLETE);
					break;
				default: // ERROR
					break;
				}

				switch (rs.getInt(11)/* meetingType */) {
				case 0: // PHONE
					meet.setMeetingType(meetingType.PHONE);
					break;
				case 1: // FACE_TO_FACE
					meet.setMeetingType(meetingType.FACE_TO_FACE);
					break;
				case 2: // SMS
					meet.setMeetingType(meetingType.SMS);
					break;
				default: // ERROR
					break;
				}			
			}
		}

		return meeting;
	}

	@Override
	public Mentor getMentorOfMentee(int menteeId) throws SQLException {
		PreparedStatement stm = c.prepareStatement(getMenteeofPair);
		stm.setInt(1, menteeId);
		stm.setInt(2, 1);
		ResultSet rs = stm.executeQuery();
		return (Mentor) getUser(rs.getInt(2));

	}

	@Override
	public ArrayList<Mentee> getMenteesOfMentor(int mentorId)
			throws SQLException {
		ArrayList<Mentee> mentees = null;
		PreparedStatement stm = c.prepareStatement(getMentorofPair);
		stm.setInt(1, mentorId);
		stm.setInt(2, 1);
		ResultSet rs = stm.executeQuery();
		while (!rs.next()) {
			mentees.add((Mentee) getUser(rs.getInt(3)));
		}
		return mentees;
	}

	@Override
	public Meeting getMeetingById(int meetingId) throws SQLException {
		Meeting m = null;
		PreparedStatement stm = c.prepareStatement(selectMeetingById);
		stm.setInt(1, meetingId);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			m = new Meeting(rs.getInt(1), rs.getInt(2), rs.getInt(3),
					rs.getInt(4), rs.getString(5),
					mm.model.Meeting.meetingStatus.APPROVED, rs.getString(7),
					rs.getString(8), rs.getString(9), rs.getString(10),
					mm.model.Meeting.meetingType.SMS, rs.getString(12),
					rs.getString(13), rs.getLong(14), rs.getTime(15),
					rs.getTime(16), rs.getBoolean(17), rs.getBoolean(18));

			switch (rs.getInt(6)/* meetingStatus */) {
			case 0: // PENDING
				m.setStatus(meetingStatus.PENDING);
				break;
			case 1: // APPRVED
				m.setStatus(meetingStatus.APPROVED);
				break;
			case 2: // COMPLETE
				m.setStatus(meetingStatus.COMPLETE);
				break;
			default: // ERROR
				break;
			}

			switch (rs.getInt(11)/* meetingType */) {
			case 0: // PHONE
				m.setMeetingType(meetingType.PHONE);
				break;
			case 1: // FACE_TO_FACE
				m.setMeetingType(meetingType.FACE_TO_FACE);
				break;
			case 2: // SMS
				m.setMeetingType(meetingType.SMS);
				break;
			default: // ERROR
				break;
			}

		}
		return m;
	}

	@Override
	public boolean startUserSession(Session session) throws SQLException {
		PreparedStatement stm = c.prepareStatement(addUserSession);
		stm.setInt(1, session.getUserId());
		stm.setString(2, session.getToken());
		stm.setLong(3, session.getCreationDate());
		stm.setLong(4, session.getExpirationDate());
		stm.setString(5, session.getDeviceId());
		stm.executeUpdate();

		return true;

	}

	@Override
	public boolean addMeeting(Meeting meeting) throws SQLException {
PreparedStatement stm = c.prepareStatement(addMeeting);
	
		
		stm.setInt(1, meeting.getPairId());
		stm.setInt(2,meeting.getMentorId());
		stm.setInt(3, meeting.getMenteeId());

		stm.setString(4, meeting.getNote());
		stm.setInt(5, Integer.valueOf(meeting.getStatus().ordinal()));
		stm.setString(6, meeting.getMenteeReport());
		stm.setString(7, meeting.getMentorReport());
		stm.setString(8, meeting.getMenteePrivateReport());
		stm.setString(9, meeting.getMentorPrivateReport());
		stm.setInt(10, Integer.valueOf(meeting.getMeetingType().ordinal()));
		stm.setString(11,meeting.getSubject());
		stm.setString(12,meeting.getLocation());
		stm.setLong(13,meeting.getDate());
		stm.setString(14,meeting.getStartingDate().toString());
		stm.setString(15,meeting.getEndingDate().toString());
		stm.setBoolean(16,meeting.getMentorComplete());
		stm.setBoolean(17,meeting.getMenteeComplete());
		
		stm.executeUpdate();

	
		return false;
		
	}

	@Override
	public boolean approveMeeting(int meetingId, boolean status)
			throws SQLException {

		return false;
	}

	@Override
	public boolean confirmMeeting(int meetingId, boolean status)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Meeting> getMeetingsByPairId(int pairId)
			throws SQLException {
		ArrayList<Meeting> m = null;
		Meeting meeting=null;
		PreparedStatement stm = c.prepareStatement(selectMeetingByPair);
		stm.setInt(1, pairId);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) 
		{
		  meeting=new Meeting(rs.getInt(1), rs.getInt(2), rs.getInt(3),
					rs.getInt(4), rs.getString(5),
					mm.model.Meeting.meetingStatus.APPROVED, rs.getString(7),
					rs.getString(8), rs.getString(9), rs.getString(10),
					mm.model.Meeting.meetingType.SMS, rs.getString(12),
					rs.getString(13), rs.getLong(14), rs.getTime(15),
					rs.getTime(16), rs.getBoolean(17), rs.getBoolean(18));
		  
		  switch (rs.getInt(6)/* meetingStatus */) {
			case 0: // PENDING
				meeting.setStatus(meetingStatus.PENDING);
				break;
			case 1: // APPRVED
				meeting.setStatus(meetingStatus.APPROVED);
				break;
			case 2: // COMPLETE
				meeting.setStatus(meetingStatus.COMPLETE);
				break;
			default: // ERROR
				break;
			}

			switch (rs.getInt(11)/* meetingType */) {
			case 0: // PHONE
				meeting.setMeetingType(meetingType.PHONE);
				break;
			case 1: // FACE_TO_FACE
				meeting.setMeetingType(meetingType.FACE_TO_FACE);
				break;
			case 2: // SMS
				meeting.setMeetingType(meetingType.SMS);
				break;
			default: // ERROR
				break;
		}	
	}
		return m;
	}
	@Override
	public ArrayList<Mentee> getAllMenteesWithoutMentor() throws SQLException {
		Mentee u=null;
		ArrayList<Mentee> menteesList = new ArrayList<Mentee>();
		Statement stm3 = c.createStatement();
		stm3.executeQuery(getAllMenteesWithoutMentor);
		ResultSet r3 = stm3.getResultSet();
		while (r3.next()) {
			u = new Mentee(r3.getInt(1), r3.getString(3), r3.getString(4),
					r3.getString(5), r3.getString(6), r3.getString(7),
					r3.getInt(8), r3.getString(9), r3.getString(10),
					r3.getString(11), r3.getBoolean(12), userType.MENTEE,
					r3.getFloat(2), r3.getString(3), r3.getString(4),
					r3.getFloat(5), r3.getString(6), r3.getString(7),
					r3.getBoolean(8), r3.getString(9), r3.getString(10));
			menteesList.add(u);
		}
		
		return menteesList;
		
	}

	@Override
	public ArrayList<Mentor> getAllMentorsWithoutMentees() throws SQLException {
		Mentor u=null;
		ArrayList<Mentor> mentorList = new ArrayList<Mentor>();
		Statement stm3 = c.createStatement();
		stm3.executeQuery(getAllMentorsWithoutMentees);
		ResultSet r2 = stm3.getResultSet();
		while (r2.next()) {
			u = new Mentor(r2.getInt(1), r2.getString(3), r2.getString(4),
					r2.getString(5), r2.getString(6), r2.getString(7),
					r2.getInt(8), r2.getString(9), r2.getString(10),
					r2.getString(11), r2.getBoolean(12), userType.MENTOR,
					r2.getString(2), r2.getString(3), r2.getInt(4),
					r2.getString(5), r2.getString(6));
			mentorList.add(u);
		}
		
		return mentorList;
		
	
}
}

