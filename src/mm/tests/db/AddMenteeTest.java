package mm.tests.db;

import java.sql.SQLException;
import java.util.ArrayList;

import mm.da.DataAccess;
import mm.model.Mentee;
import mm.model.User;
import mm.model.User.userType;

public class AddMenteeTest {

	static DataAccess da;

	public AddMenteeTest() {
		super();
	}

	public static void main(String[] args) throws SQLException {
		da = new DataAccess();
		Mentee m1 = new Mentee(0, "badie", "bido", "bido@gmail.com", "125", "blabla", 1, "Haifa", "pic", "okay", true,
				userType.MENTEE, (float) 2, "Graduated", 1, (float) 85.5, "Computer Science", "Engineering", true,
				"file", "file");

		Mentee m2 = new Mentee(0, "rachel", "green", "rachelgreen@gmail.com", "125", "blabla", 1, "Haifa", "pic",
				"okay", true, userType.MENTEE, (float) 1, "not yet", 1, (float) 90, "Computer Science", "nope", false,
				"file", "file");

		Mentee m3 = new Mentee(0, "areen", "areen", "areen@gmail.com", "125", "blabla", 1, "Haifa", "pic", "okay", true,
				userType.MENTEE, (float) 3, "not yet", 2, (float) 98.8, "whatever", "whatever", true, "file", "file");

		boolean status = false;
		System.out.println(status);
		try {

			status = da.addUser(m1);
			System.out.println("The add Status1" + status);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			status = da.addUser(m2);
			System.out.println("The add Status2" + status);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			status = da.addUser(m3);
			System.out.println("The add Status2" + status);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<User> allMentees = da.getUsers(userType.MENTEE);

		for (User user : allMentees) {
			System.out.println(user.toString());
		}

	}

}
