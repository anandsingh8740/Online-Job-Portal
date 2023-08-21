package com.servlet;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.DB.DBConnect;
import com.dao.UserDAO;
import com.entity.Jobs;
import com.entity.User;

@WebServlet("/update_profile")
public class UpdateUserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 try {
			
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String qua = req.getParameter("qua");
			String email = req.getParameter("email");
			String ps = req.getParameter("ps");
			
			UserDAO dao = new UserDAO(DBConnect.getConn());
			
			User u = new User();
			
			u.setId(id);
			u.setName(name);
			u.setQualification(qua);
			u.setPassword(ps);
			u.setEmail(email);
			
			boolean f = dao.updateUser(u);
			jakarta.servlet.http.HttpSession session =  req.getSession();
			if(f) {
				session.setAttribute("succMsg", "Profile Update Sucessfully");
				resp.sendRedirect("home.jsp");
			}else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("home.jsp");
			}
			
			} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
