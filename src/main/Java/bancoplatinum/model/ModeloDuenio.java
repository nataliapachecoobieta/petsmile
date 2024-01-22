package bancoplatinum.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ModeloDuenio {
	
	// registrar duenio
	
	public void insert(
			String rut, String nombre, String apellido, 
			String direccion, String correo, String telefono, String nombreMascota) {
		
		Database database = new Database();
		Connection connection = database.getConnection();

		try {
			
			String insertQuery = "INSERT INTO dueño (rut, nombre, apellido, direccion, correo, telefono, nombreMascota) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setString(1, rut);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellido);
            preparedStatement.setString(4, direccion);
            preparedStatement.setString(5, correo);
            preparedStatement.setString(6, telefono);
            preparedStatement.setString(7, nombreMascota);
            
            preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			
		}
	}
}
