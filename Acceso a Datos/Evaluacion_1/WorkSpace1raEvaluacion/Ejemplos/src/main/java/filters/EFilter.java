package filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Servlet Filter implementation class EFilter
 */
// @WebFilter("/*") Es para poner filtro a todos los servlets
//@WebFilter("/Ejemplo014")
@WebFilter(urlPatterns = {"/Ejemplo014", "/Ejemplo014b"})
public class EFilter extends HttpFilter implements Filter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public EFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	/**
	 * Este metodo es invocado, cada vez que se llegue a una app compatible, Los dos
	 * primeros objetos que se le pasan son los objetos de petición y respuesta
	 * asociados a la petición del usuario
	 * 
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		StringBuilder buffer = new StringBuilder();
		
		/**
		 * Creación del mapa recogiendo los parametros
		 */
		Map<String, String[]> params = request.getParameterMap();
		
		//Recorro el mapa añadiendo al buffer la key
		for (Entry<String, String[]> entry : params.entrySet()) {
			String key = entry.getKey();
			buffer.append(key);
			buffer.append("=");
			String [] val = entry.getValue();
			for (String string : val) {
				buffer.append(string);
				buffer.append(" | ");
			}
		}
		
		System.out.println("Recibida peticion desde la IP: " + request.getRemoteAddr());
		
		if(!buffer.toString().equals("")) {
			System.out.println("La peticion tiene los parametros " + buffer);
		}
		// TODO Auto-generated method stub
		// place your code here

		//Se invoca a este metodo, cuando el filtro a terminado
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
