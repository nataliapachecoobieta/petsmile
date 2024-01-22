import org.junit.Test;

import bancoplatinum.model.ModeloAgenda;
import bancoplatinum.model.ModeloDuenio;
import bancoplatinum.model.ModeloMascota;

public class TestAplicacion {
	
	// cada vez que se ejecute el test, se tiene que cambiar el rut del duenio
	
	private String rutDueño = "1";
	private int idMascota;
	
	@Test
	public void testRegistroDuenio() {
		ModeloDuenio modelo = new ModeloDuenio();
		modelo.insert(rutDueño, "Pedro", "Pascal", "Avda One", "mail@mail.com", "1987654", "rex");
		// insert no retorna, si no existe error, funciona bien
	}
	
	@Test
	public void testRegistroMascota() {
		ModeloMascota modelo = new ModeloMascota();
		this.idMascota = modelo.insert(rutDueño, "tipo 1", "10", "rex");
	}
	
	@Test
	public void testRegistroAgenda() {
		ModeloAgenda modelo = new ModeloAgenda();
		modelo.insert("rex", "02:23", "01/02/03", idMascota, rutDueño);
		// insert no retorna, si no existe error, funciona bien
	}
}
