//package mm.webclientservlets;
//
//import java.util.;
//import javax.mail.;
//import javax.mail.internet.;
//
//public class SendingMail {
//
//    private static String USER_NAME = Mail.test135791; //  GMail user name (just the part before @gmail.com)
//    private static String PASSWORD = mailtest;  GMail password
//    private static String RECIPIENT = 2131995m@gmail.com;
//
//    public static void main(String[] args) {
//        String from = USER_NAME;
//        String pass = PASSWORD;
//        String to = RECIPIENT; // list of recipient email addresses
//        String subject = Java send mail example;
//        String body = Welcome to JavaMail!;
//
//        sendFromGMail(from, pass, to, subject, body);
//    }
//
//    public static void sendFromGMail( String to, String subject, String body) {
//       String from = Mail.test135791;
//       String pass = mailtest;
//    	Properties props = System.getProperties();
//        String host = smtp.gmail.com;
//        props.put(mail.smtp.starttls.enable, true);
//        props.put(mail.smtp.host, host);
//        props.put(mail.smtp.user, from);
//        props.put(mail.smtp.password, pass);
//        props.put(mail.smtp.port, 587);
//        props.put(mail.smtp.auth, true);
//
//        Session session = Session.getDefaultInstance(props);
//        MimeMessage message = new MimeMessage(session);
//
//        try {
//            message.setFrom(new InternetAddress(from));
//            InternetAddress toAddress = new InternetAddress(to);
//   
//            message.addRecipient(Message.RecipientType.TO, toAddress);
//
//            message.setSubject(subject);
//            message.setText(body);
//            Transport transport = session.getTransport(smtp);
//            transport.connect(host, from, pass);
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();
//        }
//        catch (AddressException ae) {
//            ae.printStackTrace();
//        }
//        catch (MessagingException me) {
//            me.printStackTrace();
//        }
//    }
//}