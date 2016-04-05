/**
 * 
 */
package ch.grademasters.database;

import java.sql.SQLException;
import java.util.ArrayList;

import ch.grademasters.model.Subject;

/**
 * @description
 * @author elia.perenzin, phong.penglerd, luca.marti
 * @year 2016
 * @version 1.0
 */
public class SubjectJDBCdao extends Database{

	public void createSubject(String name, String school, int semester_id){
		openCon();
		try{
			ps = con.prepareStatement("INSERT INTO SUBJECT VALUES(?,?,?,?);");
			
			ps.setString(1, null);
			ps.setString(2, name);
			ps.setString(3, school);
			ps.setInt(4, semester_id);
			
			ps.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}
	
	public ArrayList<Subject> getSubjectsBySemesterID(int semesterID){
		openCon();
		ArrayList<Subject> subjects = new ArrayList<Subject>(); 
		try {
			ps = con.prepareStatement("SELECT * FROM SUBJECT WHERE Semester_ID = ?");			
			ps.setInt(1, semesterID);		
			rs = ps.executeQuery();
			
			while (rs.next()) {			 
				Subject subject = new Subject();
				subject.setId(rs.getInt("ID_Subject"));
				subject.setName(rs.getString("Name"));
				
				subjects.add(subject);
			}
					      
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			closeCon();
		}
		
		return subjects;
	}
	
}
