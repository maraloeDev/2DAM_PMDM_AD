package ln;

import java.sql.SQLException;

import dao.RegistrosDAO;
import entities.Registros;

public class RegistrosLN {

	RegistrosDAO registroDAO = new RegistrosDAO();

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

		// Llamamos al método DAO para insertar el registro
		try {
			return registroDAO.insertarRegistro(numeroRegistro, dniSolicitante, nombreSolicitante, apellidosSolicitante,
					tramite, entidad);
		} catch (Exception e) {
			// Manejar cualquier excepción que se produzca en la capa DAO
			
			throw new Exception(e.getMessage());

		}
	}
}
