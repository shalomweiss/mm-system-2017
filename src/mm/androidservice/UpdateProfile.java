package mm.androidservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.jsonModel.*;
import mm.model.User;
import util.ServerUtils;


/**
 * Servlet implementation class UpdateProfileTest
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*for json parsing*/
	private class UserSession {
		
		private String id;
		private String token;
		private User updatedUser;
		public UserSession(String id, String token, User updatedUser) {
			super();
			this.id = id;
			this.token = token;
			this.updatedUser = updatedUser;
		}
		@Override
		public String toString() {
			return "UserSession [id=" + id + ", token=" + token + ", updatedUser=" + updatedUser + "]";
		}
		
		

	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		    UserSession userToUpdate = ServerUtils.getJsonFromRequest(request,UserSession.class);
		    User user = null;
			DataAccess da = new DataAccess();
			//TODO
			//user=da.updateProfile(userToUpdate.id,userToUpdate.token,userToUpdate.updatedUser);
			JsonUser jsonUser=null;
			
			if(user==null) {
				jsonUser=new JsonUser(user, Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, userToUpdate.token);
			}
			else {
				jsonUser=new JsonUser(user, Constants.STATUS_SUCCESS, Constants.SUCCESS, userToUpdate.token);
			}		
			response.setContentType("application/json");
			// Get the printwriter object from response to write the required json object to the output stream      
			PrintWriter out = response.getWriter();
			// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
			out.print("LLLLL"+jsonUser);
			out.flush();
			out.close();
	}
}
