package mm.androidservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
import java.time.Instant;
import java.util.Iterator;

>>>>>>> Stashed changes
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.model.JsonUser;
<<<<<<< Updated upstream
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
=======
import mm.model.User;
import controllers.SessionController;
import mm.da.DataAccess;
import mm.model.*;
import mm.constants.*;
import java.lang.Object;
import java.sql.SQLException;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
	JsonObject myJson = ServerUtils.getJsonObjcetFromRequest(request);

	String email = myJson.get("email").getAsString();
	String password = myJson.get("password").getAsString();
	//TODO deviceID storage
	String deviceId = myJson.get("deviceId").getAsString();

			DataAccess da = new DataAccess();
			User user = null;
			try {
				user = da.login(email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//user = new User(1,"testMan","ok","gmail.com","12345","abc","male","Antractica","good test",true,User.userType.MENTEE);	
			
			JsonUser jsonUser=null;

			if(user==null) {
				jsonUser = new JsonUser(user, Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, null);
			} 
			else if(user.getPassword().equals(password)){
				 
				String token=ServerUtils.generateToken();
				//TODO
				//da.insertSession(myUser.email,token,new Instant.now(),ENDDATE,myUser.deviceId);
				//insert session into database
				jsonUser = new JsonUser(user, Constants.STATUS_SUCCESS, Constants.SUCCESS, token);
			}			
			else {
				jsonUser = new JsonUser(user, Constants.STATUS_WRONGPARA, Constants.WRONGPASSWORD, null);
			}
				
			
			ServerUtils.respondJsonObject(response,jsonUser);
			
			}
}


