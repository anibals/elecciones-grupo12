package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.JrvDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Jrv;

public class CtrlJrv {

	private JrvDAO daojrv =new JrvDAO();
	
	public void insertarJrv(String depto,String municipio,String dui) {
	    
		Jrv jrv= new Jrv();
		
		jrv.getIddepto();	
	    jrv.setIdmunicipio(municipio);
		jrv.setDui(dui);
		
		
		daojrv.guardaActualiza(jrv);			
		}
		
	}
	
	
	
