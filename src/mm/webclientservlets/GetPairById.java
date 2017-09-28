package mm.webclientservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mm.da.DataAccess;
import mm.model.Mentee;
import mm.model.Pair;

/**
 * Servlet implementation class GetPairById
 * Get Pair Object By sending Pais's ID 
 */
@WebServlet("/GetPairById")
public class GetPairById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPairById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("GetPairById");
		String idPair = request.getParameter("pairId");
        String jsp = request.getParameter("jsp");
          DataAccess da = new DataAccess();
            Pair pair = null;
//          try {
//               pair = da.getPair(idPair);
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
        request.setAttribute("PairById", pair);	
		RequestDispatcher req = request.getRequestDispatcher(jsp);
		req.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
