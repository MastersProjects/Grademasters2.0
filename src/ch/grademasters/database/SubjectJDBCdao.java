/**
 * 
 */
package ch.grademasters.database;

import java.sql.SQLException;

/**
 * @description
 * @author elia.perenzin, phong.penglerd, luca.marti
 * @year 2016
 * @version 1.0
 */
public class SubjectJDBCdao extends Database{

	public void createSubject(String name, String school, String username){
		openCon();
		try{
			ps = con.prepareStatement("INSERT INTO SUBJECT VALUES(?,?,?,?);");
			
			ps.setString(1, null);
			ps.setString(2, name);
			ps.setString(3, school);
			ps.setString(4, username);
			
			ps.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}
	
}
