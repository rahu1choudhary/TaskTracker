Personal Task Tracker

A simple task management web application built using **JSP**, **Servlets**, and **JDBC (SQLite)**. Users can register, log in, and manage their personal tasks (add, mark as done, delete, and view).

---

##  Features

- User Registration & Login
- Add new tasks with deadline & status
- Mark tasks as completed
- Delete tasks
- Filter tasks by status (Planned for extension)
- Session-based login
- Basic HTML + CSS styled UI

---

## 🛠️ Tech Stack

- Java (JSP & Servlets)
- Maven
- SQLite (local `.db` file)
- HTML, CSS
- JSTL (for JSP looping & expressions)
- Apache Tomcat (Tested on Tomcat 10)

---

## 📁 Project Structure

personal-task-tracker/
├── src/
│ └── main/
│ ├── java/com/tasktracker/
│ │ ├── dao/
│ │ │ └── TaskDAO.java
│ │ ├── model/
│ │ │ ├── Task.java
│ │ │ └── User.java
│ │ └── servlet/
│ │ ├── DeleteTaskServlet.java
│ │ ├── LoginServlet.java
│ │ ├── LogoutServlet.java
│ │ ├── MarkDoneServlet.java
│ │ ├── RegisterServlet.java
│ │ ├── TaskServlet.java
│ │ └── ViewTasksServlet.java
│ └── webapp/
│ ├── WEB-INF/
│ ├── login.jsp
│ ├── register.jsp
│ ├── addtasks.jsp
│ ├── taskslist.jsp
│ └── NewFile.jsp
├── taskTracker.db <-- SQLite DB file
├── pom.xml <-- Maven dependencies
└── README.md


##  How to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/rahu1choudhary/TaskTracker.git
Open in Eclipse (Maven Project):

File > Import > Existing Maven Project > Select project directory

Configure Tomcat:

Set up a Tomcat server in Eclipse

Right-click project > Run As > Run on Server

Access the app:

http://localhost:8080/personal-task-tracker/
🗃️ Database
The app uses a local SQLite database (taskTracker.db). The DAO handles connections using JDBC.

No manual setup is needed — just make sure the .db file is in the root project directory.

✨ Screenshots 


![addtask](https://github.com/user-attachments/assets/85ea2aa7-27b2-4964-8b2c-850dfe237e0a)

![login](https://github.com/user-attachments/assets/486a1275-e45f-49c5-9652-22f9465eb9b0)

![tasklist](https://github.com/user-attachments/assets/6086ae5a-5fc6-4b6d-a53e-0136d78fbb28)

📌 Future Enhancements
Task filtering (by Pending/Completed)

Password hashing

Responsive UI with Bootstrap or Tailwind

Sorting by deadline

Add priority levels for tasks

