package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import java.text.ParseException;
import sv.edu.ues.igf115.eleccionesgrupo12.datos.SegPersonaDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.SegPersona;

public class CtrlSegPersona {

	private SegPersonaDAO daoPersona = new SegPersonaDAO();
	
	public boolean guardar(String nombre, String apellido, String telefono,String dui,String email) throws ParseException{
		SegPersona persona=daoPersona.daPersonaByDui(dui);
		if(persona==null){
			persona= new SegPersona(nombre, apellido, telefono, dui, email);
			daoPersona.guardaActualiza(persona);
			return true;
		}else
		{
			return false;
		}
	}
	public boolean actualizar(Integer id, String nombre, String apellido, String telefono,String dui,String email) throws ParseException{
		SegPersona persona= daoPersona.daPersonaByDui(dui);
		if(persona!=null){
			persona= new SegPersona(id,nombre, apellido, telefono, dui, email);
			daoPersona.guardaActualiza(persona);
			return true;
		}else
		{
			return false;
		}
	}	
	public boolean eliminar(Integer id) throws ParseException{
		SegPersona persona= daoPersona.daPersonaById(id);
		if(persona!=null){
			daoPersona.eliminar(persona);
			return true;
		}else
		{
			return false;
		}
	}
	public SegPersona daPersonaById(Integer id){
		return daoPersona.daPersonaById(id);
	}
	public SegPersona daPersonaByDui(String dui){
		return daoPersona.daPersonaByDui(dui);
	}
	
}
