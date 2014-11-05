package sv.edu.ues.igf115.eleccionesgrupo12.datos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.eleccionesgrupo12.dominio.MiembroJRV;
import sv.edu.ues.igf115.eleccionesgrupo12.utilidades.HibernateUtil;

public class MiembroJRVDAO {

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

	public void guardaActualiza(MiembroJRV miembroJRV) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(miembroJRV);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void eliminar(MiembroJRV miembroJRV) {
		try {
			iniciaOperacion();
			sesion.delete(miembroJRV);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public MiembroJRV daMiembroJRVById(String idMiembroJRV) {
		sesion = sessionFactory.openSession();
		MiembroJRV miembroJRV = (MiembroJRV) sesion.get(MiembroJRV.class, idMiembroJRV);
		sesion.close();
		return miembroJRV;
	}

	public List<MiembroJRV> daMiembroJRVs() {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("MiembroJRVs.findAll");
		List<MiembroJRV> miembroJRVs = query.list();
		sesion.close();
		return miembroJRVs;
	}

	public MiembroJRV daMiembroJRVByNombre(String nombreMiembroJRV) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("MiembroJRV.findByNombreMiembroJRV");
		query.setParameter("nombreMiembroJRV", nombreMiembroJRV);
		MiembroJRV miembroJRV = (MiembroJRV) query.uniqueResult();
		sesion.close();
		return miembroJRV;
	}
}
