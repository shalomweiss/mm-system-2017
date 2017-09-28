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

import com.google.gson.JsonObject;

import mm.constants.Constants;
import mm.da.DataAccess;
import mm.model.JsonMeeting;
import mm.model.Meeting;
import mm.model.Session;
import mm.model.User;
import util.ServerUtils;

/**
 * Servlet implementation class GetMeetingByID
 */
@WebServlet("/GetMeetingByID")
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
		
	ServerUtils.getJsonObjcetFromRequest(request);
	
	
	
	
	}

}
