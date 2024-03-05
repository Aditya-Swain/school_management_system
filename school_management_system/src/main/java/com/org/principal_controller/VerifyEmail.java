package com.org.principal_controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.PrincipalDao;
import com.org.dto.Principal;
@WebServlet("/principal_otp")
public class VerifyEmail extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String email = req.getParameter("email");
			HttpSession session = req.getSession();

			PrincipalDao dao = new PrincipalDao();
			List<Principal> Principals = dao.verifyEmail(email);
			if(!Principals.isEmpty()) {
				Principal Principal = Principals.get(0);
				System.out.println(Principal.getEmail());
				session.setAttribute("principalEmail", Principal);
				Random random = new Random(); 
				String generatedOTP =""+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9);
				session.setAttribute("gOTP", generatedOTP);
				System.out.println(generatedOTP);
				
						
				resp.sendRedirect("principal/verify_otp.jsp");
				
			}
			else {
				session.setAttribute("invalid", "invalid email id ");
				resp.sendRedirect("Principal/verify_email.jsp");
			}
	}
}
