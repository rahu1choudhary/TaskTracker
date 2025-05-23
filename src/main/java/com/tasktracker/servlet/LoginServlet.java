package com.tasktracker.servlet;

import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("userpassword");
		
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\SQLite_Projects\\taskTracker.db");
		    Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("SELECT userName,password FROM user");

		    boolean found = false;

		    while (rs.next()) {
		        if (rs.getString("userName").equals(username) && rs.getString("password").equals(password)) {
		        	PreparedStatement ps = conn.prepareStatement("SELECT userID FROM user WHERE userName = ?");
		        	ps.setString(1, username);
		        	ResultSet rs1 = ps.executeQuery();
		        	int userID=rs1.getInt("userID");
		            HttpSession session = request.getSession();
		            session.setAttribute("userID", userID);
		            session.setAttribute("username", username);
		            response.sendRedirect("viewTasksServlet");
		            found = true;
		            rs1.close();
		            rs.close();
		            break;
		            
		        }
		    }

		    if (!found) {
		        response.sendRedirect("register.jsp");
		    }

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		    response.getWriter().println("DB Error: " + e.getMessage());
		}

		
		
	}

}
