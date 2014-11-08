package sv.edu.ues.igf115.eleccionesgrupo12.negocio;


import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.PadronElectoralDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.datos.PartidoPoliticoDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.datos.UrnaDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.PadronElectoral;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.PartidoPolitico;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Urna;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Votacion;



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
	
	
	
	
	
	public boolean eliminar(String dui) {
		PadronElectoral padron =daoPadronElectoral.daPadronElectoralById(dui);
		if (padron != null) {
			daoPadronElectoral.eliminar(padron);
			return true;
		} else
			return false;
	}
	
	public PadronElectoral daPadron(String dui) {
		return daoPadronElectoral.daPadronElectoralById(dui);
	}
	
	public boolean actualizar(String dui, String nombre,
		String apellido, Date fechanac,String domicilio,String estado,int idurna){
		
		UrnaDAO daoUrna= new UrnaDAO();
		PadronElectoral padron=daoPadronElectoral.daPadronElectoralById(dui);
				
		if (padron != null) {
			      Urna urna=daoUrna.daUrnaById(idurna);
				    padron.setNombre(nombre);
				    padron.setApellidos(apellido);
				    padron.setFecha_nac(fechanac);
				    padron.setDomicilio(domicilio);
				    padron.setEstadoVotacion(estado);
				    padron.setIdUrna(urna);
					daoPadronElectoral.guardaActualiza(padron);
					return true;
			}else
				return false;
		
			}
	
	
}
