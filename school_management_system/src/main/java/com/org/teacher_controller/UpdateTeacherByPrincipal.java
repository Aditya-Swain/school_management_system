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
@WebServlet("/teacher_Update")
public class UpdateTeacherByPrincipal extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt( req.getParameter("age"));
		long mobile =Long.parseLong( req.getParameter("mobile"));
		String email = req.getParameter("email");
		String salary = req.getParameter("salary");
		int teacherId =Integer.parseInt( req.getParameter("teacherId"));
		TeacherDao dao = new TeacherDao();

		Teacher teacher = dao.fetchTeacherById(teacherId);
		teacher.setId(teacherId);
		teacher.setName(name);
		teacher.setAge(age);
		teacher.setMobile(mobile);
		teacher.setEmail(email);
		teacher.setSalary(salary);
		
		dao.saveAndUpdateTeacher(teacher);
		resp.sendRedirect("principal/view_teacher.jsp");
		
	}
}
