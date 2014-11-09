package sv.edu.ues.igf115.eleccionesgrupo12.datos;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sv.edu.ues.igf115.eleccionesgrupo12.dominio.SegPersona;
import sv.edu.ues.igf115.eleccionesgrupo12.utilidades.HibernateUtil;

public class SegPersonaDAO {
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
	public void guardaActualiza(SegPersona persona){
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(persona);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
		}
	public void eliminar(SegPersona persona){
		try {
			iniciaOperacion();
			sesion.delete(persona);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	public SegPersona daPersonaById(Integer id){
		sesion = sessionFactory.openSession();
		SegPersona persona=(SegPersona) sesion.get(SegPersona.class, id);
		sesion.close();
		return persona;
	}
	public SegPersona daPersonaByDui(String dui){
		sesion = sessionFactory.openSession();
		Criteria criteria = sesion.createCriteria(SegPersona.class).add(Restrictions.like("dui", dui));
		SegPersona persona = (SegPersona)criteria.uniqueResult();
		sesion.close();
		return persona;
	}
	
}
