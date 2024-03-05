package com.org.student_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.StudentDao;
import com.org.dto.Principal;
import com.org.dto.Student;
import com.org.dto.Teacher;
@WebServlet("/delete_student")
public class DeleteStudent extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int studentId = Integer.parseInt( req.getParameter("id"));
			
			StudentDao dao = new StudentDao();
			
			Student student = dao.fetchStudentById(studentId);
			Principal principal = student.getPrincipal();
			Teacher teacher = student.getTeacher();
			dao.deleteStudent(student,teacher,principal);
			resp.sendRedirect("principal/view_student.jsp");
			
		}
}
