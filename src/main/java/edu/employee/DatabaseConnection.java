package edu.employee;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/employee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String CONNECTION_USERNAME = "root";
	private static final String CONNECTION_PASSWORD = "rupenman"; static Connection conn = null;

	private DatabaseConnection() {

	}

	public static Connection getDBConnection() {

		try {
			if (conn == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return conn;
	}

}
