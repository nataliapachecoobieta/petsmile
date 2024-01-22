package bancoplatinum.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import bancoplatinum.beans.Usuario;

public class ModeloUsuario {
	
	public boolean read(String nombreUsuario, String password) {
		Database database = new Database();
		Connection connection = database.getConnection();
		
		boolean encontrado = false;
		
		try {
			Statement statement = connection.createStatement();
			
			String query = String.format("select nombreUsuario, password from usuario where nombreUsuario='%s' and password='%s'", nombreUsuario, password);

			ResultSet rs = statement.executeQuery(query);
			
			boolean found = rs.next();
		
			encontrado = found;
			
		} catch (Exception e) {
			encontrado = false;
		}
		
		return encontrado;
	}
}
