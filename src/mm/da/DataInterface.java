package mm.da;

import mm.model.Meeting;
import mm.model.Meeting.meetingStatus;
import mm.model.AcademicInstitute;
import mm.model.Mentee;
import mm.model.Mentor;
import mm.model.Pair;
import mm.model.Session;
import mm.model.User;
import mm.model.User.userType;
import mm.model.WorkPlace;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DataInterface {

	/*
	 * Users db Requests
	 */
	public User login(String email) throws SQLException;

	public boolean deactivateUser(int id) throws SQLException;

	public ArrayList<User> getUsers(userType type) throws SQLException;

	public User getUser(int id) throws SQLException;

	public int addUser(User u) throws SQLException;

	public boolean editUser(User u) throws SQLException;

	/*
	 * Pairs db Requests
	 */

	public ArrayList<Pair> getAllPairs() throws SQLException;

	public boolean addPair(int mentorId, int menteeId) throws SQLException;
	
	public Pair addPair1(int mentorId, int menteeId) throws SQLException;


	public boolean disconnectPair(int pairId) throws SQLException;

	public Pair getPair(int pairId) throws SQLException;
	
	public int getPairId(int menteeid,int MentorId) throws SQLException;

	/*
	 * Sessions db Requests
	 */

	public ArrayList<Session> getUserSessions(int id) throws SQLException;

	public boolean startUserSession(Session session) throws SQLException;

	public ArrayList<AcademicInstitute> getAllAcademiclnstitution() throws SQLException;

	/*
	 * Activities (Meetings) db Requests
	 */

	public boolean addMeeting(Meeting meeting) throws SQLException;

	public ArrayList<Meeting> getUserMeetings(int id) throws SQLException;

	public Meeting getMeetingById(int meetingId) throws SQLException;

	public boolean changeMeetingStatus(int meetingId, int userId, meetingStatus status) throws SQLException;

	public ArrayList<Meeting> getMeetingsByPairId(int pairId) throws SQLException;

	public ArrayList<Meeting> getMeetingByStatus(int userId, meetingStatus status, int count, int page)
			throws SQLException;
	


	public Mentor getMentorOfMentee(int menteeId) throws SQLException;

	public ArrayList<Mentee> getMenteesOfMentor(int mentorId) throws SQLException;

	public boolean addWorkPlace(WorkPlace workplace) throws SQLException;
	
	public boolean addAcademicInstitute(AcademicInstitute a) throws SQLException;

	public ArrayList<Mentee> getAllMenteesWithoutMentor() throws SQLException;

	public ArrayList<Mentor> getAllMentorsWithoutMentees() throws SQLException;
	
	public ArrayList<WorkPlace> getAllWorkingPlace() throws SQLException;
	
	public WorkPlace getWorkPlaceById(int id) throws SQLException;
	
	public AcademicInstitute getAcademicInstituteById(int id) throws SQLException;
	

	public ArrayList<User> getAllCorrespondingMentees(String address,String gender,String academicInstitution, boolean inPair,
					 String academicDicipline1,String academicDicipline2);
	
	public ArrayList<User> getAllCorrespondingMentors(String address,String gender,String workPlace, boolean inPair);

	public ArrayList<Pair> getAllCorrespondingPairs(String mentorName,String menteeName);



}
