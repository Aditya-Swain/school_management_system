package com.org.principal_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.PrincipalDao;
import com.org.dto.Principal;
@WebServlet("/principal_login")
public class LoginPrincipal extends HttpServlet{
			
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		PrincipalDao dao = new PrincipalDao();
		List<Principal> principals = dao.fetchPrincipalByEmailPassword(email, password);
		
		HttpSession session = req.getSession();
		
		if(!principals.isEmpty()) {
			Principal principal = principals.get(0);
			session.setAttribute("principalObj", principal);
			resp.sendRedirect("principal/principal_home.jsp");
		}
		else {
			session.setAttribute("invalid", "Invalid email or password");
			resp.sendRedirect("principal/principal_login.jsp");
		}
	} 
}
