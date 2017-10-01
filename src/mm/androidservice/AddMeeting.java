package mm.androidservice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mm.model.Meeting;
import util.ServerUtils;

/**
 * Servlet implementation class GetMeetingByID
 */
@WebServlet("/AddMeeting")
public class AddMeeting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMeeting() {
        super();
        // TODO Auto-generated constructor stub
    }

    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int id,String token,Meeting meeting
		AndroidIOManager iom = new AndroidIOManager(request,response);

	int id = iom.getJsonRequest().get("id").getAsInt();
	String token = iom.getJsonRequest().get("token").getAsString();
	Meeting meeting = new Gson().fromJson(iom.getJsonRequest().get("meeting"), Meeting.class);
	
	//todo add more validations
	if(ServerUtils.validateUserSession(id, token, iom.getDataAccess())){
		if(meeting!=null ) {
			try {
				if(iom.getDataAccess().addMeeting(meeting)) {
					
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
					
					
				}else {
					
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
				
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			//todo
			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
			
	
		}
	
	}else {
		iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));
		
	}
	iom.addResponseParameter("meeting", meeting);
	iom.SendJsonResponse();
	
	}

}