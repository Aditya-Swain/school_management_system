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
@WebServlet("/teacher_register")
public class RegisterTeacher extends HttpServlet{
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		 int age = Integer.parseInt(req.getParameter("age"));
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String subject = req.getParameter("subject");
		String status = req.getParameter("status");
		String salary = req.getParameter("salary");
		
		int principalId = Integer.parseInt(req.getParameter("pId"));
		
		Principal principal = new PrincipalDao().fetchPrincipalById(principalId);
		
		Teacher teacher = new Teacher();
		teacher.setName(name);
		teacher.setAge(age);
		teacher.setMobile(mobile);
		teacher.setEmail(email);
		teacher.setPassword(password);
		teacher.setSalary(salary);
		teacher.setSubject(subject);
		teacher.setStatus(status);
		
		teacher.setPrincipal(principal);
		List<Teacher> teachers = new ArrayList<>();
		teachers.add(teacher);
		
		TeacherDao dao = new TeacherDao();
		dao.saveAndUpdateTeacher(teacher);
		
		
		HttpSession session = req.getSession();
		session.setAttribute("success", "Successfully Registered");
		resp.sendRedirect("teacher/teacher_register.jsp");
		
		
		
		
		
		
		
		
		
		
		
	}
}
