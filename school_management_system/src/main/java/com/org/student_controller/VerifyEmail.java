package com.org.student_controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.StudentDao;
import com.org.dto.Student;
@WebServlet("/student_otp")
public class VerifyEmail extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String email = req.getParameter("email");
			HttpSession session = req.getSession();

			StudentDao dao = new StudentDao();
			List<Student> Students = dao.verifyEmail(email);
			if(!Students.isEmpty()) {
				Student student = Students.get(0);
				System.out.println(student.getEmail());
				session.setAttribute("studentEmail", student);
				Random random = new Random(); 
				String generatedOTP =""+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9);
				session.setAttribute("gOTP", generatedOTP);
				System.out.println(generatedOTP);
				
						
				resp.sendRedirect("student/verify_otp.jsp");
				
			}
			else {
				session.setAttribute("invalid", "invalid email id ");
				resp.sendRedirect("student/verify_email.jsp");
			}
	}
}
