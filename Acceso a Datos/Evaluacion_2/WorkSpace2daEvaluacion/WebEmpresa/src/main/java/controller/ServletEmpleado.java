package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.DAODepartamentos;
import dao.DAOEmpleado;
import entities.Departamentos;
import entities.Empleados;
import logic.LNEmpleados;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEmpleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String boton = request.getParameter("boton");
		String page = "";
		
		switch (boton) {
		case "EMPLEADOS":
			page = "GestionEmpleados.jsp";
			break;
		case "DEPARTAMENTOS":
			page = "GestionDptos.jsp";
			break;
		case "Alta":
			List<Departamentos> listDptos;
			try {
				listDptos = DAODepartamentos.getALL();
				System.out.println(listDptos.size());
				request.setAttribute("listDptos", listDptos);
				page = "AltaEmpl.jsp";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "Baja":
			page = "BajaEmpl.jsp";
			break;
		case "Actualiza":
			page = "ActualizaEmpl.jsp";
			break;
		case "Listado":
			List<Empleados> listEmpl;
			try {
				listEmpl = DAOEmpleado.getALL();
				request.setAttribute("listEmpl", listEmpl);
				page = "ConsultaEmpl.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		request.getRequestDispatcher(page).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String boton = request.getParameter("boton");
		boolean error = false;
		String mensaje = "";
		try {
			Empleados e = new Empleados();
			e.setNombre(request.getParameter("nombre"));
			e.setApellido(request.getParameter("apellidos"));
			e.setOficio(request.getParameter("oficio"));
			e.setSalario(Integer.parseInt(request.getParameter("salario")));
			if (request.getParameter("dpto") != null) {
				Departamentos d = new Departamentos();
				d.setDepNo(Integer.valueOf(request.getParameter("dpto")));
				e.setDepartamentos(d);
			}
			switch (boton) {
			case "Alta":
				mensaje = LNEmpleados.alta(e);
				break;
			case "Baja":
				mensaje = LNEmpleados.baja(e);
				break;
			case "Actualizar":
				mensaje = LNEmpleados.actualiza(e);
				break;
			default:
				break;
			}

		} catch (Exception ex) {
			error = true;
			System.err.println("ServletEmpleado:Se ha producido el siguiene error");
			ex.printStackTrace();
		} finally {
			if (error) {
				mensaje = "Error al realizar" + boton;
			}
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("mensaje.jsp").forward(request, response);
		}
	}

}
