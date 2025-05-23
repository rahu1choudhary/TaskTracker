package com.tasktracker.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username=request.getParameter("username");
	String password=request.getParameter("userpassword");
	
	try {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\SQLite_Projects\\taskTracker.db");
		Statement st=conn.createStatement();
		try {
		    conn.setAutoCommit(true); // Optional but safe
		    String sql = "INSERT INTO user(userName, password) VALUES('" 
		                 + username + "','" 
		                 + password + "')";
		    int rows = st.executeUpdate(sql);
		    System.out.println("Rows inserted: " + rows);
		    st.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		response.sendRedirect("login.jsp");
	}catch(ClassNotFoundException e ) {
		e.getStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

}
