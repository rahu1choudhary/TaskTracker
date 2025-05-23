package com.tasktracker.dao;
import com.tasktracker.model.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
public class TaskDAO {
	
	public static int insertTask(Task task,int userID) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\SQLite_Projects\\taskTracker.db");
		String sql = "INSERT INTO tasks(userID, Title, deadline, status) VALUES(?, ?, ?, ?)";
		String sql1="SELECT id FROM tasks WHERE userID = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		PreparedStatement ps1 = conn.prepareStatement(sql1);
		ps.setInt(1, userID);
		ps.setInt(1, task.getUserID());
		ps.setString(2, task.getTitle());
		ps.setString(3, task.getDeadLine());
		ps.setString(4, task.getStatus());
		ps.executeUpdate();
		ps.close();
		ResultSet rs=ps1.executeQuery();
		rs.next();
		int id= rs.getInt("id");
		ps1.close();
		rs.close();
		return id;
	}
	
	public static List<Task> getTasksByUserId(int userID) throws SQLException, ClassNotFoundException {
		List<Task> taskList= new ArrayList<>();
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\SQLite_Projects\\taskTracker.db");
		String sql =  "SELECT id,Title,deadline,status from tasks where userID = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userID);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			Task task=new Task();
			task.setID(rs.getInt("id"));
			task.setTitle(rs.getString("Title"));
			task.setDeadLine(rs.getString("deadline"));
			task.setStatus(rs.getString("status"));
			taskList.add(task);
		}
		conn.close();
		ps.close();
		rs.close();
		return taskList;
	}
	
	public static void deleteTask(int taskid) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\SQLite_Projects\\taskTracker.db");
		String sql =  "DELETE FROM tasks WHERE id = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, taskid);
		ps.executeUpdate();
		conn.close();
		ps.close();
	}
	
	public static void MarkAsDone(int taskID) throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\SQLite_Projects\\taskTracker.db");
		String sql =  "UPDATE tasks SET status = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "completed");
		ps.setInt(2, taskID);
		ps.executeUpdate();
		conn.close();
		ps.close();
	}

}
