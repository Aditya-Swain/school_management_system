package com.org.teacher_controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.TeacherDao;
import com.org.dto.Teacher;
@WebServlet("/teacher_otp")
public class VerifyEmail extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String email = req.getParameter("email");
			HttpSession session = req.getSession();

			TeacherDao dao = new TeacherDao();
			List<Teacher> teachers = dao.verifyEmail(email);
			if(!teachers.isEmpty()) {
				Teacher teacher = teachers.get(0);
				System.out.println(teacher.getEmail());
				session.setAttribute("teacherEmail", teacher);
				Random random = new Random(); 
				String generatedOTP =""+random.nextInt(9)+random.nextInt(9)+random.nextInt(9)+random.nextInt(9);
				session.setAttribute("gOTP", generatedOTP);
				System.out.println(generatedOTP);
				
						
				resp.sendRedirect("teacher/verify_otp.jsp");
				
			}
			else {
				session.setAttribute("invalid", "invalid email id ");
				resp.sendRedirect("teacher/verify_email.jsp");
			}
	}
}
