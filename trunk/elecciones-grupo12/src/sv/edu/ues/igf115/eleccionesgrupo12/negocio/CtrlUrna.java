package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.UrnaDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Urna;


public class CtrlUrna {

	private UrnaDAO daoUrna = new UrnaDAO();

	public boolean guardar(int idUrna, String idMunicipio,
			String idDepartamento, String numJunta, String presidente, String secretario, String votosNulos, String votosNoValidos)
	{
		Urna urna = daoUrna.daUrnaById(idUrna);
		if (urna == null) {
			urna = new Urna(idUrna, idMunicipio, idDepartamento, numJunta, presidente, secretario, votosNulos, votosNoValidos);
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
	
	public boolean actualizar(int idUrna, String idMunicipio,
			String idDepartamento, String numJunta, String presidente, String secretario, String votosNulos, String votosNoValidos) {
	      if (daoUrna.daUrnaById(idUrna) != null) {
	    	  Urna urna = new Urna(idUrna, idMunicipio, idDepartamento, numJunta, presidente, secretario, votosNulos, votosNoValidos);
	    	  daoUrna.guardaActualiza(urna);
               return true ;
	        }
	      else 
	    	    return false ;
 }
}
