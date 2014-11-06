package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.JrvDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Jrv;


public class CtrlJrv {

   private JrvDAO daojrv = new JrvDAO();

	public void insertarJrv(String depto, String municipio, String dui) {

       Jrv jrv = new Jrv();

	

		daojrv.guardaActualiza(jrv);
	}

	public boolean eliminarJrv(String idjrv) {
		if (daojrv.daJrv(idjrv) != null) {
			Jrv jrv = (Jrv) daojrv.daJrv(idjrv);
			daojrv.eliminarJrv(jrv);
			return true;
		} else
			return false;
		}

}
