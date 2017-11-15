package mm.webclientservlets;

import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendingMail {

    private static String USER_NAME = "Mail.test135791";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "mailtest"; // GMail password

    public static void main(String[] args) {}

    public static void sendFromGMail( String to, String subject, String body) {
       String from = USER_NAME;
       String pass = PASSWORD;
    	Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress("mail@example.com", "Tsofen TeamWork"));
            InternetAddress toAddress = new InternetAddress(to);
   
            message.addRecipient(Message.RecipientType.TO, toAddress);

            message.setSubject(subject);

            message.setText(body,"UTF-8");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}