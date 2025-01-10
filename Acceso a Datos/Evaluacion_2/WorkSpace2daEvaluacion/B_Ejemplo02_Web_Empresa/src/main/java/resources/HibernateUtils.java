package resources;

import javax.imageio.spi.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;

public class HibernateUtils {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Se configura Hibernate a partir del archivo .cfg.xml
			Configuration config = new Configuration();
			
			//Añadimos la ruta a los hbm.xml
			config.configure().addResource("\\entities\\Empleado.hbm.xml");
			config.configure().addResource("\\entities\\Departamento.hbm.xml");
			
			//Se contruye la SessionFactory
			ServiceRegistry sr = (ServiceRegistry) new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			return (SessionFactory) config.buildSessionFactory((org.hibernate.service.ServiceRegistry) sr);
		} catch (Throwable ex) {
			System.err.println("No se pudo crear la session factory." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

}
