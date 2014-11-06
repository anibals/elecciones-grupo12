package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.MunicipioDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Departamento;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Municipio;


public class CtrlMunicipio {

	private MunicipioDAO daoMunicipio=new MunicipioDAO();
	
	public boolean guardarMunicipio(String iddepto,String idmunicipio,String nombremuni) {
		
		Municipio municipio = daoMunicipio.daMunicipioById(idmunicipio);
		if (municipio == null) {
			municipio = new Municipio(iddepto, idmunicipio, nombremuni);
			daoMunicipio.guardaActualiza(municipio);
			return true;
		} else
			return false;
	}
	
	
	
	
	
	
	
	
}
