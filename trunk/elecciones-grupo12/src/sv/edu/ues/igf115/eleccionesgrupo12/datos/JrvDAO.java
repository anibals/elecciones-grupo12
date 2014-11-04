package sv.edu.ues.igf115.eleccionesgrupo12.datos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Jrv;
import sv.edu.ues.igf115.eleccionesgrupo12.utilidades.*;


public class JrvDAO {
	
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



public void guardaActualiza(Jrv jrv) {
	
	try {
		iniciaOperacion();
		sesion.saveOrUpdate(jrv);
		tx.commit();
		sesion.flush();
	} catch (HibernateException he) {
		manejaExcepcion(he);
		throw he;
	} finally {
		sesion.close();
	}
}



}
