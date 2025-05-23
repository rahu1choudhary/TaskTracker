package com.tasktracker.servlet;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.tasktracker.dao.*;


/**
 * Servlet implementation class DeleteTaskServlet
 */
@WebServlet("/DeleteTaskServlet")
public class DeleteTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		int taskId = Integer.parseInt(request.getParameter("taskid"));
	
	try {
		TaskDAO.deleteTask(taskId);
		 response.sendRedirect("viewTasksServlet");
	} catch (ClassNotFoundException e) {
		
	response.getWriter().print(e.getMessage());
	} catch (SQLException e) {
		
		response.getWriter().print(e.getMessage());
	}
	
	}

}
