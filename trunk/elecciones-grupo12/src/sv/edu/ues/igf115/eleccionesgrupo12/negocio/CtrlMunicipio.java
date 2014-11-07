package sv.edu.ues.igf115.eleccionesgrupo12.negocio;


import sv.edu.ues.igf115.eleccionesgrupo12.datos.MunicipioDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.datos.MunicipioPk;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Municipio;


public class CtrlMunicipio {

	private MunicipioDAO daoMunicipio=new MunicipioDAO();
	
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
	
	
	public boolean eliminarMunicipio(String nombreMunicipio) {
		Municipio municipio =new Municipio(); 
		
		if (daoMunicipio.daMunicipioByNombre(nombreMunicipio) != null) {
			Municipio municip = (Municipio)daoMunicipio.daMunicipioByNombre(nombreMunicipio);
			daoMunicipio.eliminar(municip);
			return true;
		} else
			return false;
	}
	
	
	
	
}
