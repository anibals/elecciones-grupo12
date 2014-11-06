package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import java.text.ParseException;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.UrnaDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Urna;


public class CtrlUrna {

	private UrnaDAO daoUrna = new UrnaDAO();

	public boolean guardar(int iddaoUrna, String nombrePartido,
			String fechaFundacion, String secretarioGeneral)
			throws ParseException {
		Urna urna = daoUrna.daUrnaById(iddaoUrna);
		if (urna == null) {
			//urna = new Urna(iddaoUrna, nombrePartido,fechaFundacion, secretarioGeneral);
			daoUrna.guardaActualiza(urna);
			return true;
		} else
			return false;
	}

	public Urna daUrnaById(int idUrna) {
		return daoUrna.daUrnaById(idUrna);
	}

	public boolean eliminar(int iddaoUrna) {
		if (daoUrna.daUrnaById(iddaoUrna) != null) {
			Urna urna = daoUrna.daUrnaById(iddaoUrna);
			daoUrna.eliminar(urna);
			return true;
		} else
			return false;
	}
	
	public boolean actualizar(int iddaoUrna, String nombrePartido,
			String fechaFundacion, String secretarioGeneral) throws ParseException {
	      if (daoUrna.daUrnaById(iddaoUrna) != null) {
	    	 // Urna urna = new Urna(iddaoUrna, nombrePartido, fechaFundacion, secretarioGeneral);
	    	 // daoUrna.guardaActualiza(urna);
               return true ;
	        }
	      else 
	    	    return false ;
 }
}
