package mm.webclientservlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.da.DataAccess;

/**
 * Servlet implementation class DisconnectPair
 * param: id of the pard, da.disconnect(idPair)
 */
@WebServlet("/DisconnectPair")
public class DisconnectPair extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisconnectPair() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DISCONNECT PAIR SERVLET");
		String pairId=request.getParameter("pairId");
	//	String nextPage=request.getParameter("jsp");
		int id=Integer.parseInt(pairId);
		
		DataAccess da = new DataAccess();
	    boolean res=true;
	    RequestDispatcher req = null;
	    response.setContentType("text/html");
	    
		res = da.disconnectPair(id);
		
		try {
			da.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res){
		//	response.getWriter().append("Disconnect Pair Successfull");
			
			response.getWriter().append(""+id);
			//req = request.getRequestDispatcher(nextPage);
		}
		else 
			//response.getWriter().append("Disconnect Pair Is Failure");
		
		req.forward(request, response);
		
	}

	}


