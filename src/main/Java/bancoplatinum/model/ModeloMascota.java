package bancoplatinum.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ModeloMascota {
	
	// registrar mascota, retorna el id auto-incremental generado
	
	public int insert(String rutDueño, String tipoMascota, String edad, String nombreMascota) {
		
		Database database = new Database();
		Connection connection = database.getConnection();

		try {
			
			String insertQuery = "INSERT INTO mascota (rutDueño, tipoMascota, edad, nombreMascota) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setString(1, rutDueño);
            preparedStatement.setString(2, tipoMascota);
            preparedStatement.setString(3, edad);
            preparedStatement.setString(4, nombreMascota);
            
            preparedStatement.executeUpdate();
            
            // obtener el id autoincremental
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            int generatedId = generatedKeys.getInt(1);
            
            return generatedId; // retornamos el id (auto-incremental generado)
			
		} catch (Exception e) {
			return -1; // retornamos -1 cuando ocurrio un error
		}
	}
}
