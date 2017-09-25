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
import mm.constants.Constants;
import mm.da.DataAccess;
import mm.model.JsonUser;
import mm.model.User;

/**
 * Servlet implementation class LogInTest
 */
@WebServlet("/getProfile")
public class GetProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private class UserSession {
		
		private String id;
		private String token;
	
		public UserSession(String email, String session) {
			super();
			this.id = email;
			this.token=session;
		}
		@Override
		public String toString() {
			return "UserSession [email=" + id + ", session=" + token +"]";
		}
		
		
		

	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doGet(request, response);
		
		    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
		    

			
		//	PrintWriter writer = 

			
			DataAccess da = new DataAccess();
			User user = null;
			JsonUser jsonUser=null;

			if (user == null) {
				//TODO: request parameters to json user..


				jsonUser = new JsonUser(user, Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, null);
			} else {
				
				jsonUser=new JsonUser(user,Constants.STATUS_SUCCESS,Constants.SUCCESS,myUser.token);
				
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
