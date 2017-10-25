package mm.androidservice.download;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadFile
 */
@WebServlet("/DownloadFile")
public class DownloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String id = request.getHeader("id");
//		String token = request.getHeader("token");
		
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		//String token = request.getParameter("token");
//		System.out.println(id+type);
		
		if(type.equals("img")) {
			if(!ClientDownloadFile.downloadFile(id, ClientDownloadFile.PIC_BUCKET,response)) {
				ClientDownloadFile.downloadFile("defaultImage", ClientDownloadFile.PIC_BUCKET,response);
			}
		}

		if(type.equals("cv")) {
			ClientDownloadFile.downloadFile(id, ClientDownloadFile.CV_BUCKET,response);
		}
		
		if(type.equals("grade")) {
			ClientDownloadFile.downloadFile(id, ClientDownloadFile.GRADE_BUCKET,response);
		}
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
