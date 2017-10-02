package mm.androidservice;

import java.io.IOException;
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
import mm.webclientservlets.GetMentorById;
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
		JsonObject myJson = iom.getJsonRequest();
	//	JsonObject myJson = ServerUtils.getJsonObjectFromRequest(request);
		
		int id = (myJson.get("id").isJsonNull() ? 0 : myJson.get("id").getAsInt());
		String token = myJson.get("token").getAsString();
		
		User mentor=null;
		JsonUser jsonUser=null;
	
		
		DataInterface da = new DataAccess();
		if(ServerUtils.validateUserSession(id,token,iom.getDataAccess())) {
			

			try {
				mentor=iom.getDataAccess().getMentorOfMentee(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if (mentor == null) {

			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
			} else {
 
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
				iom.addResponseParameter("user", mentor);
						
			}
		}
		else {
			iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.INVALID_SESSION));
		}

		
		iom.SendJsonResponse();
		
	}

}
