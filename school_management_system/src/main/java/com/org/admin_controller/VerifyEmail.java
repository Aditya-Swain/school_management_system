package com.org.admin_controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.SchoolDao;
import com.org.dto.School;
@WebServlet("/school_otp")
public class VerifyEmail extends HttpServlet{
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String email = req.getParameter("email");
			HttpSession session = req.getSession();

			SchoolDao dao = new SchoolDao();
			List<School> schools = dao.verifyByEmail(email);
			if(!schools.isEmpty()) {
				 School school = schools.get(0);
				System.out.println(school.getEmail());
				session.setAttribute("emailObj", school);
				Random random = new Random(); 
				String generatedOTP =""+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9);
				session.setAttribute("gOTP", generatedOTP);
				System.out.println(generatedOTP);
				
				
////				Step:1
//				Properties properties = System.getProperties();
//				properties.setProperty("mail.smtp.host", "smtp.gmail.com");
//				properties.setProperty("mail.smtp.port","465" );
//				properties.setProperty("mail.smtp.ssl.enable", "true");
//				properties.setProperty("mail.smtp.auth", "true");
				
////				Step:2
//						Session session1 = Session.getInstance(properties, new Authenticator() {
//							
//							protected PasswordAuthentication getPasswordAuthentication() {
//								
//								return new PasswordAuthentication("adityaswain817@gmail.com", "amhq locp gwqt xvhr");
//							}
//				
//						});
//						session1.setDebug(true);
//						
////						step:3
//						
//						MimeMessage message=new MimeMessage(session1);
//						
//						try {
//							message.setFrom("adityaswain817@gmail.com");
//							message.addRecipient(Message.RecipientType.TO, new InternetAddress(school.getEmail()));
//							message.setSubject("For change password purpose");
//							message.setText("Your otp is : "+generatedOTP+" , don't share with other person");
//							
////				Step:4
//							Transport.send(message);
//							System.out.println("Message Sent");
//							
//							a
//						} catch (MessagingException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						
				resp.sendRedirect("school/verify_otp.jsp");
				
			}
			else {
				session.setAttribute("invalid", "invalid email id ");
				resp.sendRedirect("school/verify_email.jsp");
			}
	}
}
