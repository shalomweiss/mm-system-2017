package mm.webclientservlets;

import java.sql.SQLException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mm.da.DataAccess;
import mm.model.Mentor;
import mm.model.User;
import mm.model.User.userType;
import mm.model.WorkPlace;

/**
 * Servlet implementation class GetAllMentors
 */
@WebServlet("/GetAllMentors")
public class GetAllMentors extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllMentors() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET ALL MENTORS");
		ArrayList<User> ArrMentors = new ArrayList<User>();
		DataAccess da = new DataAccess();
		ArrMentors=getAllUsers();
		 try {
		 ArrMentors = da.getUsers(userType.MENTOR);
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		request.setAttribute("Mentors", ArrMentors);
		System.out.println("MENTORS: " + ArrMentors);
		
		
		ArrayList<WorkPlace> NewWorkPlace =new ArrayList<WorkPlace>();
		 try {
			 NewWorkPlace = da.getAllWorkingPlace();
			 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			ArrayList<String> NewWorkPlace1 =new ArrayList<String>();

	//	 NewWorkPlace = getAllWorkingPlace();
		 NewWorkPlace1.add("sss");
		 NewWorkPlace1.add("DDDDDDDDD");
		request.setAttribute("NewWorkPlace", NewWorkPlace); 
		System.out.println("AcadimicInnn "+  NewWorkPlace1);
		
		
		PrintWriter writer = response.getWriter();
		writer.println(ArrMentors);
		RequestDispatcher req ;
		req = request.getRequestDispatcher("mentors.jsp");
		req.forward(request, response);
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

	public ArrayList<User> getAllUsers() {

		ArrayList<User> getUsers = new ArrayList<User>();
		getUsers.add(new Mentor("firdos", "bobo"));
		getUsers.add(new Mentor("dunia", "abo"));
		getUsers.add(new Mentor("yara", "roh"));
		getUsers.add(new Mentor("ghada", "aaa"));
		return getUsers;
	}
	
	public ArrayList<WorkPlace> getAllCompanies(){
		ArrayList<WorkPlace> arr=new ArrayList<WorkPlace>();
		WorkPlace a=new WorkPlace(0, "Intel", "Haifa", "Haifa","matam");
		WorkPlace a1=new WorkPlace(0, "Microsoft", "Haifa", "Haifa","matam");

		arr.add(a);
		arr.add(a1);
	    return arr;
	}
	
}
