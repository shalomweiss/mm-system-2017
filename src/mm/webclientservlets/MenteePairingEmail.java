package mm.webclientservlets;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import javax.activation.*;
 
public class MenteePairingEmail extends HttpServlet {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
	//send to
	  String mentee =  request.getParameter("uEmail");

	  //send from
	  
	  String TTM = request.getParameter("TTM_Email");
	   
      // Assuming sending email from localhost
	  String host = request.getParameter("localhost");
 
      // Get system properties
      Properties properties = System.getProperties();
 
      // Setup mail server
      properties.setProperty("mail.smtp.host", host);
 
      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);
      
      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);
         
         // Set From: header field of the header.
         message.setFrom(new InternetAddress(TTM));
         
         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(mentee));
         
         // Set Subject: header field
         
         String subject = request.getParameter("subject");
         message.setSubject(subject);
         
         
    //     String menteePassword = request.getParameter("uPass");
         String msgContent = request.getParameter("message");
         
         // Now set the actual message
         message.setText(msgContent);
         
         // Send message
         Transport.send(message);
         String title = "Send Email";
         String res = "Sent message successfully....";
         String docType =
            "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
         
         out.println(docType +
            "<html>\n" +
               "<head><title>" + title + "</title></head>\n" +
               "<body bgcolor = \"#f0f0f0\">\n" +
                  "<h1 align = \"center\">" + title + "</h1>\n" +
                  "<p align = \"center\">" + res + "</p>\n" +
               "</body>"
            +"</html>"
         );
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
} 