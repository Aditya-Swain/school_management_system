package com.org.principal_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.PrincipalDao;
import com.org.dto.Principal;
@WebServlet("/update_principal_password")
public class UpdatePassword extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newPassword = req.getParameter("newPwd");
		int id = Integer.parseInt( req.getParameter("sid"));
		
		PrincipalDao dao = new PrincipalDao();
		Principal Principal= dao.fetchPrincipalById(id);
		Principal.setPassword(newPassword);
		dao.saveAndUpdatePrincipal(Principal);
		
		HttpSession session = req.getSession();
		session.setAttribute("valid", "Password Updated");
		resp.sendRedirect("principal/principal_login.jsp");
	}
}
