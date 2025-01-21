package dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import utils.HibernateUtils;

public class PreinscripcionesDAO {

	public static void insert(entities.Preinscripciones p) {
		try(Session sesion = HibernateUtils.getSessionFactory().openSession()) {
			Transaction tr = sesion.beginTransaction();
			sesion.save(p);
			tr.commit();
		}
	}
	public static void delete(entities.Preinscripciones p) throws Exception {

		Transaction tr = null;
		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();
			sesion.delete(p);
			tr.commit();
		}

	}
	public static void update(entities.Preinscripciones p) throws Exception {
		Transaction tr = null;
		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();
			sesion.update(p);
			tr.commit();
		}
	}

	public static entities.Preinscripciones select(entities.Preinscripciones p) throws Exception {

		Transaction tr = null;
		entities.Preinscripciones preinsc=null;
		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();
			//Get permite recuperar el registro de inmediato y recoge null si no existe 
			preinsc=sesion.get(entities.Preinscripciones.class,p.getDni());
			tr.commit();
			return preinsc;
		}

	}
	
	public static List<entities.Preinscripciones> getAll() {
		try(Session sesion = HibernateUtils.getSessionFactory().openSession()) {
			Transaction tr = sesion.beginTransaction();
			JpaCriteriaQuery<entities.Preinscripciones> consulta = sesion.getCriteriaBuilder().createQuery(entities.Preinscripciones.class);
			consulta.from(entities.Preinscripciones.class);
			List<entities.Preinscripciones> listaPreinsc = sesion.createQuery(consulta).getResultList();
			tr.commit();
			return listaPreinsc;
		}
	}
	
}
