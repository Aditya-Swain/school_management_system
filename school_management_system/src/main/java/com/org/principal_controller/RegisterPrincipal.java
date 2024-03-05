package com.org.principal_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.PrincipalDao;
import com.org.dao.SchoolDao;
import com.org.dto.Principal;
import com.org.dto.School;
@WebServlet("/principal_register")
public class RegisterPrincipal extends HttpServlet{
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("name");
			 int age = Integer.parseInt(req.getParameter("age"));
			long mobile = Long.parseLong(req.getParameter("mobile"));
			String qualification = req.getParameter("qualification");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			int schId = Integer.parseInt(req.getParameter("schoolId"));
			
			Principal principal = new Principal();
			principal.setName(name);
			principal.setAge(age);
			principal.setEmail(email);
			
			principal.setPassword(password);
			principal.setMobile(mobile);
			principal.setQualification(qualification);
			
			SchoolDao dao = new SchoolDao();
			
			School school = dao.fetchSchoolById(schId);
			
			school.setPrincipal(principal);
			principal.setSchool(school);
			
			PrincipalDao dao1 = new PrincipalDao();
			dao1.saveAndUpdatePrincipal(principal);
			resp.sendRedirect("principal/principal_login.jsp");
		}
}
