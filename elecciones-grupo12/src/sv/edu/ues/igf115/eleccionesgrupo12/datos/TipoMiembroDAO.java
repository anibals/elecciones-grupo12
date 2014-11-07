package sv.edu.ues.igf115.eleccionesgrupo12.datos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Departamento;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.PartidoPolitico;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.TipoMiembro;
import sv.edu.ues.igf115.eleccionesgrupo12.utilidades.HibernateUtil;

public class TipoMiembroDAO {

	

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

	
	public void guardaActualiza(TipoMiembro tipomiembro) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(tipomiembro);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void eliminar(TipoMiembro tipomiembro) {
		try {
			iniciaOperacion();
			sesion.delete(tipomiembro);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public TipoMiembro daTipoMimbroById(String idTipoMiembro) {
		sesion = sessionFactory.openSession();
		TipoMiembro tipoMiembro = (TipoMiembro) sesion.get(
				TipoMiembro.class, idTipoMiembro);
		sesion.close();
		return tipoMiembro;
	}

	public List<TipoMiembro> daTipoMiembros() {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("TipoMiembro.findAll");
		List<TipoMiembro> tipomiembro = query.list();
		sesion.close();
		return tipomiembro;
	}
	
	
	
}
