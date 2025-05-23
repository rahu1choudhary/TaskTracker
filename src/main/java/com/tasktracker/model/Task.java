package com.tasktracker.model;

public class Task {
	protected String title;
	protected String deadLine;
	protected String status;
	protected int ID;
	protected int userID;
	
	public Task() {
		
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public void setDeadLine(String deadline) {
		this.deadLine=deadline;
	}
	
	public void setStatus(String status) {
		this.status=status;
	}
	
	public void setID(int id) {
		this.ID=id;
	}
	
	public void setUserID(int userID) {
		this.userID=userID;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDeadLine() {
		return this.deadLine;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public int getUserID() {
		 return this.userID;
	}
	@Override
	public String toString() {
		return "Task [title=" + title + ", deadLine=" + deadLine + ", status=" + status + ", ID=" + ID + ", userID="
				+ userID + "]";
	}
	
	
	
}
