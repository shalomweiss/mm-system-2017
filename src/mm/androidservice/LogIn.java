package mm.androidservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import util.DBUtil;
import util.ServerUtils;
import mm.constants.Constants;
import mm.da.DataAccess;
import mm.jsonModel.*;
import mm.model.User;
import mm.model.UserLoginAndroid;

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
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));

		    StringBuilder sb = new StringBuilder();
		    String s;
		    while ((s = br.readLine()) != null) {
		         sb.append(s).append("\n");
		    }
		    PrintWriter out = response.getWriter();
		//    out.println("HELOO"+sb);
			    
		    
		    String jsonString = sb.toString();
		    Gson gson = new Gson();
		    UserLoginAndroid myUser = gson.fromJson( jsonString, UserLoginAndroid.class );
		//    out.println(myUser);
		//    response.getWriter().append("STRING JSON: "+jsonString); //like out.println(jsonString)
			
			DataAccess da = new DataAccess();
			User user = null;
			try {
				user = da.login(myUser.getEmail());			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			JsonUser jsonUser=null;
			
			if(user==null) {
				jsonUser = new JsonUser(user, Constants.STATUS_MISSINGPARA, Constants.USERNOTFOUND, null);
			} 
			else if(user.getPassword().equals(myUser.getPassword())){
				String token=ServerUtils.generateToken();
				jsonUser = new JsonUser(user, Constants.STATUS_SUCCESS, Constants.SUCCESS, token);
			}			
			else {
					jsonUser = new JsonUser(user, Constants.STATUS_WRONGPARA, Constants.WRONGPASSWORD, null);
				 }
			response.setContentType("application/json");
			out.println(jsonUser);
			out.flush();
			out.close();
			}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
		
		    
}


