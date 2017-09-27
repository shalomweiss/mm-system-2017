package mm.da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Statement;
import java.util.ArrayList;


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
	final String selectByID = "Select * From users where id=?";
	final String updateUserBase = "UPDATE users SET firstName=?, lastName=?, email=?, password=?, address=? WHERE id=?";
	final String updateUserMentor = "UPDATE mentors SET experience=?, role=?, company=?, volunteering=?, workHistory=? WHERE id=?";
	final String updateUserMentee = "UPDATE mentees SET remainingSemesters=?, graduationStatus=?, academicInstitute=?, average=?, academicDicipline1=?, academicDecipline2=?, isGuarantee=?, resume=?, gradeSheet=? WHERE id=?";
	final String deactivateUser = "UPDATE users SET active=0 WHERE id=?";
	
	public DataAccess() {
		Logger logger = Logger.getLogger(DataAccess.class.getName());
		logger.log(Level.INFO, "DataAccess c'tor: attempting connection...");
		c = util.DBUtil.getConnection();
		if(c==null){
			logger.log(Level.SEVERE,"Connection Failed");
		}else{
			logger.log(Level.INFO,"Connection Established");
		}

	}

	public User login(String email) throws SQLException {
		Logger logger = Logger.getLogger(DataAccess.class.getName());
		if(c==null){
			logger.log(Level.SEVERE,"Connection Failed");
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
				logger.log(Level.WARNING,"User type Admin, no admins exist in the system at this time");
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
						rs3.getString(6), rs3.getString(7), rs3.getBoolean(8),
						rs3.getString(9),rs3.getString(10));
				break;

			default:
				logger.log(Level.WARNING,"User type unknown");
				break;
			}
		}
		
		rs.close();
		stm.close();
		return u;
	}
	

	public boolean updateUserInfo(User user) throws SQLException {
		PreparedStatement stm = c.prepareStatement(selectByID);
		stm.setInt(1, user.getId());
		ResultSet rs = stm.executeQuery();
		if (!rs.next()) // user does not exist
			return false;
		
		PreparedStatement stm2 = c.prepareStatement(updateUserBase);
		stm2.setString(1, user.getFirstName());
		stm2.setString(2, user.getLastName());
		stm2.setString(3, user.getEmail());
		stm2.setString(4, user.getPassword());
		stm2.setString(5, user.getAddress());
		stm2.setInt(6, user.getId());
		stm2.executeUpdate();
		
		if(user.getType()==userType.TSOFEN || user.getType()==userType.ADMIN)
			return true;
		
		if(user.getType()==userType.MENTOR) {
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
		
		if(user.getType()==userType.MENTEE) {
			PreparedStatement stm4 = c.prepareStatement(updateUserMentee);
			stm4.setFloat(1, ((Mentee) user).getRemainingSemesters());
			stm4.setString(2, ((Mentee) user).getGraduationStatus());
			stm4.setString(3, ((Mentee) user).getAcademiclnstitution());
			stm4.setString(4, ((Mentee) user).getAcademicDicipline());
			stm4.setString(5, ((Mentee) user).getAcademicDicipline2());
			stm4.setInt(6, ((Mentee) user).isGuarantee()?1:0);
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

	public ArrayList<User> getUsers(int type) throws SQLException
	{
		User u = null;
		ArrayList<User> users =null;
		switch(type) 
		{
		case 0:
			break;
		case 1:
			
			Statement stm= c.createStatement();
			 stm.executeQuery("select * from user where type ="+type);
			ResultSet r = stm.getResultSet();
			while (r.next())
			{
				u = new TsofenT(r.getInt(1), r.getString(3), r.getString(4),
					r.getString(5), r.getString(6), r.getString(7),
					r.getString(8), r.getString(9), r.getString(10),
					r.getBoolean(11), userType.TSOFEN);
			users.add(u);
			}
			
			break;
		case 2:
		
			Statement stm2= c.createStatement();
			 stm2.executeQuery("select *from user RIGHT JOIN mentor ON user.id = mentor.id");
			ResultSet r2 = stm2.getResultSet();
			while (r2.next())
			{
				u = new Mentor(r2.getInt(1), r2.getString(3), r2.getString(4),
						r2.getString(5), r2.getString(6), r2.getString(7),
						r2.getString(8), r2.getString(9), r2.getString(10),
						r2.getBoolean(11), userType.MENTOR, r2.getString(2),
						r2.getString(3), r2.getInt(4), r2.getString(5),
						r2.getString(6));
				users.add(u);
			}
			
			break;
		case 3:
			
			Statement stm3= c.createStatement();
			 stm3.executeQuery("select *from user RIGHT JOIN mentee ON user.id = mentee.id");
			ResultSet r3 = stm3.getResultSet();
			while (r3.next())
			{
				u = new Mentee(r3.getInt(1), r3.getString(3), r3.getString(4),
						r3.getString(5), r3.getString(6), r3.getString(7),
						r3.getString(8), r3.getString(9), r3.getString(10),
						r3.getBoolean(11), userType.MENTEE, r3.getFloat(2),
						r3.getString(3), r3.getString(4), r3.getFloat(5),
						r3.getString(6), r3.getString(7), r3.getBoolean(8),r3.getString(9),r3.getString(10));
				users.add(u);
			}
			break;
			
		default:
			break;
		}
		return users;
	}


}
