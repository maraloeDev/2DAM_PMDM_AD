package ejercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejercicio02
 */

public class Ejercicio02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().append("<!DOCTYPE html>\r\n")
            .append("<html lang=\"es\">\r\n")
            .append("<head>\r\n")
            .append("    <meta charset=\"UTF-8\">\r\n")
            .append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n")
            .append("    <title>Tablas de Multiplicar</title>\r\n")
            .append("</head>\r\n")
            .append("<body>\r\n")
            .append("<form method=\"post\" action=\"Ejercicio02_ServletDespachador\">\r\n")
            .append("    <table border=\"1\" style=\"width: 200px; text-align: center; background-color: lightblue;\">\r\n")
            .append("        <thead>\r\n")
            .append("            <tr>\r\n")
            .append("                <th colspan=\"2\" style=\"background-color: blue; color: white; font-size: 18px;\">\r\n")
            .append("                    Tablas de multiplicar\r\n")
            .append("                </th>\r\n")
            .append("            </tr>\r\n")
            .append("        </thead>\r\n")
            .append("        <tbody>\r\n")
            .append("            <tr>\r\n")
            .append("                <td colspan=\"2\" style=\"background-color: orange; font-weight: bold;\">\r\n")
            .append("                    Numero: \r\n")
            .append("                    <select name=\"tabla\" id=\"tabla\">\r\n")
            .append("                        <option value=\"\">Elige una tabla</option>\r\n")
            .append("                        <option value=\"1\">1</option>\r\n")
            .append("                        <option value=\"2\">2</option>\r\n")
            .append("                        <option value=\"3\">3</option>\r\n")
            .append("                        <option value=\"4\">4</option>\r\n")
            .append("                        <option value=\"5\">5</option>\r\n")
            .append("                        <option value=\"6\">6</option>\r\n")
            .append("                        <option value=\"7\">7</option>\r\n")
            .append("                        <option value=\"8\">8</option>\r\n")
            .append("                        <option value=\"9\">9</option>\r\n")
            .append("                        <option value=\"10\">10</option>\r\n")
            .append("                    </select>\r\n")
            .append("                </td>\r\n")
            .append("            </tr>\r\n")
            .append("            <tr>\r\n")
            .append("                <td colspan=\"2\">\r\n")
            .append("                    Elige un color para la tabla\r\n")
            .append("                </td>\r\n")
            .append("            </tr>\r\n")
            .append("            <tr>\r\n")
            .append("                <td colspan=\"2\">\r\n")
            .append("                    <input type=\"radio\" name=\"color\" value=\"black\" checked> Negro <br>\r\n")
            .append("                    <input type=\"radio\" name=\"color\" value=\"red\"> Rojo <br>\r\n")
            .append("                    <input type=\"radio\" name=\"color\" value=\"green\"> Verde <br>\r\n")
            .append("                    <input type=\"radio\" name=\"color\" value=\"blue\"> Azul <br>\r\n")
            .append("                    <input type=\"radio\" name=\"color\" value=\"orange\"> Naranja\r\n")
            .append("                </td>\r\n")
            .append("            </tr>\r\n")
            .append("            <tr>\r\n")
            .append("                <td colspan=\"2\">\r\n")
            .append("                    <input type=\"submit\" value=\"Crear\">\r\n")
            .append("                    <input type=\"reset\" value=\"Borrar\">\r\n")
            .append("                </td>\r\n")
            .append("            </tr>\r\n")
            .append("        </tbody>\r\n")
            .append("    </table>\r\n")
            .append("</form>\r\n")
            .append("</body>\r\n")
            .append("</html>\r\n");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // For now, simply redirecting to doGet as a placeholder.
        doGet(request, response);
    }
}
