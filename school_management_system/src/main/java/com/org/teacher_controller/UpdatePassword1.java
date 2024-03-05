package com.org.teacher_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.TeacherDao;
import com.org.dto.Teacher;
@WebServlet("/update_teacher_password")
public class UpdatePassword1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newPassword = req.getParameter("newPwd");
		int id = Integer.parseInt( req.getParameter("sid"));
		
		TeacherDao dao = new TeacherDao();
		Teacher teacher= dao.fetchTeacherById(id);
		teacher.setPassword(newPassword);
		dao.saveAndUpdateTeacher(teacher);
		
		HttpSession session = req.getSession();
		session.setAttribute("valid", "Password Updated");
		resp.sendRedirect("teacher/teacher_login.jsp");
	}
}
