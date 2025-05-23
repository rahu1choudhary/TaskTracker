<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register - Task Tracker</title>
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #e0c3fc, #8ec5fc);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .register-container {
        background-color: white;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        width: 350px;
        text-align: center;
    }

    h2 {
        color: #00bcd4;
        margin-bottom: 25px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        text-align: left;
        font-weight: bold;
        color: #333;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #00bcd4;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-weight: bold;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #0097a7;
    }

</style>
</head>
<body>
    <div class="register-container">
        <h2>Register Here</h2>
        <form action="RegisterServlet" method="POST">
            <label for="UserName">Username:</label>
            <input type="text" id="name" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="userpassword" required>

            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>
