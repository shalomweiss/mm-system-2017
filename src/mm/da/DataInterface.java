package mm.da;



import mm.model.Meeting;
import mm.model.Mentee;
import mm.model.Mentor;
import mm.model.Pair;
import mm.model.Session;
import mm.model.User;
import mm.model.User.userType;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DataInterface{

	public User login(String email) throws SQLException;

	public boolean deactivateUser(int id) throws SQLException;

	public ArrayList<User> getUsers(userType type) throws SQLException;

	public User getUser(int id) throws SQLException;

	public boolean addUser(User u) throws SQLException;

	public boolean editUser(User u) throws SQLException;

	public ArrayList<Pair> getAllPairs() throws SQLException;

	public boolean addPair(int mentorId, int menteeId) throws SQLException;

	public boolean disconnectPair(int pairId) throws SQLException;

	public Pair getPair(int pairId) throws SQLException;

	public ArrayList<Session> getUserSessions(int id) throws SQLException;

	public ArrayList<Meeting> getUserMeetings(int id) throws SQLException;

	public Mentor getMentorOfMentee(int menteeId) throws SQLException;

	public ArrayList<Mentee> getMenteesOfMentor(int mentorId) throws SQLException;

	public Meeting getMeetingById(int meetingId) throws SQLException;
	
	public ArrayList<Meeting> getMeetingsByPairId(int pairId) throws SQLException;

	public boolean startUserSession(Session session) throws SQLException;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
		
//	public ArrayList<Mentee> getMenteesWithOutMentor();
//	public boolean addWorkPlace(WorkPlace workplace);

	public boolean addMeeting(Meeting meeting) throws SQLException;
	
	
	//TODO . . . MEETING STATUS
	//TODO add meeting approved by mentee, approved by mentor
	//Approved 
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
	
=======



>>>>>>> Stashed changes
=======



>>>>>>> Stashed changes
}
