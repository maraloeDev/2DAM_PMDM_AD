package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Departamentos;
import resources.HibernateUtils;

public class DAODepartamentos {
	public static List<Departamentos> getALL() throws Exception {

		Transaction tr = null;
		List<Departamentos> dptos=null;
		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();
			CriteriaQuery<Departamentos> consulta = sesion.getCriteriaBuilder().createQuery(Departamentos.class);
			consulta.from(Departamentos.class);
			dptos = sesion.createQuery(consulta).getResultList();
			tr.commit();
			return dptos;
	
		} 
	}
		public static void insert(Departamentos d) throws Exception {
			Transaction tr = null;
			try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
				tr = sesion.beginTransaction();
				sesion.save(d);
				tr.commit();
			} catch (Exception ex) {
				if (tr != null) {
					tr.rollback();
				}
				throw new Exception("DAOEmpleado: Error al realizar la actualización del empleado en la base de datos.");
				//ex.printStackTrace();
			}

		}

		public static void delete(Departamentos d) throws Exception {

			Transaction tr = null;
			try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
				tr = sesion.beginTransaction();
				sesion.delete(d);
				tr.commit();
			} catch (Exception ex) {
				if (tr != null) {
					tr.rollback();
				}
				throw new Exception("DAOEmpleado: Error al realizar la actualización del empleado en la base de datos.");
				//ex.printStackTrace();
			}

		}
		public static Departamentos selectId(Departamentos d) throws Exception {

			Transaction tr = null;
			Departamentos dpto=null;
			try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
				tr = sesion.beginTransaction();
				//Get permite recuperar el registro de inmediato y recoge null si no existe 
				dpto=sesion.get(Departamentos.class,d.getDepNo());
				
				
				tr.commit();
				
			} catch (Exception ex) {
				if (tr != null) {
					tr.rollback();
				}
				ex.printStackTrace();
			} finally {
				return dpto;
			}


		}
		public static void update(Departamentos d) throws Exception {
			Transaction tr = null;
			try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
				tr = sesion.beginTransaction();
				sesion.update(d);
				tr.commit();
			} catch (Exception ex) {
				if (tr != null) {
					tr.rollback();
				}
				throw new Exception("DAOEmpleado: Error al realizar la actualización del empleado en la base de datos.");
				//ex.printStackTrace();
			}
		}


	

}
