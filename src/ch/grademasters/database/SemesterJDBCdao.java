package ch.grademasters.database;

import java.sql.SQLException;
import java.util.ArrayList;

import ch.grademasters.model.Semester;

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
	
	public ArrayList<Semester> getSemestersByUsername(String username){
		openCon();
		ArrayList<Semester> semesters = new ArrayList<Semester>(); 
		try {
			ps = con.prepareStatement("SELECT * FROM SEMESTER WHERE Username = ?");			
			ps.setString(1, username);		
			rs = ps.executeQuery();
			
			while (rs.next()) {			 
				Semester semester = new Semester();
				semester.setId(rs.getInt("ID_Semester"));
				semester.setName(rs.getString("Name"));
				semester.setSchool(rs.getString("School"));
				
				semesters.add(semester);
			}
					      
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			closeCon();
		}
		
		return semesters;
		
	}
	
}
