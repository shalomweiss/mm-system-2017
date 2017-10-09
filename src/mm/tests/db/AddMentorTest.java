//package mm.tests.db;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import mm.da.DataAccess;
//import mm.model.Mentor;
//import mm.model.User;
//import mm.model.User.userType;
//
//public class AddMentorTest {
//
//	static DataAccess da;
//
//	public AddMentorTest() {
//		super();
//	}
//
//	public static void main(String[] args) throws SQLException {
//		da=new DataAccess();
//		Mentor m1 = new Mentor(0, "yara", "rohana", "yara.rohana@gmail.com",
//				"125", "blabla", 1, "Haifa", "okay", "pic", true,
//				userType.MENTOR, "none", "Student", 2, "yes", "none");
//
//		Mentor m2 = new Mentor(0, "ghada", "awady", "ghada.rohana@gmail.com",
//				"125", "blabla", 1, "Haifa", "okay", "pic", true,
//				userType.MENTOR, "none", "Student", 2, "yes", "none");
//		
//		Mentor m3 = new Mentor(0, "jimmy", "keth", "jimmy.keth@gmail.com",
//				"125", "blabla", 1, "Haifa", "okay", "pic", true,
//				userType.MENTOR, "none", "Student", 2, "yes", "none");
//		
//		boolean status =false;
//		System.out.println(status);
//		try {
//
//			status = da.addUser(m1);
//			System.out.println("The add Status1"+status);
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			status=da.addUser(m2);
//			System.out.println("The add Status2"+status);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			status=da.addUser(m3);
//			System.out.println("The add Status2"+status);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		ArrayList<User> allMentors=da.getUsers(userType.MENTOR);
//		
//		
//		
//		for (User user : allMentors) {
//			System.out.println(user.toString());
//		}
//		
//		
//	}
//
//}
