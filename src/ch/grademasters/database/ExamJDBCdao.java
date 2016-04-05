/**
 * 
 */
package ch.grademasters.database;

import java.sql.Date;
import java.sql.SQLException;

/**
 * @description
 * @author luca.marti
 * @year 2016
 * @version 1.0
 */
public class ExamJDBCdao extends Database {

	public void createExam(String name, Double grade, Date date, Boolean count, String subject) {
		openCon();
		try {
			ps = con.prepareStatement("INSERT INTO EXAM VALUES (?,?,?,?,?,?);");

			ps.setString(1, null);
			ps.setDouble(2, grade);
			ps.setDate(3, date);
			ps.setBoolean(4, count);
			ps.setString(5, subject);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeCon();
		}
	}
}
