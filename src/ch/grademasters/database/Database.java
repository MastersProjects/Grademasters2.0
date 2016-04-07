package ch.grademasters.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Database {
	
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	private final String DB_URL = "jdbc:mysql://localhost/Grademasters";
	private final String USER = "root";
	private final String PASS = "";
	
	protected Connection con = null;
	protected Statement stmt = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	
	public void openCon(){
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Datenbank wurde nicht gefunden", "Network Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void closeCon(){
		try {
			if(con != null){
				con.close();
			}else if(stmt != null){
				stmt.close();
			}else if(ps != null){
				ps.close();
			}else if(rs != null){
				rs.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
