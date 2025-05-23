package com.tasktracker.servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.tasktracker.dao.*;
import java.util.List;
import com.tasktracker.model.*;
/**
 * Servlet implementation class viewTasksServlet
 */
@WebServlet("/viewTasksServlet")
public class viewTasksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userID=(int) session.getAttribute("userID");
		
		try {
			List<Task> tasks = TaskDAO.getTasksByUserId(userID);
			request.setAttribute("taskList", tasks);
			request.getRequestDispatcher("/taskslist.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			response.getWriter().print(e.getMessage());
		} catch (SQLException e) {
			response.getWriter().print(e.getMessage());
		}
		
	}

}
