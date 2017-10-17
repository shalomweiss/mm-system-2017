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
import mm.model.Pair;

/**
 * Servlet implementation class GetPairById Get Pair Object By sending Pais's ID
 */
@WebServlet("/GetPairById")
public class GetPairById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetPairById() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Get PairDetails Servlet");
		int pairId = Integer.parseInt(request.getParameter("pairId"));
		String nextPage = request.getParameter("jsp");
		DataAccess da = new DataAccess();
		Pair pair = new Pair();
		try {
			pair = da.getPair(pairId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("PairById", pairId);
		response.setContentType("text/html");
		RequestDispatcher req = request.getRequestDispatcher(nextPage);
		req.forward(request, response);
	}

}
