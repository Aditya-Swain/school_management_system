package com.org.teacher_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.PrincipalDao;
import com.org.dao.TeacherDao;
import com.org.dto.Principal;
import com.org.dto.Teacher;

@WebServlet("/teacherUpdate")
public class UpdateTeacher extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("name");
			int age = Integer.parseInt( req.getParameter("age"));
			long mobile =Long.parseLong( req.getParameter("mobile"));
			String email = req.getParameter("email");
			int teacherId =Integer.parseInt( req.getParameter("teacherId"));
			TeacherDao dao = new TeacherDao();

			Teacher teacher = dao.fetchTeacherById(teacherId);
			teacher.setId(teacherId);
			teacher.setName(name);
			teacher.setAge(age);
			teacher.setMobile(mobile);
			teacher.setEmail(email);
			
			dao.saveAndUpdateTeacher(teacher);
			HttpSession session = req.getSession();
			session.setAttribute("success", "Profile Updated");
			resp.sendRedirect("teacher/view_teacher.jsp");
			
		}
}
