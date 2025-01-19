

package dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Departamentos;
import entities.Empleados;
import resources.HibernateUtils;

public class DAOEmpleado {
	public static void insert(Empleados e) throws Exception {
		Transaction tr = null;
		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();
			sesion.save(e);
			tr.commit();
		
		} catch (Exception ex) {
			if (tr != null) {
				tr.rollback();
			}
			throw new Exception("DAOEmpleado: Error al realizar la inserción del empleado en la base de datos.");
			//ex.printStackTrace();
		}

	}

	public static void delete(Empleados e) throws Exception {

		Transaction tr = null;
		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();
			sesion.delete(e);
			tr.commit();
		} catch (Exception ex) {
			if (tr != null) {
				tr.rollback();
			}
			ex.printStackTrace();
		}

	}

	@SuppressWarnings("finally")
	public static List<Empleados> getALL() throws Exception {

		Transaction tr = null;
		List<Empleados> empleados = null;

		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();
			CriteriaQuery<Empleados> consulta = sesion.getCriteriaBuilder().createQuery(Empleados.class);
			consulta.from(Empleados.class);
			empleados = sesion.createQuery(consulta).getResultList();
			tr.commit();
		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
		} finally {
			return empleados;
		}

	}

	@SuppressWarnings("finally")
	public static List<Empleados> selectByDpto(Departamentos d) {

		Transaction tr = null;
		List<Empleados> empleados = null;
		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();
			System.out.println("entra listaEmpleados");
			CriteriaQuery<Empleados> consulta = sesion.getCriteriaBuilder().createQuery(Empleados.class);
			Root<Empleados> root = consulta.from(Empleados.class);
			consulta.where(sesion.getCriteriaBuilder().equal(root.get("departamentos").get("depNo"), d.getDepNo()));
			empleados = sesion.createQuery(consulta).getResultList();
			System.out.println(empleados);
			tr.commit();
			System.out.println(empleados.size());

		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();
		} finally {
			return empleados;
		}

	}

	public static void update(Empleados e) throws Exception {

		Transaction tr = null;
		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();
			sesion.update(e);// Se modifican los datos
			tr.commit();
		} catch (Exception ex) {
			if (tr != null) {
				tr.rollback();
			}
			throw new Exception("DAOEmpleado: Error al realizar la actualización del empleado en la base de datos.");
			//ex.printStackTrace();
		}

	}

	@SuppressWarnings("finally")
	public static Empleados select(Empleados e) throws Exception {

		Empleados empl = null;
		Transaction tr = null;
		try (Session sesion = HibernateUtils.getSessionFactory().openSession();) {
			tr = sesion.beginTransaction();
			CriteriaQuery<Empleados> consulta = sesion.getCriteriaBuilder().createQuery(Empleados.class);
			consulta.from(Empleados.class);
			List<Empleados> empleados = sesion.createQuery(consulta).getResultList();
			tr.commit();
			for (Empleados empleado : empleados) {
				if (empleado.getNombre().equalsIgnoreCase(e.getNombre())
						&& (empleado.getApellido()).equalsIgnoreCase(e.getApellido())) {
					empl = empleado;
				}

			}

		} catch (Exception ex) {
			if (tr != null) {
				tr.rollback();
			}
			ex.printStackTrace();
		} finally {
			return empl;
		}

	}
}
