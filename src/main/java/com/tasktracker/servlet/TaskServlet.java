package com.tasktracker.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.tasktracker.model.*;

import com.tasktracker.dao.*;
/**
 * Servlet implementation class TaskServlet
 */
@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Task> tasks=new ArrayList();
		String title=request.getParameter("title");
		String deadline=request.getParameter("deadline");
		String status = request.getParameter("status");
		
		HttpSession session= request.getSession();
		int userID=(int) session.getAttribute("userID");
		
		Task task=new Task();
		task.setTitle(title);
		task.setDeadLine(deadline);
		task.setStatus(status);
		task.setUserID(userID);
		try {
			int id = TaskDAO.insertTask(task, userID);
			task.setID(id);
			tasks.add(task);
			request.setAttribute("taskList", tasks);
			request.getRequestDispatcher("taskslist.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			response.getWriter().println(e.getMessage());
		}
		
		
	}

}
