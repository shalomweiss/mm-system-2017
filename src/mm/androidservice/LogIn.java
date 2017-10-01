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
import mm.jsonModel.JsonUser;
import mm.model.Session;
import mm.model.User;
import util.ServerUtils;


/**
 * Servlet implementation class LogInTest
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
	
		AndroidIOManager iom = new AndroidIOManager(request,response);			
		JsonObject myJson = iom.getJsonRequest();

		String email = myJson.get("email").getAsString();
		String password = myJson.get("password").getAsString();
		//TODO deviceID storage
		String deviceId = myJson.get("deviceId").getAsString();

			User user = null;
			try {
				user = iom.getDataAccess().login(email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//user = new User(1,"testMan","ok","gmail.com","12345","abc","male","Antractica","good test",true,User.userType.MENTEE);	
			
			//JsonUser jsonUser=null;

			if(user==null) {
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.DATABASE_ERROR));
			} 
			else if(user.getPassword().equals(password)){
				 
				String token=ServerUtils.generateToken();
				//TODO
				try {
					iom.getDataAccess().startUserSession(new Session(user.getId(),token,deviceId));
					iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.SUCCESS));
					iom.addResponseParameter("user", user);
					iom.addResponseParameter("token", token);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}			
			else {
				iom.addResponseParameter("user", user);
				iom.setResponseMessage(new RESPONSE_STATUS(RESPONSE_STATUS.PASSWORD_ERROR));
			}
				
			
			iom.SendJsonResponse();
			
			}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
}

}
