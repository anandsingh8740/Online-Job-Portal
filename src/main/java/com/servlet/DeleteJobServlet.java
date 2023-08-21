package com.servlet;

import java.io.IOException;

import com.DB.DBConnect;
import com.dao.JobDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteJobServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			
			
			JobDAO dao = new JobDAO(DBConnect.getConn());
			boolean f= dao.deleteJobs(id);
			
			 jakarta.servlet.http.HttpSession session =  req.getSession();
			   
				if(f) {
					session.setAttribute("succMsg", "Job Delete Sucessfully..");
					resp.sendRedirect("view_jobs.jsp");
				}else {
					session.setAttribute("succMsg", "Something wrong on server");
					resp.sendRedirect("view_jobs.jsp");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
