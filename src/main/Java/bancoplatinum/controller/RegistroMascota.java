package bancoplatinum.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bancoplatinum.beans.Persona;
import bancoplatinum.beans.Usuario;
import bancoplatinum.model.ModeloDuenio;
import bancoplatinum.model.ModeloMascota;
import bancoplatinum.model.ModeloUsuario;

/**
 * Servlet implementation class Login
 */
public class RegistroMascota extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroMascota() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// registro mascota

		String rutDueño = request.getParameter("rutDueño");
		String tipoMascota = request.getParameter("tipoMascota");
		String edad = request.getParameter("edad");
		String nombreMascota = request.getParameter("nombreMascota");
		
		try {
			ModeloMascota modelo = new ModeloMascota();
			modelo.insert(rutDueño, tipoMascota, edad, nombreMascota);
			
			// ok
			response.sendRedirect("http://localhost:8080/BancoPlatinum/home.jsp");
			
		} catch (Exception e) {
			// err
			e.printStackTrace();
			response.sendRedirect("http://localhost:8080/BancoPlatinum/error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
