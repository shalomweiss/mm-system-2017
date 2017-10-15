package mm.androidservice;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import mm.jsonModel.MeetingModel;
import mm.model.Meeting;
import mm.model.User;
import mm.model.Meeting.meetingStatus;
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

		
		//JsonObject myJson = ServerUtils.getJsonObjectFromRequest(request);
		
	
		AndroidIOManager iom = new AndroidIOManager(request,response);
		
		 try{
				JsonObject myJson = iom.getJsonRequest();
				int id = (myJson.get("id").isJsonNull() ? 0 : myJson.get("id").getAsInt());
				String token = myJson.get("token").getAsString();
			
					
					
					User user=null;
					
					if(ServerUtils.validateUserSession(id,token,iom.getDataAccess())) {
					
					
					
					try {
						user=iom.getDataAccess().getUser(id);
						System.out.println(user.toString());
					} catch (SQLException e) {
					     iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
					}
					
					if (user == null) {
						System.out.println("");
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
						
					} else {
						iom.addResponseParameter("user", user);
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
						
						
						
						}
					}
					else {
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));
					}

					}catch(NullPointerException ex){
	             iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
	     }catch(Exception e){
	             iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.GENERAL_ERROR));
	     }finally{
	             iom.SendJsonResponse();
	     }
		
		
		
			
			
		
		    
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
		
			
		
	}

}
