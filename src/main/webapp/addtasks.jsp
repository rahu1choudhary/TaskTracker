<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Task</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: linear-gradient(to right, #8ec5fc, #e0c3fc);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .container {
            max-width: 500px;
            background: white;
            margin: 80px auto;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.2);
        }

        h2 {
            text-align: center;
            color: #673ab7;
            margin-bottom: 30px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #333;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
            font-size: 14px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #673ab7;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #5e35b1;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #007BFF;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Add a New Task</h2>
        <form action="TaskServlet" method="POST">
            <label for="title">Title</label>
            <input type="text" id="title" name="title" required>

            <label for="deadline">Deadline</label>
            <input type="text" id="deadline" name="deadline" placeholder="e.g. 2025-06-01" required>

            <label for="status">Status</label>
            <input type="text" id="status" name="status" placeholder="Pending or Completed" required>

            <input type="submit" value="Submit">
        </form>
        <a href="tasklist.jsp">← Back to Task List</a>
    </div>
</body>
</html>
