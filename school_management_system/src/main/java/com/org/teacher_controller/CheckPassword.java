package com.org.teacher_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.TeacherDao;
import com.org.dto.Teacher;
@WebServlet("/change_pwd")
public class CheckPassword extends HttpServlet{
			
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String aEmail= req.getParameter("em");
		String aPwd =req.getParameter("pwd");

	TeacherDao dao = new TeacherDao();
		List<Teacher> teachers = dao.fetchTeacherByEmailPassword(aEmail, aPwd);
		Teacher teacher = teachers.get(0);
		
		if(teacher.getEmail().equals(aEmail) &  teacher.getPassword().equals(aPwd) ) {
			
        resp.sendRedirect("teacher/update_password.jsp");
        }
	}
}
