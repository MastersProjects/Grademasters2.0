package ch.grademasters.main;

import ch.grademasters.gui.Grademasters;
import ch.grademasters.gui.Login;

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
		
		new Grademasters();

	}

}
