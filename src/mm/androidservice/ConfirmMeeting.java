package mm.androidservice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmMeeting
 */
@WebServlet("/ConfirmMeeting")
public class ConfirmMeeting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmMeeting() {
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
		//confirmMeeting(id,token,meeting_id,action)
		

//		JSONObject myJson = ServerUtils.getJsonObjcetFromRequest(request);
//		
//		int id = myJson.toString().get("id");
//		String token = myJson.get("token").getAsString();
//		int meetingId = (myJson.get("meeting_id").isJsonNull() ? 0 : myJson.get("meeting_id").getAsInt());
//		String action = myJson.get("action").getAsString();
//		
		
		
	}

}
