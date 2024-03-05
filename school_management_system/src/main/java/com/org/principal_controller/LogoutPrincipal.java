package com.org.principal_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/principal_logout")
public class LogoutPrincipal extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			session.removeAttribute("principalObj");
			resp.sendRedirect("principal/principal_login.jsp");
		}
}
