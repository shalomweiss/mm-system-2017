package mm.da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import mm.model.Mentee;
import mm.model.Mentor;
import mm.model.TsofenT;
import mm.model.User;
import mm.model.User.userType;

public class DataAccess {

	private Connection c;

	final String selectLogin = "Select * From users where email=?";
	final String selectLogin1 = "Select * From mentor where id=?";
	final String selectLogin2 = "Select * From mentee where id=?";

	public DataAccess() {
		Logger logger = Logger.getLogger(DataAccess.class.getName());
		logger.log(Level.INFO, "DataAccess c'tor: establishing connection...");
		c = util.DBUtil.getConnection();
		if(c==null){
			logger.log(Level.SEVERE,"Connetion failed");
		}
	}

	public User login(String email) throws SQLException {
		Logger logger = Logger.getLogger(DataAccess.class.getName()+".login()");
		if(c==null){
			logger.log(Level.WARNING,"Connection is null, returning null");
			return null;
		}
		PreparedStatement stm = c.prepareStatement(selectLogin);
		stm.setString(1, email);

		ResultSet rs = stm.executeQuery();
		User u = null;
		if (rs.next()) {
			int type = rs.getInt(2);
			switch (type) {
			case 0: //Admin
				logger.log(Level.WARNING,"User type Admin, no admins exists in the system at this time");
				break;
			case 1: //Tsofen member
				logger.log(Level.INFO,"User type Tsofen");
				u = new TsofenT(rs.getInt(1), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getBoolean(11), userType.TSOFEN);
				break;
			case 2://Mentor
				logger.log(Level.INFO,"User type Mentor");
				PreparedStatement stm2 = c.prepareStatement(selectLogin1);
				stm2.setInt(1, rs.getInt(1));

				ResultSet rs2 = stm.executeQuery();
				u = new Mentor(rs.getInt(1), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getBoolean(11), userType.MENTOR, rs2.getString(2),
						rs2.getString(3), rs2.getInt(4), rs2.getString(5),
						rs2.getString(6));
				rs2.close();
				stm2.close();
				break;
			case 3://Mentee
				logger.log(Level.INFO,"User type Mentee");
				PreparedStatement stm3 = c.prepareStatement(selectLogin2);
				stm3.setInt(1, rs.getInt(1));

				ResultSet rs3 = stm.executeQuery();
				u = new Mentee(rs.getInt(1), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getBoolean(11), userType.MENTEE, rs3.getFloat(2),
						rs3.getString(3), rs3.getString(4), rs3.getFloat(5),
						rs3.getString(6), rs3.getString(7), rs3.getBoolean(8));
				rs3.close();
				stm3.close();
				break;

			default:
				logger.log(Level.WARNING,"Unknown user type");
				break;
			}
		}
		
		rs.close();
		stm.close();
		return u;
	}

}
