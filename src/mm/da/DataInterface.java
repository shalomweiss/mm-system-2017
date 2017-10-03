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

public interface DataInterface{

	/*
	 *	Users db Requests
	 */
	public User login(String email) throws SQLException;

	public boolean deactivateUser(int id) throws SQLException;

	public ArrayList<User> getUsers(userType type) throws SQLException;

	public User getUser(int id) throws SQLException;

	public boolean addUser(User u) throws SQLException;

	public boolean editUser(User u) throws SQLException;
	
	/*
	 * Pairs db Requests
	 */

	public ArrayList<Pair> getAllPairs() throws SQLException;

	public boolean addPair(int mentorId, int menteeId) throws SQLException;

	public boolean disconnectPair(int pairId) throws SQLException;

	public Pair getPair(int pairId) throws SQLException;
	
	/*
	 * Sessions db Requests
	 */

	public ArrayList<Session> getUserSessions(int id) throws SQLException;
	
	public boolean startUserSession(Session session) throws SQLException;
	//public ArrayList<AcadimicIn> getAllAcademiclnstitution();


		
//	public ArrayList<Mentee> getMenteesWithOutMentor();
	public boolean addWorkPlace(WorkPlace workplace);
	
	/*
	 * Activities (Meetings) db Requests
	 */
	
	public boolean addMeeting(Meeting meeting) throws SQLException;

	public ArrayList<Meeting> getUserMeetings(int id) throws SQLException;
	
	public Meeting getMeetingById(int meetingId) throws SQLException;
	
	/**
	 * before meeting , if the mentee approves
	 * @param approvedMeeting
	 * @return
	 * @throws SQLException
	 */
	public boolean approveMeeting(int meetingId,boolean status) throws SQLException;
	
	
	/**
	 * if the meeting already passed - could be confirmed - not confirmed - did not happen
	 * @param confirmedMeeting
	 * @return
	 * @throws SQLException
	 */
	public boolean confirmMeeting(int meetingId,boolean status) throws SQLException;
	
	public ArrayList<Meeting> getMeetingsByPairId(int pairId) throws SQLException;

	public ArrayList<Meeting> getMeetingByStatus(int userId,meetingStatus status,int count,int page)throws SQLException;
	
	/*
	 * Util
	 */
	
	public Mentor getMentorOfMentee(int menteeId) throws SQLException;

	public ArrayList<Mentee> getMenteesOfMentor(int mentorId) throws SQLException;
	
	public boolean addWorkPlace(WorkPlace workplace);
	
	public boolean addAcademicInstitute(AcademicInstitute a);

	public ArrayList<Mentee> getAllMenteesWithoutMentor() throws SQLException;
	
	public ArrayList<Mentor> getAllMentorsWithoutMentees() throws SQLException;
	
	
	

}
