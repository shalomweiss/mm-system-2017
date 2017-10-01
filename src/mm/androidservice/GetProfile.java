package mm.androidservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.da.DataInterface;
import mm.jsonModel.JsonUser;
import mm.model.User;
import util.ServerUtils;

/**
 * Servlet implementation class LogInTest
 */
@WebServlet("/GetProfile")
public class GetProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		JsonObject myJson = ServerUtils.getJsonObjectFromRequest(request);
		
		int id = (myJson.get("id").isJsonNull() ? 0 : myJson.get("id").getAsInt());
		String token = myJson.get("token").getAsString();
		

			
			DataInterface da = new DataAccess();
			JsonUser jsonUser=null;
			User user=null;
			
			if(ServerUtils.validateUserSession(id,token,da)) {
			
			
			
			try {
				user=da.getUser(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (user == null) {

				jsonUser = new JsonUser(user, Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, null);
			} else {
				
				jsonUser=new JsonUser(user,Constants.STATUS_SUCCESS,Constants.SUCCESS,token);
				
				}
			}
			else {
				jsonUser = new JsonUser(null, Constants.STATUS_MISSINGPARA, Constants.INVALID_SESSION_TOKEN, null);
			}

			
			ServerUtils.respondJsonObject(response,jsonUser);
			
			
		
		    
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
		
			
		
	}

}
