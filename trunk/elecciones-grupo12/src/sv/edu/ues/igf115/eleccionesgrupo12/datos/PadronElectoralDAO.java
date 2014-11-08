package sv.edu.ues.igf115.eleccionesgrupo12.datos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import sv.edu.ues.igf115.eleccionesgrupo12.dominio.PadronElectoral;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.PartidoPolitico;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Votacion;
import sv.edu.ues.igf115.eleccionesgrupo12.utilidades.HibernateUtil;
public class PadronElectoralDAO {

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
		throw new HibernateException("Ocurri� un error en la capa DAO", he);
	}
	public void guardaActualiza(PadronElectoral padronelectoral) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(padronelectoral);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	public PadronElectoral daPadronElectoralById(String dui) {
		sesion = sessionFactory.openSession();
		PadronElectoral padron = (PadronElectoral) sesion.get(PartidoPolitico.class, dui);
		sesion.close();
		return padron;
	}
	
	
	
	
	
	
	
	
}
