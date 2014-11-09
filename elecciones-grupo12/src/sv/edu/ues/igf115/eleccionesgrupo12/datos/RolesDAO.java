package sv.edu.ues.igf115.eleccionesgrupo12.datos;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Roles;
import sv.edu.ues.igf115.eleccionesgrupo12.utilidades.HibernateUtil;

public class RolesDAO {
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
	public void guardaActualiza(Roles roles){
	try {
		iniciaOperacion();
		sesion.saveOrUpdate(roles);
		tx.commit();
		sesion.flush();
	} catch (HibernateException he) {
		manejaExcepcion(he);
		throw he;
	} finally {
		sesion.close();
	}
	}

	public void eliminar(Roles roles){
		try {
			iniciaOperacion();
			sesion.delete(roles);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	public Roles daRolesById(Integer id){
		sesion = sessionFactory.openSession();
		Roles roles = (Roles) sesion.get(Roles.class, id);
		sesion.close();
		return roles;
	}
	public Roles daRolesByNombre(String nombre){
		sesion = sessionFactory.openSession();
		Criteria criteria = sesion.createCriteria(Roles.class).add(Restrictions.like("nombreRol",nombre));
		Roles roles = (Roles) criteria.uniqueResult();
		sesion.close();
		return roles;
	}
	
}
