
package ejercicios;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Servlet implementation class Ejercicio02_ServletDespachador
 */
public class Ejercicio02_ServletDespachador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejercicio02_ServletDespachador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		response.getWriter().append("<!DOCTYPE html>\r\n" + "<html lang=\"es\">\r\n" + "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Tablas de Multiplicar</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "<form method=\"post\" action=\"Ejercicio02_ServletDespachador\">\r\n"
				+ "    <table border=\"1\" style=\"width: 200px; text-align: center; background-color: lightblue;\">\r\n"
				+ "        <thead>\r\n" + "            <tr>\r\n"
				+ "                <th colspan=\"2\" style=\"background-color: blue; color: white; font-size: 18px;\">\r\n"
				+ "                    Tablas de multiplicar\r\n" + "                </th>\r\n"
				+ "            </tr>\r\n" + "        </thead>\r\n" + "        <tbody>\r\n" + "            <tr>\r\n"
				+ "                <td colspan=\"2\" style=\"background-color: orange; font-weight: bold;\">\r\n"
				+ "                    Numero: \r\n" + "                    <select name=\"tabla\" id=\"tabla\">\r\n"
				+ "                        <option value=\"\">Elige una tabla</option>\r\n"
				+ "                        <option value=\"1\">1</option>\r\n"
				+ "                        <option value=\"2\">2</option>\r\n"
				+ "                        <option value=\"3\">3</option>\r\n"
				+ "                        <option value=\"4\">4</option>\r\n"
				+ "                        <option value=\"5\">5</option>\r\n"
				+ "                        <option value=\"6\">6</option>\r\n"
				+ "                        <option value=\"7\">7</option>\r\n"
				+ "                        <option value=\"8\">8</option>\r\n"
				+ "                        <option value=\"9\">9</option>\r\n"
				+ "                        <option value=\"10\">10</option>\r\n" + "                    </select>\r\n"
				+ "                </td>\r\n" + "            </tr>\r\n" + "            <tr>\r\n"
				+ "                <td colspan=\"2\">\r\n" + "                    Elige un color para la tabla\r\n"
				+ "                </td>\r\n" + "            </tr>\r\n" + "            <tr>\r\n"
				+ "                <td colspan=\"2\">\r\n"
				+ "                    <input type=\"radio\" name=\"color\" value=\"black\" checked> Negro <br>\r\n"
				+ "                    <input type=\"radio\" name=\"color\" value=\"red\"> Rojo <br>\r\n"
				+ "                    <input type=\"radio\" name=\"color\" value=\"green\"> Verde <br>\r\n"
				+ "                    <input type=\"radio\" name=\"color\" value=\"blue\"> Azul <br>\r\n"
				+ "                    <input type=\"radio\" name=\"color\" value=\"orange\"> Naranja\r\n"
				+ "                </td>\r\n" + "            </tr>\r\n" + "            <tr>\r\n"
				+ "                <td colspan=\"2\">\r\n"
				+ "                    <input type=\"submit\" value=\"Crear\">\r\n"
				+ "                    <input type=\"reset\" value=\"Borrar\">\r\n" + "                </td>\r\n"
				+ "            </tr>\r\n" + "        </tbody>\r\n" + "    </table>\r\n" + "</form>\r\n" + "</body>\r\n"
				+ "</html>\r\n");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Almaceno el colorElegido por el usuario y la tabla seleccionada
					String colorElegido[] = request.getParameterValues("color");
					String tablaElegida[] = request.getParameterValues("tabla");
			
			if(tablaElegida == null  || tablaElegida[0].isEmpty()) {
				RequestDispatcher elDespachoMalo = request.getRequestDispatcher("Ejercicio02_ServletError");
				getServletContext().setAttribute("mensajeError", "No has elegido ninguna tabla. Elige una tabla por favor");
				elDespachoMalo.forward(request, response);
			} else {
				RequestDispatcher esteEsElBueno = request.getRequestDispatcher("Ejercicio02_ServletTablas");
				
				for(String laTabla : tablaElegida) {
					getServletContext().setAttribute("ElNumero", laTabla);
				}
				
				for(String color : colorElegido) {
					getServletContext().setAttribute("colorTable", color);
				}
				
				esteEsElBueno.forward(request, response);
			}
		}
	}