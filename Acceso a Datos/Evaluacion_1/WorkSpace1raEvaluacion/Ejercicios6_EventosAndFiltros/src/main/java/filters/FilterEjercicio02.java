package filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet Filter implementation class FilterEjercicio02
 */
@WebFilter("/Ejercicio02")
public class FilterEjercicio02 extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FilterEjercicio02() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// Convertir la solicitud a HttpServletRequest para obtener la URL
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getRequestURI();

        Map<String, Integer> visitas = (Map<String, Integer>) getServletContext().getAttribute("visitCountMap");

        visitas.put(url, visitas.getOrDefault(url, 0) + 1);

        // Actualizar el HashMap en el contexto
        getServletContext().setAttribute("visitCountMap", visitas);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
        getServletContext().setAttribute("visitCountMap", new HashMap<String, Integer>());
	}

}
