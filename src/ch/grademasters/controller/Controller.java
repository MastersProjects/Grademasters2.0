package ch.grademasters.controller;

import ch.grademasters.database.UserJDBCdao;

public class Controller {
	private static Controller instance = new Controller();
	
	private final UserJDBCdao USER_JDBC = new UserJDBCdao();
	
	
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
	
	
}
