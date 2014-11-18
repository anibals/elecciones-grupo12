package sv.edu.ues.igf115.eleccionesgrupo12.datos;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.SegUsuario;
import sv.edu.ues.igf115.eleccionesgrupo12.utilidades.HibernateUtil;

public class SegUsuarioDAO {
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
	public void guardaActualiza(SegUsuario usuario){
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(usuario);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
		}
	public void eliminar(SegUsuario usuario){
		try {
			iniciaOperacion();
			sesion.delete(usuario);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
		}
	public SegUsuario daUsuarioById(Integer id){
		sesion = sessionFactory.openSession();
		SegUsuario usuario=(SegUsuario) sesion.get(SegUsuario.class, id);
		sesion.close();
		return usuario;
	}
	public SegUsuario daUsuarioByNombre(String nombre){
		sesion = sessionFactory.openSession();
		Criteria criteria = sesion.createCriteria(SegUsuario.class).add(Restrictions.like("usuario", nombre));
		SegUsuario usuario = (SegUsuario)criteria.uniqueResult();
		sesion.close();
		return usuario;
	}
	public SegUsuario daUsuarioByRol(Integer idRol){
		sesion = sessionFactory.openSession();
		Criteria criteria = sesion.createCriteria(SegUsuario.class).add(Restrictions.like("idRol", idRol));
		SegUsuario usuario = (SegUsuario)criteria.uniqueResult();
		sesion.close();
		return usuario;
	}
	public SegUsuario daUsuarioByPersona(Integer id){
		sesion = sessionFactory.openSession();
		Criteria criteria = sesion.createCriteria(SegUsuario.class).add(Restrictions.like("idPersona", id));
		SegUsuario usuario = (SegUsuario)criteria.uniqueResult();
		sesion.close();
		return usuario;
	}
}
