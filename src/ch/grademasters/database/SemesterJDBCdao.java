package ch.grademasters.database;

import java.sql.SQLException;

public class SemesterJDBCdao extends Database{

	public void createSemester(String name, String school, String username){
		openCon();
		try {
			ps = con.prepareStatement("INSERT INTO SEMESTER VALUES (?,?,?,?)");
			
			ps.setString(1, null);
			ps.setString(2, name);
			ps.setString(3, school);
			ps.setString(4, username);

			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeCon();
		}	
	}
	
}
