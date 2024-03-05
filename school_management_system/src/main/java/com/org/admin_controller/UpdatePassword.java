package com.org.admin_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.SchoolDao;
import com.org.dto.School;
@WebServlet("/update_school_password")
public class UpdatePassword extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String newPassword = req.getParameter("newPwd");
			int id = Integer.parseInt( req.getParameter("sid"));
			
			SchoolDao dao = new SchoolDao();
			School school= dao.fetchSchoolById(id);
			school.setPassword(newPassword);
			dao.saveAndUpdate(school);
			
			HttpSession session = req.getSession();
			session.setAttribute("valid", "Password Updated");
			resp.sendRedirect("school/school_login.jsp");
		}
}
