package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import java.text.ParseException;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.PartidoPoliticoDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.PartidoPolitico;

public class CtrlPartidoPolitico {
	private PartidoPoliticoDAO daoPartidoPolitico = new PartidoPoliticoDAO();

	public boolean guardar(String idPartidoPolitico, String nombrePartido,
			String fechaFundacion, String secretarioGeneral)
			throws ParseException {
		PartidoPolitico partido = daoPartidoPolitico
				.daPartidoPoliticoById(idPartidoPolitico);
		if (partido == null) {
			partido = new PartidoPolitico(idPartidoPolitico, nombrePartido,
					fechaFundacion, secretarioGeneral);
			daoPartidoPolitico.guardaActualiza(partido);
			return true;
		} else
			return false;
	}

	public PartidoPolitico daPartidoPoliticoById(String idPartidoPolitico) {
		return daoPartidoPolitico.daPartidoPoliticoById(idPartidoPolitico);
	}

	public boolean eliminar(String idPartidoPolitico) {
		if (daoPartidoPolitico.daPartidoPoliticoById(idPartidoPolitico) != null) {
			PartidoPolitico partido = daoPartidoPolitico
					.daPartidoPoliticoById(idPartidoPolitico);
			daoPartidoPolitico.eliminar(partido);
			return true;
		} else
			return false;
	}
	
	public boolean actualizar(String idPartidoPolitico, String nombrePartido,
			String fechaFundacion, String secretarioGeneral) throws ParseException {
	      if (daoPartidoPolitico.daPartidoPoliticoById(idPartidoPolitico) != null) {
	    	  PartidoPolitico partido = new PartidoPolitico(idPartidoPolitico, nombrePartido, fechaFundacion, secretarioGeneral);
	    	  daoPartidoPolitico.guardaActualiza(partido);
               return true ;
	        }
	      else 
	    	    return false ;
 }

}
