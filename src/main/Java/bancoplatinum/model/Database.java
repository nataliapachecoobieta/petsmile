package bancoplatinum.model;

import java.sql.Connection;
import java.sql.DriverManager;
public class Database {

	Connection connection = null;

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/petsmile", "root", "admin");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}
}
