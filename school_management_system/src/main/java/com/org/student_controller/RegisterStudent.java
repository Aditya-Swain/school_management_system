package com.org.student_controller;

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
import com.org.dao.SchoolDao;
import com.org.dao.StudentDao;
import com.org.dao.TeacherDao;
import com.org.dto.Principal;
import com.org.dto.Student;
import com.org.dto.Teacher;

@WebServlet("/student_register")
public class RegisterStudent extends HttpServlet{
				
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));
			long mobile = Long.parseLong(req.getParameter("mobile"));
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String course = req.getParameter("course");
			String status = req.getParameter("status");
			String address = req.getParameter("address");
			
			int principalId = Integer.parseInt(req.getParameter("pId"));
			int teacherId =Integer.parseInt( req.getParameter("course"));
			
			Teacher teacher = new TeacherDao().fetchTeacherById(teacherId);
			Principal principal = new PrincipalDao().fetchPrincipalById(principalId);
			Student student = new Student();
			
			student.setName(name);
			student.setAddress(address);
			student.setAge(age);
			student.setMobile(mobile);
			student.setEmail(email);
			student.setPassword(password);
			student.setCourse(teacher.getSubject());
			student.setStatus(status);
			student.setTeacher(teacher);
			student.setPrincipal(principal);
			
			List<Student> students = new ArrayList<Student>();
			students.add(student);
			
			teacher.setStudents(students);
			principal.setStudents(students);
			
			StudentDao dao = new StudentDao();
			dao.saveAndUpdateStudent(student);
			
			HttpSession session = req.getSession();
			session.setAttribute("success", "Successfully Registered");
			resp.sendRedirect("student/student_register.jsp");
			
	}
}
