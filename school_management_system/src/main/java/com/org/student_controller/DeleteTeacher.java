package com.org.student_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.TeacherDao;
import com.org.dto.Principal;
import com.org.dto.Student;
import com.org.dto.Teacher;
@WebServlet("/delete_teacher")
public class DeleteTeacher extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id = Integer.parseInt( req.getParameter("id"));
			
			TeacherDao dao = new TeacherDao();
			
			Teacher teacher = dao.fetchTeacherById(id);
			
			Principal principal = teacher.getPrincipal();
			List<Student> students = teacher.getStudents();
			dao.deleteTeacher(teacher, principal);
			resp.sendRedirect("principal/view_teacher.jsp");
		}
}
