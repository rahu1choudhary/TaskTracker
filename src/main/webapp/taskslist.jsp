<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tasktracker.model.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Tasks | Task Tracker</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
        }
        .top-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .task-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .task-table th, .task-table td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        .status-pending {
            color: orange;
            font-weight: bold;
        }
        .status-completed {
            color: green;
            font-weight: bold;
        }
        .actions button {
            margin-right: 5px;
        }
        .filter-section {
            margin-top: 15px;
        }
    </style>
</head>
<body>

    <div class="top-bar">
        <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
        <div>
            <a href="addtasks.jsp">Add Task</a>|
            <a href="LogoutServlet">Logout</a>
        </div>
    </div>

    <div class="filter-section">
        <label>Filter:</label>
        <select>
            <option>All</option>
            <option>Pending</option>
            <option>Completed</option>
        </select>
    </div>

    <table class="task-table">
        <thead>
            <tr>
                <th>Title</th>
                <th>Deadline</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
<%
    List<Task> taskList = (List<Task>) request.getAttribute("taskList");
    for(Task task : taskList){
%>
    <tr>
        <td><%= task.getTitle() %></td>
        <td><%= task.getDeadLine() %></td>
        <td><%= task.getStatus() %></td>
        <td class="actions">
            <!-- Done button (you can wire this up similarly later) -->
            <form action="MarkDoneServlet" method="post" style="display:inline;">
                <input type="hidden" name="taskid" value="<%= task.getID() %>"/>
                <input type="submit" value="Done"/>
            </form>

            <!-- Delete button -->
            <form action="DeleteTaskServlet" method="post" style="display:inline;">
                <input type="hidden" name="taskid" value="<%= task.getID() %>"/>
                <input type="submit" value="Delete"/>
            </form>
        </td>
    </tr>
<%
    }
%>
</tbody>
    </table>

</body>
</html>