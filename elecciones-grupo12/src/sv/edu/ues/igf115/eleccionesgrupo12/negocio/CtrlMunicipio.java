package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.MunicipioDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.datos.MunicipioPk;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Departamento;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Municipio;


public class CtrlMunicipio {

	private MunicipioDAO daoMunicipio=new MunicipioDAO();
	/*
	public boolean guardarMunicipio(String iddepto,String idmunicipio,String nombremuni) {
		
		Municipio municipio = daoMunicipio.daMunicipioById(idmunicipio);
		if (municipio == null) {
			municipio = new Municipio(iddepto, idmunicipio, nombremuni);
			daoMunicipio.guardaActualiza(municipio);
			return true;
		} else
			return false;
	}
	
	
	*/
	
public boolean guardarMunicipio(String iddepto,String idmunicipio,String nombremuni) {
		
		Municipio municipio =new Municipio(); 
		if (true) {
			MunicipioPk municipiopk= new MunicipioPk(iddepto, idmunicipio);
			municipio.setIdMunicipio(municipiopk);
			municipio.setNomb_municipio(nombremuni);
			daoMunicipio.guardaActualiza(municipio);
			return true;
		} else
			return false;
	}
	
	
	
}
