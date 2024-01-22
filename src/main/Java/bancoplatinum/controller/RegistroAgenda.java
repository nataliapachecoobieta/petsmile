package bancoplatinum.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bancoplatinum.beans.Persona;
import bancoplatinum.beans.Usuario;
import bancoplatinum.model.ModeloAgenda;
import bancoplatinum.model.ModeloDuenio;
import bancoplatinum.model.ModeloMascota;
import bancoplatinum.model.ModeloUsuario;

/**
 * Servlet implementation class Login
 */
public class RegistroAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroAgenda() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// registro agenda

		String nombreMascota = request.getParameter("nombreMascota");
		String hora = request.getParameter("hora");
		String fecha = request.getParameter("fecha"); 
		
		String idMascotaString = request.getParameter("idMascota");
		int idMascota = Integer.parseInt(idMascotaString); 
		
		String rutDueño = request.getParameter("rutDueño");
		
		try {
			ModeloAgenda modelo = new ModeloAgenda();
			modelo.insert(nombreMascota, hora, fecha, idMascota, rutDueño);
			
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
