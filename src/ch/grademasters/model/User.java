package ch.grademasters.model;

import java.util.ArrayList;

public class User {
	private String username;
	private ArrayList<Semester> semesters;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ArrayList<Semester> getSemesters() {
		return semesters;
	}
	public void setSemesters(ArrayList<Semester> semesters) {
		this.semesters = semesters;
	}
	
}
