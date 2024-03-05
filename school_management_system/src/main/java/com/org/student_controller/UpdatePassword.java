package com.org.student_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.StudentDao;
import com.org.dto.Student;
@WebServlet("/update_student_password")
public class UpdatePassword extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newPassword = req.getParameter("newPwd");
		int id = Integer.parseInt( req.getParameter("sid"));
		
		StudentDao dao = new StudentDao();
		Student student= dao.fetchStudentById(id);
		student.setPassword(newPassword);
		dao.saveAndUpdateStudent(student);
		
		HttpSession session = req.getSession();
		session.setAttribute("valid", "Password Updated");
		resp.sendRedirect("student/student_login.jsp");
	}
}
