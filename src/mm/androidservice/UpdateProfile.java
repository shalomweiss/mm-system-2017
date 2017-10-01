package mm.androidservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		AndroidIOManager iom = new AndroidIOManager(request,response);			
			JsonObject myJson = iom.getJsonRequest();
			
			int id = (int) (myJson.get("id").isJsonNull() ? "" : myJson.get("id").getAsInt());
			String token = myJson.get("token").getAsString();
			User updatedUser = new Gson().fromJson(myJson.get("user").getAsJsonObject(), User.class);
					//new User(myJson.get("user"));//TODO CHECK VARIABLES

			if(ServerUtils.validateUserSession(id, token, iom.getDataAccess())&&updatedUser!=null) {
				try {	
					//Sending user updated info to database
					
					if(
							iom.getDataAccess().editUser(updatedUser)
					) {
						//success
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
				
						
					}else {
						//failed
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
				
			}else {
				//TODO
				//session error
		
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));
			}
			if(updatedUser!=null) {
			iom.addResponseParameter("user", updatedUser);
			}
			else {
				iom.addResponseParameter("user", "");
			}
			if(token!=null) {
			iom.addResponseParameter("token", token);
			}else {
				iom.addResponseParameter("token", "");
			}
			
			iom.SendJsonResponse();

	}
	
	
}
