package ch.grademasters.main;

import ch.grademasters.database.UserJDBCdao;

public class Main {

	public static void main(String[] args) {
		UserJDBCdao data = new UserJDBCdao();
		data.registerUser("test", "test", "test", "test", "test");

	}

}
