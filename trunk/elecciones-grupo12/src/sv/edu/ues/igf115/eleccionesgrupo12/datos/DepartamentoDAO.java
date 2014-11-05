package sv.edu.ues.igf115.eleccionesgrupo12.datos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Departamento;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.PartidoPolitico;
import sv.edu.ues.igf115.eleccionesgrupo12.utilidades.HibernateUtil;

public class DepartamentoDAO {

	
	private HibernateUtil hibernateUtil = new HibernateUtil();
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
	private Session sesion;
	private Transaction tx;

	
	private void iniciaOperacion() throws HibernateException {
		sesion = sessionFactory.openSession();
		tx = sesion.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa DAO", he);
	}

	
	public void guardaActualiza(Departamento departamento) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(departamento);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void eliminar(Departamento departamento) {
		try {
			iniciaOperacion();
			sesion.delete(departamento);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public Departamento daDepartamentoById(String idDepartamento) {
		sesion = sessionFactory.openSession();
		Departamento departamento = (Departamento) sesion.get(
				Departamento.class, idDepartamento);
		sesion.close();
		return departamento;
	}

	public List<Departamento> daDepartamentos() {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Departamento.findAll");
		List<Departamento> departamentos = query.list();
		sesion.close();
		return departamentos;
	}

	
	public 	List<Departamento> daDepartamentoByNombre(String nomDepto) {
		sesion = sessionFactory.openSession();
		Query query = sesion
				.getNamedQuery("Departamento.findByNombreDepto");
		query.setParameter("nombDepto", nomDepto);
		
		List<Departamento> departamentos = query.list();
		//Departamento departamento = (Departamento) query.uniqueResult();
		sesion.close();
		return departamentos;
	}
	
	
}
