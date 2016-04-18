package ch.grademasters.model;

import java.util.ArrayList;

public class Semester {
	private String name;
	private int id;
	private String school;
	private ArrayList<Subject> subjects;

	public Double getAvarageGrade() {
		double avarageGrade = 0;

		if (subjects != null) {
			double allGrades = 0;
			double numberOfGrades = 0;
			for (Subject subject : subjects) {
				allGrades = allGrades + subject.getAvarageGrade();
				numberOfGrades++;
			}
			avarageGrade = allGrades / numberOfGrades;
		}

		return avarageGrade;
	}

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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}
}
