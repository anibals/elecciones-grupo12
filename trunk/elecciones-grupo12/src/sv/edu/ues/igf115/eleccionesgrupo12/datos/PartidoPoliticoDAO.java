package sv.edu.ues.igf115.eleccionesgrupo12.datos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sv.edu.ues.igf115.eleccionesgrupo12.dominio.PartidoPolitico;
import sv.edu.ues.igf115.eleccionesgrupo12.utilidades.HibernateUtil;

public class PartidoPoliticoDAO {

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

	public void guardaActualiza(PartidoPolitico partidoPolitico) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(partidoPolitico);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void eliminar(PartidoPolitico partidoPolitico) {
		try {
			iniciaOperacion();
			sesion.delete(partidoPolitico);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public PartidoPolitico daPartidoPoliticoById(String idPartidoPolitico) {
		sesion = sessionFactory.openSession();
		PartidoPolitico partido = (PartidoPolitico) sesion.get(PartidoPolitico.class, idPartidoPolitico);
		sesion.close();
		return partido;
	}

	public PartidoPolitico daPartidoByNombre(String nombrePartido) {
		sesion = sessionFactory.openSession();
		Criteria criteria = sesion.createCriteria(PartidoPolitico.class);
		criteria.add(Restrictions.like("nombrePartido", "%"+nombrePartido+"%"));
		PartidoPolitico partido = (PartidoPolitico) criteria.uniqueResult();
		sesion.close();
		return partido;
	}
}

