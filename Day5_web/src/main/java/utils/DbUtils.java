package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	private static Connection connection;
	private static final String DB_URL;
	private static final String USER_NAME;
	private static final String PASSWORD;
	static {
		DB_URL = "jdbc:mysql://localhost:3306/voters";
		USER_NAME = "root";
		PASSWORD = "Neelam@12345";
	}

	public static Connection openConnection() 
			throws /* ClassNotFoundException, */SQLException {
		// OPTIONAL : load JDBC driver
	//	Class.forName("com.mysql.cj.jdbc.Driver");
		// get conneciton form DB : mandatory!
		connection = DriverManager.getConnection
				(DB_URL, USER_NAME, PASSWORD);//fixed connectivity
		
		
		return connection;
	}
	//add a static method to close connection
	public static void closeConnection() throws SQLException{
		if(connection != null)
			connection.close();
		System.out.println("db cn closed !");
	}
}