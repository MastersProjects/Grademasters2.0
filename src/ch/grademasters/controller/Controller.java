package ch.grademasters.controller;

import java.sql.Date;
import java.util.ArrayList;

import ch.grademasters.database.ExamJDBCdao;
import ch.grademasters.database.SemesterJDBCdao;
import ch.grademasters.database.SubjectJDBCdao;
import ch.grademasters.database.UserJDBCdao;
import ch.grademasters.model.Exam;
import ch.grademasters.model.Semester;
import ch.grademasters.model.Subject;
import ch.grademasters.model.User;

public class Controller {
	private static Controller instance = new Controller();
	
	private final UserJDBCdao USER_JDBC = new UserJDBCdao();
	private final SemesterJDBCdao SEMESTER_JDBC = new SemesterJDBCdao();
	private final SubjectJDBCdao SUBJECT_JDBC = new SubjectJDBCdao();
	private final ExamJDBCdao EXAM_JDBC = new ExamJDBCdao();
	
	
	private Controller() {
	}
	
	public static Controller getInstance(){
		return instance;
	}
	
	public void registerUser(String username, String firstname, String lastname, String email, String password, String password2){
	
		USER_JDBC.registerUser(username, firstname, lastname, email, password);
	}
	
	public boolean loginUser(String username, String password){
		//TODO Login Validations
		boolean login = false;
		if(password.equals(USER_JDBC.loginUser(username))){
			login = true;
		}else{
			login = false;
		}
		return login;	
	}
	
	public User getUserInfos(String username){
		User user = new User();
		user.setUsername(username);
		ArrayList<Semester> semesters = SEMESTER_JDBC.getSemestersByUsername(username); //Semsters
		for(Semester semester : semesters){
			ArrayList<Subject> subjects = SUBJECT_JDBC.getSubjectsBySemesterID(semester.getId()); //Subjects
			for(Subject subject : subjects){
				ArrayList<Exam> exams = EXAM_JDBC.getExamsBySubjectID(subject.getId());
				subject.setExams(exams);
			}
			semester.setSubjects(subjects);
		}
		user.setSemesters(semesters);
		
		return user;
	}
	
	public void createSemester(String name, String school, String username){
		SEMESTER_JDBC.createSemester(name, school, username);
	}
	
	public void createSubject(String name, String school, int subject_id){
		SUBJECT_JDBC.createSubject(name, school, subject_id);
	}
	
	public void createExam(String name, Double grade, Date date, Boolean count, int subject_id){
		EXAM_JDBC.createExam(name, grade, date, count, subject_id);
	}

	public ArrayList<String> getAllUser() {
		return USER_JDBC.getAllUser();
	}
	
	
}
