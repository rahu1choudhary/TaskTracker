package com.tasktracker.model;

public class user {
	protected String userName;
	protected int userID;
	
	public user() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "user [userName=" + userName + ", userID=" + userID + "]";
	}
	
	
}
