package resources;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	
		private static final SessionFactory sessionFactory = buildSessionFactory();
		private static SessionFactory buildSessionFactory() {
			try {
                //Configuración a partir de hibernate.cfg.xml
				Configuration config = new Configuration();
				config.configure().addResource("\\entities\\Empleados.hbm.xml"); 
				config.configure().addResource("\\entities\\Departamentos.hbm.xml");
				ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
				// Se construye la SessionFactory
				return config.buildSessionFactory(sr);
				
			} catch (Throwable ex) {
				System.err.println("No se pudo crear la SessionFactory:" + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}

}
