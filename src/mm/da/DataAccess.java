package mm.da;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mm.model.Mentee;
import mm.model.Mentor;
import mm.model.TsofenT;
import mm.model.User;
import mm.model.User.userType;

public class DataAccess {

	private static boolean isLoadedDriver;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			isLoadedDriver = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isLoadedDriver = false;

		}
	}

	final String url = "jdbc:mysql://node4644-env-8285750.elastyco.com:3600/db";
	private Connection c;

	final String selectLogin = "Select * From users where email=?";
	final String selectLogin1 = "Select * From mentor where id=?";
	final String selectLogin2 = "Select * From mentee where id=?";

	public DataAccess() {
		try {
			c = DriverManager.getConnection(url, "root", "ESEahn57327"); // TODO: when in
																// production
																// make sure to
																// have valid
																// credentials
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public User login(String email) throws SQLException {
		PreparedStatement stm = c.prepareStatement(selectLogin);
		stm.setString(1, email);

		ResultSet rs = stm.executeQuery();
		User u = null;
		if (rs.next()) {
			int type = rs.getInt(2);
			switch (type) {
			case 0:

				//LOL
				break;

			case 1:
				u = new TsofenT(rs.getInt(1), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getBoolean(11), userType.TSOFEN);
				break;
			case 2:
				PreparedStatement stm2 = c.prepareStatement(selectLogin1);
				stm2.setInt(1, rs.getInt(1));

				ResultSet rs2 = stm.executeQuery();
				u = new Mentor(rs.getInt(1), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getBoolean(11), userType.MENTOR, rs2.getString(2),
						rs2.getString(3), rs2.getInt(4), rs2.getString(5),
						rs2.getString(6));
				break;
			case 3:
				PreparedStatement stm3 = c.prepareStatement(selectLogin2);
				stm3.setInt(1, rs.getInt(1));

				ResultSet rs3 = stm.executeQuery();
				u = new Mentee(rs.getInt(1), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getBoolean(11), userType.MENTEE, rs3.getFloat(2),
						rs3.getString(3), rs3.getString(4), rs3.getFloat(5),
						rs3.getString(6), rs3.getString(7), rs3.getBoolean(8));
				break;

			default:
				break;
			}
		}

		return u;
	}

}
