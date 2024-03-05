package com.org.teacher_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/verify_teacher_otp")
public class VerifyOTP extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String typedOTP = req.getParameter("typedOTP");
	HttpSession session = req.getSession();
	Object generatedOTP = session.getAttribute("gOTP");
	
	if(typedOTP.equals(generatedOTP)) {
		resp.sendRedirect("teacher/update_password1.jsp");
	}
	else
	{
		session.setAttribute("wrongOTP", "Wrong OTP !");
		resp.sendRedirect("teacher/verify_otp.jsp");
	}
}
}
