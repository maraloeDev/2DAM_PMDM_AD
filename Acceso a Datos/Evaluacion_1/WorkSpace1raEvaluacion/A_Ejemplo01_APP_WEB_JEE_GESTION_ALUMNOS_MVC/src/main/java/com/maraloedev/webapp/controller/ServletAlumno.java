package com.maraloedev.webapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.maraloedev.webapp.entities.Alumno;
import com.maraloedev.webapp.ln.AlumnoLN;

/**
 * Servlet implementation class ServletAlumno
 */
public class ServletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "";
		switch (request.getParameter("boton")) {
		case "Alta":
			page = "AltaAlumno.jsp";
			break;

		case "Baja":
			page = "BajaAlumno.jsp";

			break;
		case "Actualiza":
			page = "ActualizaAlumno.jsp";

			break;
		case "consulta":
			page = "ConsultaAlumno.jsp";

			break;
		default:
			break;
		}
		request.getRequestDispatcher(page).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean error = false;
		String msj = "";
		String page = "";

		// Recogida de parámetros
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String ciclo = request.getParameter("ciclo");
		String curso = request.getParameter("curso");
		// Creación del objeto alumno
		Alumno a = new Alumno(nombre, apellidos, curso, ciclo);
		try {
			switch (request.getParameter("boton")) {
			case "Alta":
				// Llamada a la LN
				msj = AlumnoLN.alta(a);

				break;
			case "Baja":
				// Llamada a la LN
				// msj = AlumnoLN.baja(a);

				break;
			case "Actualiza":
				// Llamada a la LN
				// msj = AlumnoLN.actualiza(a);

				break;
			case "Consulta":
				// Llamada a la LN
				// msj = AlumnoLN.consulta(a);

				break;
			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			error = true;
			System.out.println("ServletAlumno: Se ha producido el siguiente error");
			e.printStackTrace();
		} finally {
			if ("Volver".equals(request.getParameter("boton"))) {
				page = "Menu.jsp";
			} else {
				if(error) {
					msj="Error al realizar la transacción.";
				}
				request.setAttribute("mensaje", msj);
				page = "Mensaje.jsp";
			}
			request.getRequestDispatcher(page).forward(request, response);
		}
	}
}