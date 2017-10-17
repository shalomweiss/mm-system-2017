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
import mm.model.Mentor;
import mm.model.User;
import mm.model.User.userType;
import util.ServerUtils;

/**
 * Servlet implementation class GetMentor
 */
@WebServlet("/GetMentor")
public class GetMentor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMentor() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int flag=0;
		AndroidIOManager iom = new AndroidIOManager(request,response);
		
		 try{
	           
			 JsonObject myJson = iom.getJsonRequest();
				List<Mentor> mentors=new ArrayList<Mentor>();
				User user=new User();
				
				int id = (myJson.get("id").isJsonNull() ? flag=1 : myJson.get("id").getAsInt());
				String token = (String) (myJson.get("token").isJsonNull()? flag=1 :myJson.get("token").getAsString());
				
				if(flag==1) {
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
				}else {
				Mentor mentor=null;
				
			
				if(ServerUtils.validateUserSession(id,token,iom.getDataAccess())) {
					user= iom.getDataAccess().getUser(id);
					if(user.getType()!=userType.MENTEE)
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
					else {
					

					try {
						mentor=iom.getDataAccess().getMentorOfMentee(id);
						mentors.add(mentor);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				
				if (mentor == null) {

					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
					} else {
		 
						iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
						iom.addResponseParameter("users", mentors);
								
					}
				}
				}
				else {
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));
				}
				}
				

	     }catch(NullPointerException ex){
	             iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PARAM_FAILED));
	     }catch(Exception e){
	             iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.GENERAL_ERROR));
	     }finally{
	             iom.SendJsonResponse();
	     }
		
	
	}

}
