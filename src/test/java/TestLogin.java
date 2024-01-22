import static org.junit.Assert.*;

import org.junit.Test;

import bancoplatinum.model.ModeloUsuario;

// crear una clase normal
public class TestLogin {

	@Test
	public void testLoginOk() {
		// datos creados anteriormente con sql 
		String nombreUsuario = "test";
		String password = "test";
		
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		boolean encontrado = modeloUsuario.read(nombreUsuario, password);
		assertTrue(encontrado); // checkeamos que ha sido encontrado, caso contrario debe arrojar un error
	}
	
	@Test
	public void testLoginErr() {
		// datos creados anteriormente con sql 
		String nombreUsuario = "noexiste";
		String password = "noexiste";
		
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		boolean encontrado = modeloUsuario.read(nombreUsuario, password);
		assertFalse(encontrado); // checkeamos que ha NO sido encontrado, caso contrario debe arrojar un error
	}
}
