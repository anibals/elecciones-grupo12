package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.JrvDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Jrv;


public class CtrlJrv {

   private JrvDAO daojrv = new JrvDAO();

  
	

		//daojrv.guardaActualiza(jrv);
	public boolean insertarJrv(String idjrv,String municipio, String depto, String dui) {
		Jrv jrv = daojrv.daJrv(Integer.parseInt(idjrv));
		if (jrv == null) {
			jrv = new Jrv(idjrv, municipio,depto, dui, null, null, null, null);
			daojrv.guardaActualiza(jrv);
			return true;
		} else
			return false;
	}

	public boolean eliminarJrv(String idjrv) {
		if (daojrv.daJrv(Integer.parseInt(idjrv)) != null) {
			Jrv jrv = daojrv.daJrv(Integer.parseInt(idjrv));
			daojrv.eliminarJrv(jrv);
			return true;
		} else
			return false;
	}
	
	public boolean actualizar(String idjrv,String municipio, String depto, String dui) {
	      if (daojrv.daJrv(Integer.parseInt(idjrv)) != null) {
	    	    Jrv jrv = new Jrv(idjrv, municipio,depto, dui, null, null, null, null);
				daojrv.guardaActualiza(jrv);
               return true ;
	        }
	      else 
	    	    return false ;
	}
	
	public Jrv daJrvById(int idJrv) {
		return daojrv.daJrv(idJrv);
	}
}
