package mm.androidservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.da.DataInterface;
import mm.jsonModel.JsonUser;
import mm.model.User;
import util.ServerUtils;


/**
 * Servlet implementation class UpdateProfileTest
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
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
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

						
			JsonObject myJson = ServerUtils.getJsonObjcetFromRequest(request);
			
			int id = (int) (myJson.get("id").isJsonNull() ? "" : myJson.get("id").getAsInt());
			String token = myJson.get("token").getAsString();
			User updatedUser = new Gson().fromJson(myJson.get("user").getAsJsonObject(), User.class);
					//new User(myJson.get("user"));//TODO CHECK VARIABLES
			
			DataInterface da = new DataAccess();
			JsonUser jsonUser=null;
			
			if(ServerUtils.validateUserSession(id, token, da)&&updatedUser!=null) {
				try {	
					//Sending user updated info to database
					
					
					
					
					if(
					da.editUser(updatedUser)
					) {
						//success
						jsonUser = new JsonUser(updatedUser, Constants.STATUS_SUCCESS, Constants.SUCCESS, token);
						
					}else {
						//failed
						jsonUser = new JsonUser(updatedUser, Constants.STATUS_WRONGPARA, Constants.ERROR, token);
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
				
			}else {
				//TODO
				//session error
				jsonUser = new JsonUser(null, Constants.STATUS_MISSINGPARA, Constants.ERROR, null);
			}
			

			ServerUtils.respondJsonObject(response,jsonUser);

	}
	
//	private boolean validateUserFields(User user) {
//		if(user.getFirstName()!=null && !user.getFirstName().trim().isEmpty()) {
//			user.setFirstName(user.getFirstName().trim());
//		}else {
//			return false;
//		}
//		
//		if(user.getLastName()!=null && !user.getLastName().trim().isEmpty()) {
//			user.setLastName(user.getLastName().trim());
//		}else {
//			return false;
//		}
//		
//		if(user.()!=null && !user.getFirstName().trim().isEmpty()) {
//			user.setFirstName(user.getFirstName().trim());
//		}else {
//			return false;
//		}
//	}
	
}
