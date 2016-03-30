package ch.grademasters.model;

import java.util.ArrayList;

public class Subject {
	private String name;
	private int id;
	private ArrayList<Exam> exams;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Exam> getExams() {
		return exams;
	}
	public void setExams(ArrayList<Exam> exams) {
		this.exams = exams;
	}
}
