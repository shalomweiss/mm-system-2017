package mm.androidservice;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.jsonModel.JsonUser;
import mm.jsonModel.JsonUsers;
import mm.model.User;
import util.ServerUtils;

/**
 * Servlet implementation class GetMentees
 */
@WebServlet("/GetMentees")
public class GetMentees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMentees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JsonObject myJson = ServerUtils.getJsonObjcetFromRequest(request);
		
		int id = (int) (myJson.get("id").isJsonNull() ? "" : myJson.get("id").getAsInt());
		String token = myJson.get("token").getAsString();

		DataAccess da = new DataAccess();
		JsonUsers jsonUsers=null;
		List<User> mentees=null;
		User mentor=null;
		
		
		if(ServerUtils.validateUserSession(id,token,da)) {
		
		
		
		//mentees=da.getMenteesOfMentor(id);
		
		if (mentees == null) {

			//jsonUsers = new JsonUsers(mentees, Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, null);
		} else {
			
			//jsonUsers=new JsonUser(mentees,Constants.STATUS_SUCCESS,Constants.SUCCESS,token);
			
			}
		}
		else {
			jsonUsers = new JsonUsers(null, Constants.STATUS_MISSINGPARA, Constants.INVALID_SESSION_TOKEN, null);
		}

		
		ServerUtils.respondJsonObject(response,jsonUsers);
		
		
	
	}

}
