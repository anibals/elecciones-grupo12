package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import java.util.List;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.MiembroJRVDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.MiembroJRV;

public class CtrlMiembroJrv {
	private MiembroJRVDAO daoMiembroJrv = new MiembroJRVDAO();
	
	public boolean guardar(String id, String nombres, String apPaterno, String apMaterno, String idJrv, String idTipoMiembro)
	{
		MiembroJRV miembro = daoMiembroJrv.daMiembroJRVById(id);
		if (miembro == null) {
			miembro = new MiembroJRV(id, nombres, apPaterno, apMaterno, idJrv, idTipoMiembro);
			daoMiembroJrv.guardaActualiza(miembro);
			return true;
		} else
			return false;
	}

	public MiembroJRV daMiembroJRVById(String idMiembroJrv) {
		return daoMiembroJrv.daMiembroJRVById(idMiembroJrv);
	}
	
	public List<MiembroJRV> daMiembrosByJRV(String idJrv) {
		return daoMiembroJrv.daMiembrosJRVByJRV(Integer.parseInt(idJrv));
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
	    	  MiembroJRV miembro = new MiembroJRV(id, nombres, apPaterno, apMaterno, idJrv, idTipoMiembro);
	    	  daoMiembroJrv.guardaActualiza(miembro);
               return true ;
	        }
	      else 
	    	    return false ;
 }
}
