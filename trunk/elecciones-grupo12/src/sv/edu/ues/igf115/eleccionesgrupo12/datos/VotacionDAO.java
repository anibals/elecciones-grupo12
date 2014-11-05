package sv.edu.ues.igf115.eleccionesgrupo12.datos;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Departamento;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Votacion;
import sv.edu.ues.igf115.eleccionesgrupo12.utilidades.HibernateUtil;

public class VotacionDAO {
	
	
	
	
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

	
	public void guardaActualiza(Votacion votacion) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(votacion);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void eliminar(Votacion votacion) {
		try {
			iniciaOperacion();
			sesion.delete(votacion);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public Votacion daVotacionById(BigDecimal idvotacion) {
		sesion = sessionFactory.openSession();
		Votacion votacion = (Votacion) sesion.get(
				Votacion.class, idvotacion);
		sesion.close();
		return votacion;
	}

	public List<Votacion> daVotacion() {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Votacion.findAll");
		List<Votacion> votaciones = query.list();
		sesion.close();
		return votaciones;
	}

	
	

}
