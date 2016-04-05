package ch.grademasters.main;

import java.util.ArrayList;

import ch.grademasters.gui.Grademasters;
import ch.grademasters.gui.Login;
import ch.grademasters.model.Semester;
import ch.grademasters.model.Subject;
import ch.grademasters.model.User;

public class Main {

	public static void main(String[] args) {
		new Login();
//		UserJDBCdao data = new UserJDBCdao();
//		data.registerUser("Phong6698", "Phong", "Penglerd", "Phong@hotmail.ch", "1234");
//		System.out.println(data.loginUser("Phong6698"));
		
//		Controller.getInstance().registerUser("UsernameT1", "FirstnameT1", "LastnameT1", "EmailT1@EmailT1.ch", "PasswordT1");
//		
//		System.out.println("Wrong Login: "+Controller.getInstance().loginUser("UsernameT1", "FalsePasswordT1"));
//		System.out.println("Right Login: "+Controller.getInstance().loginUser("UsernameT1", "PasswordT1"));
//		
//		Controller.getInstance().createSemester("NameT1", "SchoolT1", "UsernameT1");
		

		/*
		 * Test Datas for no DB Connection
		 */
		Subject subject1 = new Subject();
		subject1.setId(1);
		subject1.setName("Fach1");
		Subject subject2 = new Subject();
		subject2.setId(1);
		subject2.setName("Fach2");
		Subject subject3 = new Subject();
		subject3.setId(1);
		subject3.setName("Fach3");
		Subject subject4 = new Subject();
		subject4.setId(1);
		subject4.setName("Fach4");
		
		ArrayList<Subject> subjects1 = new ArrayList<Subject>();
		subjects1.add(subject1);
		subjects1.add(subject2);
		ArrayList<Subject> subjects2 = new ArrayList<Subject>();
		subjects2.add(subject3);
		ArrayList<Subject> subjects3 = new ArrayList<Subject>();
		subjects3.add(subject4);
		
		Semester semester1 = new Semester();
		semester1.setId(1);
		semester1.setName("Semester1");
		semester1.setSchool("School1");
		semester1.setSubjects(subjects1);
		
		Semester semester2 = new Semester();		
		semester2.setId(2);
		semester2.setName("Semester2");
		semester2.setSchool("School2");
		semester2.setSubjects(subjects2);
		
		Semester semester3 = new Semester();		
		semester3.setId(2);
		semester3.setName("Semester3");
		semester3.setSchool("School3");
		semester3.setSubjects(subjects3);
		
		ArrayList<Semester> semesters = new ArrayList<Semester>();
		semesters.add(semester1);
		semesters.add(semester2);
		semesters.add(semester3);
		
		User user = new User();
		user.setSemesters(semesters);
		user.setUsername("HansNötig");
		
		new Grademasters(user);

	}

}
