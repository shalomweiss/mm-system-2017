package mm.androidservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import controllers.SessionController;
import mm.constants.Constants;
import mm.da.DataAccess;
import mm.model.JsonUser;
import mm.model.User;

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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));

		    StringBuilder sb = new StringBuilder();
		    String s;
		    while ((s = br.readLine()) != null) {
		         sb.append(s).append("\n");
		    }

		    String jsonString = sb.toString();
		    Gson gson = new Gson();
		    UserSession myUser = gson.fromJson( jsonString, UserSession.class );
		    response.getWriter().append(jsonString);
			//System.out.println("heloo");
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

		//return jsonUser;
			if(user==null) {
				jsonUser = new JsonUser(user, Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, null);
			} 
			else if(user.getPassword().equals(myUser.password)){
				 
				String token=SessionController.generateToken();
				//TODO
				//da.insertSession(myUser.email,token,new Instant.now(),ENDDATE,myUser.deviceId);
				//insert session into database
				jsonUser = new JsonUser(user, Constants.STATUS_SUCCESS, Constants.SUCCESS, token);
			}			
				else {
					jsonUser = new JsonUser(user, Constants.STATUS_WRONGPARA, Constants.WRONGPASSWORD, null);
				}
				
			response.setContentType("application/json");
			// Get the printwriter object from response to write the required json object to the output stream      
			PrintWriter out = response.getWriter();
			// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
			out.print(jsonUser);
			out.flush();
			out.close();
			
			

			}

		
		    
}


