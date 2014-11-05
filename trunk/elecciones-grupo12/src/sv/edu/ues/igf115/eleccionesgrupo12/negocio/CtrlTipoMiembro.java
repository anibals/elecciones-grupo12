package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import java.util.List;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.TipoMiembroDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.TipoMiembro;

public class CtrlTipoMiembro {

	
	private TipoMiembroDAO daoTipoMiembro = new TipoMiembroDAO();


	public boolean guardar(String idTipoMiembro, String descripcion){
		TipoMiembro tipoMiembro=daoTipoMiembro.daTipoMimbroById(idTipoMiembro);
				
		if (tipoMiembro == null) {
			tipoMiembro = new TipoMiembro(idTipoMiembro, descripcion);	     //Ver lo de la auditoria
			daoTipoMiembro.guardaActualiza(tipoMiembro);
			return true;
		} else
			return false;
	}

	
	
	public TipoMiembro daTipoMiembroById(String idTipoMiembro) {
		return daoTipoMiembro.daTipoMimbroById(idTipoMiembro);
	}

	public List<TipoMiembro> daTipoMiembros() {
		return daoTipoMiembro.daTipoMiembros();
	}
	
	
	
	public boolean eliminar(String idTipoMiembro) {
		TipoMiembro tipoMiembro=daoTipoMiembro.daTipoMimbroById(idTipoMiembro);
		
		if (tipoMiembro != null) {
			daoTipoMiembro.eliminar(tipoMiembro);
			return true;
		} else
			return false;
	}
	
	
	public boolean actualizar(String idTipoMiembro, String descripcion)  {
	      if (daoTipoMiembro.daTipoMimbroById(idTipoMiembro) != null) {
	    	  TipoMiembro tipomiembro= new TipoMiembro(idTipoMiembro, descripcion); //Ver lo de la auditoria
	    	  daoTipoMiembro.guardaActualiza(tipomiembro);
               return true ;
	        }
	      else 
	    	    return false ;
 }

	
	
	
}
