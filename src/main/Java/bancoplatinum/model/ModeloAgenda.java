package bancoplatinum.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ModeloAgenda {
	
	// registrar agenda
	
	public void insert(
			String nombreMascota, String hora, String fecha, int idMascota, 
			String rutDueño) {
		
		Database database = new Database();
		Connection connection = database.getConnection();

		try {
			
			String insertQuery = "INSERT INTO agenta (nombreMascota, hora, fecha, idMascota, rutDueño) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setString(1, nombreMascota);
            preparedStatement.setString(2, hora);
            preparedStatement.setString(3, fecha);
            preparedStatement.setInt(4, idMascota); // id de mascota es un int
            preparedStatement.setString(5, rutDueño);
            
            preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// error, no hacemos nada por ahora
		}
	}
}
