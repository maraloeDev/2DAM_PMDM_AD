package com.maraloedev.controlador;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import com.maraloedev.modelo.Incidencia;

/**
 * Servlet implementation class ServletIncidencia
 */
public class ServletIncidencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Integer> codigosIncidencia = new ArrayList<Integer>();
	Incidencia incidencia = new Incidencia();
	private HashMap<Integer, Incidencia> mapaListaIncidencias = new HashMap<Integer, Incidencia>();
	private static Random rndm = new Random();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIncidencia() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	mapaListaIncidencias = new HashMap<Integer, Incidencia>();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tema = request.getParameter("tema");
		String descripcion = request.getParameter("descripcion");
		
		if( (tema==null || tema.isEmpty()) || (descripcion==null || descripcion.isEmpty())) {
			request.setAttribute("Error", "(*) El tema y la descripcion son obligatorios");
			request.getRequestDispatcher("AltaIncidencia.jsp").forward(request, response);
			return;
		}
		
		codigosIncidencia = new ArrayList<Integer>();
		
		if(codigosIncidencia==null) {
			codigosIncidencia = new ArrayList<Integer>();
		}
		
		int codigo;
		
		do {
			codigo = rndm.nextInt(1,20);
		} while (codigosIncidencia.contains(codigo));
		codigosIncidencia.add(codigo);
		
		response.getWriter().append("<html>\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<form action=\"ConsultaIncidencia.jsp\" method=\"post\"> \r\n"
				+ "    La incidencia se guardo con el codigo \r\n"
				+ "    <h4 style=\"text-align: center;\">"+codigo+"</h4>\r\n"
				+ "\r\n"
				+ "    <input type=\"submit\" name=\"Consultar\" value=\"Consultar\">\r\n"
				+ "</form>\r\n"
				+ "</html>");
		
		
		Incidencia incidencia = new Incidencia(tema, descripcion);
		
		mapaListaIncidencias.put(codigo, incidencia);

		getServletContext().setAttribute("mapaIncidencias", mapaListaIncidencias);	
	}
}
