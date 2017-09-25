package mm.androidservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mm.constants.Constants;
import mm.da.DataAccess;
import mm.model.JsonUser;
import mm.model.User;
import util.ServerUtils;

/**
 * Servlet implementation class LogInTest
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private class UserSession {
		
		private String email;
		private String password;
		private String deviceId;
		public UserSession(String email, String password, String deviceId) {
			super();
			this.email = email;
			this.password = password;
			this.deviceId = deviceId;
		}
		@Override
		public String toString() {
			return "UserSession [email=" + email + ", password=" + password + ", deviceId=" + deviceId + "]";
		}
		

	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		 UserSession myUser = ServerUtils.getJsonFromRequest(request, UserSession.class);

			DataAccess da = new DataAccess();
			User user = null;
			try {
				user = da.login(myUser.email);
				 //user = new User(1,"testMan","ok","gmail.com","12345","abc","male","Antractica","good test",true,User.userType.MENTEE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			JsonUser jsonUser=null;

			if(user==null) {
				jsonUser = new JsonUser(user, Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, null);
			} 
			else if(user.getPassword().equals(myUser.password)){
				 
				String token=ServerUtils.generateToken();
				//TODO
				//da.insertSession(myUser.email,token,new Instant.now(),ENDDATE,myUser.deviceId);
				//insert session into database
				jsonUser = new JsonUser(user, Constants.STATUS_SUCCESS, Constants.SUCCESS, token);
			}			
			else {
				jsonUser = new JsonUser(user, Constants.STATUS_WRONGPARA, Constants.WRONGPASSWORD, null);
			}
				
			
			ServerUtils.respondJsonUser(response,jsonUser);
			
			
			

			}

		
		    
}


