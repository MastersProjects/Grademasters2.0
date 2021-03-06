package ch.grademasters.model;

import java.util.ArrayList;

public class Subject {
	private String name;
	private int id;
	private ArrayList<Exam> exams;

	public double getAvarageGrade() {
		double avarageGrade = 0.0;

		if (exams != null) {
			double allGrades = 0.0;
			double numberOfGrades = 0.0;
			for (Exam exam : exams) {
				if (exam.isCount()) {
					allGrades = allGrades + exam.getGrade();
					numberOfGrades++;
				}
			}
			if(numberOfGrades != 0){
				avarageGrade = allGrades / numberOfGrades;
			}
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

	public ArrayList<Exam> getExams() {
		return exams;
	}

	public void setExams(ArrayList<Exam> exams) {
		this.exams = exams;
	}
}
