package util;

import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtil {

	private static Connection mConnection;

	private static Connection getConnection() {
		if (mConnection == null) {
			String url = "jdbc:mysql://localhost:3306/myapplication";
			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				mConnection = (Connection) DriverManager.getConnection(url, "root", "99826");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mConnection;
	}
	
	public static ResultSet query(String querySql) throws SQLException {
		Statement stateMent = (Statement) getConnection().createStatement();
		return stateMent.executeQuery(querySql);
	}
	
	public static void closeConnection() {
		if (mConnection != null) {
			try {
				mConnection.close();
				mConnection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
