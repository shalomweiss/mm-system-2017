package mm.androidservice.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;





/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadImage")
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletFileUpload uploader = null;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImage() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init() throws ServletException{
//    	DiskFileItemFactory fileFactory = new DiskFileItemFactory();
//		File filesDir = (File) getServletContext().getAttribute("C:\\Users\\Foad\\Music\\folder");
//		fileFactory.setRepository(filesDir);
//		this.uploader = new ServletFileUpload(fileFactory);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
    	

//    	
//    	int flag=0;
//    	JsonObject myJson = iom.getJsonRequest();
//    	int id = (myJson.get("id").isJsonNull() ? flag=1 : myJson.get("id").getAsInt());
//		String token = (String) (myJson.get("token").isJsonNull()? flag=1 :myJson.get("token").getAsString());
//		
//    	
    
    	PrintWriter out = response.getWriter();
    	
    	String id = request.getHeader("id");
    	String token = request.getHeader("token");
    	
    	System.out.println(token.length());
    	System.out.println(id);
        FileItemFactory itemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(itemFactory);

//        if (!contentType.equals("image/png")) {
//            out.println("Only PNG image files supported.");
//            continue;
//        }
        File file =null;
        try {
            List<FileItem> items = upload.parseRequest( new ServletRequestContext(request));
            for (FileItem item : items) {
                String contentType = item.getContentType();
                //save file in temporary directory on the server before sending it to a bucket
                
                file = File.createTempFile("img", ".jpg");

                item.write(file);//write to temp

                //upload to bucket
                //System.out.println(com.fasterxml.jackson.databind.ObjectMapper.class.getProtectionDomain().getCodeSource().getLocation());
           
                ClientUploadFile.uploadFile(id, file, ClientUploadFile.PIC_BUCKET);
                System.out.println("oneoenoeneoneoneoenoenoeneoneoneoenoenoeneone");
                //success
                file.deleteOnExit();
                
            }
        } catch (FileUploadException e) {
            out.println("Upload failed.");
      
            return;
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(file!=null)
		     file.deleteOnExit();
		}
    	
    	
    }
    	 
    	
    
    
    
    

    
    
    
    
    
    
//    
//    private static String getSubmittedFileName(Part part) {
//        for (String cd : part.getHeader("content-disposition").split(";")) {
//            if (cd.trim().startsWith("filename")) {
//                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
//                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
//            }
//        }
//        return null;
//    }
//    
//    private static File inputToFile(InputStream inputStream,String path) {
//    	
//    	File fileToSend = new File(path);
//    	OutputStream outputStream = null;
//
//    	try {
//    		// write the inputStream to a FileOutputStream
//    		outputStream =
//                        new FileOutputStream(fileToSend);
//
//    		int read = 0;
//    		byte[] bytes = new byte[1024];
//
//    		while ((read = inputStream.read(bytes)) != -1) {
//    			outputStream.write(bytes, 0, read);
//    		}
//
//    		System.out.println("Done!");
//    		return fileToSend;
//
//    	} catch (IOException e) {
//    		//TODO
//    		e.printStackTrace();
//    	} finally {
//    		if (inputStream != null) {
//    			try {
//    				inputStream.close();
//    			} catch (IOException e) {
//    				e.printStackTrace();
//    			}
//    		}
//    		if (outputStream != null) {
//    			try {
//    				// outputStream.flush();
//    				outputStream.close();
//    				//return fileToSend;
//    			} catch (IOException e) {
//    				e.printStackTrace();
//    				//return null;
//    			
//    			}
//
//    		}
//    		
//    	}
//    	return null;
//    }
    

}
