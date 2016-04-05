package ch.grademasters.controller;

import java.sql.Date;

import ch.grademasters.database.ExamJDBCdao;
import ch.grademasters.database.SemesterJDBCdao;
import ch.grademasters.database.SubjectJDBCdao;
import ch.grademasters.database.UserJDBCdao;

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
	
	public void registerUser(String username, String firstname, String lastname, String email, String password){
		//TODO Register Validation
		USER_JDBC.registerUser(username, firstname, lastname, email, password);
	}
	
	public boolean loginUser(String username, String password){
		//TODO Login Validations
		boolean login = false;
		if(password.equals(USER_JDBC.loginUser(username))){
			login = true;
		}else{
			login = false;
			//TODO JDialog 
		}
		
		return login;	
	}
	
	public void createSemester(String name, String school, String username){
		SEMESTER_JDBC.createSemester(name, school, username);
	}
	
	public void createSubject(String name, String school, String username){
		SUBJECT_JDBC.createSubject(name, school, username);
	}
	
	public void createExam(String name, Double grade, Date date, Boolean count, String subject){
		EXAM_JDBC.createExam(name, grade, date, count, subject);
	}
	
	
}
