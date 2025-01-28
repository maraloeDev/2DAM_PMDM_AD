package ln;

import java.sql.SQLException;

import dao.RegistrosDAO;
import entities.Registros;

public class RegistrosLN {

	//Creo un objeto de la clase RegistrosDAO para poder llamar a sus métodos
	RegistrosDAO registroDAO = new RegistrosDAO();

	/**
	 * Método que inserta un registro en la base de datos
	 * y comprueba que los datos sean correctos, 
	 * intenta llamar al método insertarRegistro de la clase RegistrosDAO para insertar el registro
	 * 
	 */
	public Registros insertarRegistro(String numeroRegistro, String dniSolicitante, String nombreSolicitante,
			String apellidosSolicitante, String tramite, String entidad) throws Exception {

		// Comprobar si todos los datos son correctos
		if (dniSolicitante == null || dniSolicitante.length() > 9) {
			System.out.println("El DNI no puede ser nulo ni tener más de 9 caracteres.");
			return null;
		} else if (nombreSolicitante == null || nombreSolicitante.length() > 50) {
			System.out.println("El nombre no puede ser nulo ni tener más de 50 caracteres.");
			return null;
		} else if (apellidosSolicitante == null || apellidosSolicitante.length() > 100) {
			System.out.println("Los apellidos no pueden ser nulos ni tener más de 100 caracteres.");
			return null;
		} else if (tramite == null || tramite.length() > 100) {
			System.out.println("El trámite no puede ser nulo ni tener más de 100 caracteres.");
			return null;
		}

		try {
			return registroDAO.insertarRegistro(numeroRegistro, dniSolicitante, nombreSolicitante, apellidosSolicitante,
					tramite, entidad);
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());

		}
	}
}
