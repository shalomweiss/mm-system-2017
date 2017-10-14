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
import mm.da.DataAccess;
import mm.da.DataInterface;
import mm.model.Mentee;
import mm.model.Mentor;
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
		AndroidIOManager iom = new AndroidIOManager(request,response);
		
		try{
	           

			JsonObject myJson = iom.getJsonRequest();
			
			int id =(myJson.get("id").isJsonNull() ? 0 : myJson.get("id").getAsInt());
			String token = myJson.get("token").getAsString();

			DataInterface da = new DataAccess();
			List<Mentee> mentees=null;
			
			

				if(ServerUtils.validateUserSession(id,token,iom.getDataAccess())) {
				

				try {
					mentees=da.getMenteesOfMentor(id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


	if (mentees == null) {

				//jsonUsers = new JsonUsers(mentees, Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, null);
	} else {
				
				//jsonUsers =new JsonUsers(mentees,Constants.STATUS_SUCCESS,Constants.SUCCESS,token);
				
				
					try {
						mentees=iom.getDataAccess().getMenteesOfMentor(id);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				if (mentees == null) {

					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
				} else {
					
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
					iom.addResponseParameter("users", mentees);
					
					}
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

}
