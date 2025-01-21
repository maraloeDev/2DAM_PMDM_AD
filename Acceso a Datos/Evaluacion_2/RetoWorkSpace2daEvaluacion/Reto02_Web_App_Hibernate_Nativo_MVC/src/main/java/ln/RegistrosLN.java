package ln;

import dao.RegistrosDAO;
import entities.Registros;

public class RegistrosLN {
	
	RegistrosDAO registroDAO = new RegistrosDAO();

	public Registros insertarRegistro(String numeroRegistro,String dniSolicitante, String nombreSolicitante, String apellidosSolicitante,
			String tramite, String entidad) {

		// Comprobar si todos los datos son correctos

		if (dniSolicitante.length() > 9) {
			System.out.println("El DNI no puede tener más de 9 caracteres");
			return null;
		} else if (nombreSolicitante.length() > 50) {
			System.out.println("El nombre no puede tener más de 50 caracteres");
			return null;
		} else if (apellidosSolicitante.length() > 100) {
			System.out.println("Los apellidos no pueden tener más de 100 caracteres");
			return null;
		} else if (tramite.length() > 100) {
			System.out.println("El trámite no puede tener más de 100 caracteres");
			return null;
		}
	
		return registroDAO.insertarRegistro(numeroRegistro, dniSolicitante, nombreSolicitante, apellidosSolicitante, tramite, entidad);
	}

	}
