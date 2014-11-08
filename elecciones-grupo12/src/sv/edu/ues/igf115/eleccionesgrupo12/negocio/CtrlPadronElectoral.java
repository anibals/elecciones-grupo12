package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import java.text.ParseException;
import java.util.Date;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.PadronElectoralDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.datos.UrnaDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.PadronElectoral;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.PartidoPolitico;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Urna;


public class CtrlPadronElectoral {
private PadronElectoralDAO daoPadronElectoral=new PadronElectoralDAO();

	public boolean guardar(String dui, String nombre,
			String apellido, Date fechanac,String domicilio,String estado,int idurna)
			throws ParseException {
		UrnaDAO daoUrna= new UrnaDAO();
		PadronElectoral padron = daoPadronElectoral.daPadronElectoralById(dui);
		Urna urna=daoUrna.daUrnaById(idurna);
		if (padron == null) {
			padron = new PadronElectoral(dui, nombre, apellido, fechanac, domicilio, estado, urna, null, null, null, null);
			daoPadronElectoral.guardaActualiza(padron);
			return true;
		} else
			return false;
	}
	
	
	
	
	
	
	
	
	
	
}
