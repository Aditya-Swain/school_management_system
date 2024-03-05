package com.org.student_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.PrincipalDao;
import com.org.dao.StudentDao;
import com.org.dto.Principal;
import com.org.dto.Student;
@WebServlet("/student_update")
public class UpdateStudent extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("name");
			int age = Integer.parseInt( req.getParameter("age"));
			long mobile =Long.parseLong( req.getParameter("mobile"));
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String subject = req.getParameter("course");
			String address = req.getParameter("address");
			String status = req.getParameter("status");
			String mark = req.getParameter("mark");
			int studentId =Integer.parseInt( req.getParameter("sId"));
			int principalId =Integer.parseInt( req.getParameter("pId"));
			Principal principal = new PrincipalDao().fetchPrincipalById(principalId);
			
			Student student = new Student();
			student.setId(studentId);
			student.setName(name);
			student.setAge(age);
			student.setMobile(mobile);
			student.setEmail(email);
			student.setPassword(password);
			student.setCourse(subject);
			student.setAddress(address);
			student.setStatus(status);
			student.setMarks(mark);
			student.setPrincipal(principal);
			
			List<Student> Students = new ArrayList<Student>();
			Students.add(student);
			principal.setStudents(Students);
			
			StudentDao dao = new StudentDao();
			dao.saveAndUpdateStudent(student);
			resp.sendRedirect("principal/view_student.jsp");
			
		}
}
