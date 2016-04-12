package ch.grademasters.database;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserJDBCdao extends Database{
	
	public void registerUser(String username, String firstname, String lastname, String email, String password){
		openCon();
		try {
			ps = con.prepareStatement("INSERT INTO USER VALUES (?,?,?,?,?)");
			
			ps.setString(1, username);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setString(4, email);
			ps.setString(5, password);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeCon();
		}	
	}
	
	public String loginUser(String username){
		openCon();
		String password = null;
		try {
			ps = con.prepareStatement("SELECT * FROM USER WHERE Username = ?");			
			ps.setString(1, username);		
			rs = ps.executeQuery();
			
			while (rs.next()) {			 
			      password = rs.getString("Password");
			}
					      
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			closeCon();
		}
		return password;		
	}

	public ArrayList<String> getAllUser() {
		openCon();
		ArrayList<String> users = new ArrayList<String>();
		try {
			ps = con.prepareStatement("SELECT * FROM USER");			
			rs = ps.executeQuery();
			
			while (rs.next()) {			 
			      users.add(rs.getString("Username"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			closeCon();
		}
		return users;
	
	}

}
