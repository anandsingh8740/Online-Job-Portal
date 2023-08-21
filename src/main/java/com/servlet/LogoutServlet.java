package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		jakarta.servlet.http.HttpSession session =  req.getSession();
		
		session.removeAttribute("userobj");
		
		session.setAttribute("succMsg", "Logout Successfully.");
		resp.sendRedirect("login.jsp");
	}

	
	
	
}
