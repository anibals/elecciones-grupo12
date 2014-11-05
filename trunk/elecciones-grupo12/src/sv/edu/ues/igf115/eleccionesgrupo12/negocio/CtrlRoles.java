package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import java.text.ParseException;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.RolesDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Roles;

public class CtrlRoles {
	private RolesDAO daoRoles = new RolesDAO();
	
	public boolean guardar (String nombre) throws ParseException {
	Roles roles =daoRoles.daRolesByNombre(nombre);
	if(roles==null){
		roles= new Roles(nombre);
		daoRoles.guardaActualiza(roles);
		return true;
	}
	else
	{
		return false;
	}
	
	}
	public Roles daRolesById(Integer id){
		return daoRoles.daRolesById(id);
	}
	public Roles daRolesByNombre (String nombre){
		return daoRoles.daRolesByNombre(nombre);
	}
}
