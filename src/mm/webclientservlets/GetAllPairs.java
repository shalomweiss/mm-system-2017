package mm.webclientservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.da.DataAccess;
import mm.model.Mentee;
import mm.model.Mentor;
import mm.model.Pair;
import mm.model.User;

/**
 * Servlet implementation class GetAllPairs
 * return from db ArrayList<Pair>: Pair Contructor is:
 * public Pair(int pairId, Mentor mentor, Mentee mentee, int activeStatuse,
			Date startDate, Date endDate, String joinMessage,
			String tsofenMessage)
	
	check if activestatuse==1? send to client else remove this pair		 
 */
@WebServlet("/GetAllPairs")
public class GetAllPairs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllPairs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String NextPage = request.getParameter("jsp");
		
		//

		ArrayList<Pair> pairs = new ArrayList<Pair>();
		DataAccess da = new DataAccess();
	//	Iterator i=ArrPairs.iterator();
		//ArrPairs=getAllPair();
//		 try {
//		 pairs = da.getAllPairs();
//		 } catch (SQLException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }
		  //TODO: check activateStatuse for AppPair: if its==1, keeping, else remove before sending to client side 
		
		
		request.setAttribute("pairs", pairs);
		//System.out.println("Pairs: " + ArrPairs);
	//	PrintWriter writer = response.getWriter();
	//	writer.println(ArrPairs);
		RequestDispatcher req = request.getRequestDispatcher(NextPage);
		req.forward(request, response);
		//writer.close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	public ArrayList<Pair> getAllPair(){
		ArrayList<Pair> a=new ArrayList<Pair>();
		Mentee u= new Mentee();
		u.setFirstName("firdos");
		u.setLastName("F");
		u.setActive(true);
		
		Mentor men=new Mentor();
		men.setFirstName("MENTOR");
		men.setWorkHistory("MICROSOFT");
		Pair pair= new Pair();
		pair.setMentor(men);
		pair.setMentee(u);
		pair.setActiveStatuse(1);
		
		pair.setMentorId(888);
		a.add(pair);
		return a;
	}

}
