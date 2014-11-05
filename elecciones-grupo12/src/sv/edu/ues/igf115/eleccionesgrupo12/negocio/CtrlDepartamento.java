package sv.edu.ues.igf115.eleccionesgrupo12.negocio;


import java.util.List;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.DepartamentoDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Departamento;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.TipoMiembro;


public class CtrlDepartamento {
	
	
	private DepartamentoDAO daoDepartamento = new DepartamentoDAO();

	public boolean guardar(String idDepto, String nombDepto, String zonaGeografica){
		Departamento departamento = daoDepartamento.daDepartamentoById(idDepto);
				
		if (departamento == null) {
			departamento = new Departamento(idDepto, nombDepto, zonaGeografica);     //Ver lo de la auditoria
			daoDepartamento.guardaActualiza(departamento);
			return true;
		} else
			return false;
	}

	
	
	public Departamento daDepartamentoById(String idDepto	) {
		return daoDepartamento.daDepartamentoById(idDepto);
	}

	
	public List<Departamento> daDepartamentos() {
		return daoDepartamento.daDepartamentos();
	}
	
	public List<Departamento> daDepartamentosByNombre(String nomDepto) {
		return daoDepartamento.daDepartamentoByNombre(nomDepto);
	}
	
	
	
	public boolean eliminar(String idDepto) {
		if (daoDepartamento.daDepartamentoById(idDepto) != null) {
			Departamento departamento = daoDepartamento.daDepartamentoById(idDepto);
			daoDepartamento.eliminar(departamento);
			return true;
		} else
			return false;
	}
	
	
	public boolean actualizar(String idDepto, String nombDepto, String zonaGeografica)  {
	      if (daoDepartamento.daDepartamentoById(idDepto) != null) {
	    	  Departamento departamento= new Departamento(idDepto, nombDepto, zonaGeografica); //Ver lo de la auditoria
	    	  daoDepartamento.guardaActualiza(departamento);
               return true ;
	        }
	      else 
	    	    return false ;
 }

	
	

}
