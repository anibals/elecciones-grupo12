package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import java.text.ParseException;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.MiembroJRVDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Jrv;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.MiembroJRV;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.TipoMiembro;

public class CtrlMiembroJrv {
	private MiembroJRVDAO daoMiembroJrv = new MiembroJRVDAO();
	
	public boolean guardar(String id, String nombres, String apPaterno, String apMaterno, String idJrv, String idTipoMiembro)
	{
		MiembroJRV miembro = daoMiembroJrv.daMiembroJRVById(id);
		if (miembro == null) {
			TipoMiembro tipo = new TipoMiembro();
			tipo.setIdTipoMiembro(idTipoMiembro);
			//tipo.setDescripcion("")
			Jrv jrv = new Jrv();
			jrv.setId(Integer.parseInt(idJrv));
			miembro = new MiembroJRV(id, nombres,apPaterno, apMaterno);
			miembro.setJrv(jrv);
			miembro.setTipoMiembro(tipo);
			daoMiembroJrv.guardaActualiza(miembro);
			return true;
		} else
			return false;
	}

	public MiembroJRV daMiembroJRVById(String idMiembroJrv) {
		return daoMiembroJrv.daMiembroJRVById(idMiembroJrv);
	}

	public boolean eliminar(String idMiembroJrv) {
		if (daoMiembroJrv.daMiembroJRVById(idMiembroJrv) != null) {
			MiembroJRV miembro = daoMiembroJrv.daMiembroJRVById(idMiembroJrv);
			daoMiembroJrv.eliminar(miembro);
			return true;
		} else
			return false;
	}
	
	public boolean actualizar(String id, String nombres, String apPaterno, String apMaterno, String idJrv, String idTipoMiembro){
	      if (daoMiembroJrv.daMiembroJRVById(id) != null) {
	    	  MiembroJRV miembro = new MiembroJRV(id, nombres, apPaterno, apMaterno);
	    	  daoMiembroJrv.guardaActualiza(miembro);
               return true ;
	        }
	      else 
	    	    return false ;
 }
}
