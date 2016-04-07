/**
 * 
 */
package ch.grademasters.database;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import ch.grademasters.model.Exam;

/**
 * @description
 * @author luca.marti
 * @year 2016
 * @version 1.0
 */
public class ExamJDBCdao extends Database {

	public void createExam(String name, Double grade, Date date, Boolean count, int subject_id) {
		openCon();
		try {
			ps = con.prepareStatement("INSERT INTO EXAM VALUES (?,?,?,?,?,?);");

			ps.setString(1, null);
			ps.setDouble(2, grade);
			ps.setDate(3, date);
			ps.setBoolean(4, count);
			ps.setInt(5, subject_id);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}
	
	public ArrayList<Exam> getExamsBySubjectID(int subjectID){
		openCon();
		ArrayList<Exam> exams = new ArrayList<Exam>(); 
		try {
			ps = con.prepareStatement("SELECT * FROM EXAM WHERE Subject_ID = ?");			
			ps.setInt(1, subjectID);		
			rs = ps.executeQuery();
			
			while (rs.next()) {			 
				Exam exam = new Exam();
				exam.setId(rs.getInt("ID_Exam"));
				exam.setName(rs.getString("Name"));
				exam.setGrade(rs.getFloat("Grade"));
				//TODO Date
				exam.setCount(rs.getBoolean("Grade"));
				
				exams.add(exam);
			}
					      
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			closeCon();
		}
		
		return exams;
	}
}
