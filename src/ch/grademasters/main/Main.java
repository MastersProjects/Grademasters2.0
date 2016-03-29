package ch.grademasters.main;

import ch.grademasters.database.UserJDBCdao;
import ch.grademasters.gui.Login;

public class Main {

	public static void main(String[] args) {
//		new Login();
		UserJDBCdao data = new UserJDBCdao();
//		data.registerUser("Phong6698", "Phong", "Penglerd", "Phong@hotmail.ch", "1234");
		System.out.println(data.loginUser("Phong6698"));
		
		

	}

}
