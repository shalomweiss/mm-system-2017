package da;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mm.model.User;
import util.DBUtil;

public class UserDA implements UserdaI {

	private Connection conn;

	public UserDA() {
		conn = DBUtil.getConnection();
	}

	// @Override
	// public void addUser(Student student) {
	// try {
	// String query =
	// "insert into public.students (stud_id, f_name, l_name) values (?,?,?)";
	// PreparedStatement preparedStatement = conn.prepareStatement( query );
	// preparedStatement.setString( 1, student.getStudentId() );
	// preparedStatement.setString( 2, student.getFirstName() );
	// preparedStatement.setString( 3, student.getLastName() );
	//
	// preparedStatement.executeUpdate();
	// preparedStatement.close();
	// } catch (SQLException e) {
	// System.out.println(e.getMessage());
	// }
	//
	// }

	@Override
	public void deleteUser(String studentId) {
		// try {
		// String query = "delete from public.students where stud_id=?";
		// PreparedStatement preparedStatement = conn.prepareStatement(query);
		// preparedStatement.setString(1, studentId);
		// preparedStatement.executeUpdate();
		// preparedStatement.close();
		// } catch (SQLException e) {
		// System.out.println(e.getMessage());
		// }

	}

	// @Override
	// public void updateStudent(Student student) {
	// try {
	// String query =
	// "update public.students set  f_name=?, l_name=? where stud_id=?";
	// PreparedStatement preparedStatement = conn.prepareStatement( query );
	//
	// preparedStatement.setString( 1, student.getFirstName() );
	// preparedStatement.setString( 2, student.getLastName() );
	// preparedStatement.setString( 3, student.getStudentId() );
	// preparedStatement.executeUpdate();
	// preparedStatement.close();
	// } catch (SQLException e) {
	// System.out.println(e.getMessage());
	// }
	//
	// }

	// @Override
	// public List<Student> getAllStudents() {
	// List<Student> students = new ArrayList<Student>();
	// try {
	// Statement statement = conn.createStatement();
	// ResultSet resultSet = statement.executeQuery(
	// "select * from public.students" );
	// while( resultSet.next() ) {
	// Student student = new Student();
	// student.setStudentId( resultSet.getString( "stud_id" ) );
	// student.setFirstName( resultSet.getString( "f_name" ) );
	// student.setLastName( resultSet.getString( "l_name" ) );
	//
	// students.add(student);
	// }
	// resultSet.close();
	// statement.close();
	// } catch (SQLException e) {
	// System.out.println(e.getMessage());
	// }
	// return students;
	// }

	// @Override
	// public Student getStudentById(String studentId) {
	// Student student = new Student();
	// try {
	// String query = "select * from public.students where stud_id=?";
	// PreparedStatement preparedStatement = conn.prepareStatement( query );
	// preparedStatement.setString(1, studentId);
	// ResultSet resultSet = preparedStatement.executeQuery();
	// while( resultSet.next() ) {
	// student.setStudentId( resultSet.getString( "stud_id" ) );
	// student.setFirstName( resultSet.getString( "f_name" ) );
	// student.setLastName( resultSet.getString( "l_name" ) );
	// }
	// resultSet.close();
	// preparedStatement.close();
	// } catch (SQLException e) {
	// System.out.println(e.getMessage());
	// }
	// return student;
	// }

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select * from db.users");
			while (resultSet.next()) {
				User user = new User(resultSet.getInt(1),
						resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getString(6),
						resultSet.getString(7), resultSet.getString(8),
						resultSet.getString(9), resultSet.getString(10), false,
						null);

				users.add(user);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return users;
	}

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public User login(String email) {
		User u = new User(0, "Demo", email, email, email, email, email, email,
				email, false, null);
		return u;
	}
}
