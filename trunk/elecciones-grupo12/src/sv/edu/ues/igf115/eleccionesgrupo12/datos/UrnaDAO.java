package sv.edu.ues.igf115.eleccionesgrupo12.datos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Urna;
import sv.edu.ues.igf115.eleccionesgrupo12.utilidades.HibernateUtil;

public class UrnaDAO {

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

	public void guardaActualiza(Urna urna) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(urna);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void eliminar(Urna urna) {
		try {
			iniciaOperacion();
			sesion.delete(urna);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public Urna daUrnaById(String idUrna) {
		sesion = sessionFactory.openSession();
		Urna urna = (Urna) sesion.get(Urna.class, idUrna);
		sesion.close();
		return urna;
	}

	public List<Urna> daUrnas() {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Urnas.findAll");
		List<Urna> urnas = query.list();
		sesion.close();
		return urnas;
	}

	public Urna daUrnaByNombre(String nombreUrna) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Urna.findByNombreUrna");
		query.setParameter("nombreUrna", nombreUrna);
		Urna urna = (Urna) query.uniqueResult();
		sesion.close();
		return urna;
	}
}
