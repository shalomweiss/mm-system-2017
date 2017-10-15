package mm.webclientservlets;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExampleServlet
 */
@WebServlet("/ExampleServlet")
public class ExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request,response);
		String name=request.getParameter("jsp");
//      RequestDispatcher req = null;
      
		  
//       request.setAttribute("namee", namee);
//		 req.forward(request, response);
	   RequestDispatcher rd = null;
         if(name.equals("LL")){
        	 rd=request.getRequestDispatcher("Test2.jsp");
        	 response.getWriter().append("MACH");
         }
         else{
         response.getWriter().append("Served at: ").append(request.getContextPath());
      //   response.getWriter().append("ERROR NAME");
      //  rd=request.getRequestDispatcher("Test.jsp");
        
         }
		response.setContentType("text/html");	
		rd.forward(request, response);
		  
		  
		//		System.out.println("ExampleSErvletToGET");
//		
//		List <User> getUsers = new ArrayList<User>();
//		
//		//to test
//		
//	    getUsers.add(new User());
//	    
//		/*getUsers.add(new User("dunia","abo"));
//		getUsers.add(new User("yara","roh"));
//		getUsers.add(new User("ghada","aaa"));*/
//		
//	     
//		Gson gson = new Gson();
//	    System.out.println("USER with not json " +getUsers);
//		String userResult = gson.toJson(getUsers, Constants.USER_CLASS);
//		
//	    System.out.println("USer with JSON" + userResult);	    
//	    
//	    PrintWriter writer = response.getWriter();
//		writer.println(userResult);
//		writer.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
