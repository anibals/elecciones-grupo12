package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.RolesDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.datos.SegUsuarioDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.SegUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class CtrlSegUsuario {

	private SegUsuarioDAO daoUsuario= new SegUsuarioDAO();
	private RolesDAO daoRoles = new RolesDAO();
	@Autowired
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public boolean guardar (Integer idPersona, Integer idRol, String nombre, String clave, int activo) throws ParseException {
		SegUsuario usuario=daoUsuario.daUsuarioByNombre(nombre);
		CharSequence claveSecuencia=(CharSequence)clave.trim();
		clave=passwordEncoder.encode(claveSecuencia);
		if(usuario==null){
			usuario=new SegUsuario(idPersona, idRol, nombre, clave, activo);
			daoUsuario.guardaActualiza(usuario);
			return true;
		}else
		{
			return false;
		}
	}
	public boolean actualizar(Integer id,Integer idPersona, Integer idRol, String nombre, String clave, int activo) throws ParseException {
		SegUsuario usuario= daoUsuario.daUsuarioByNombre(nombre);
		if(usuario!=null){
			usuario=new SegUsuario(id,idPersona, idRol, nombre, clave, activo);
			daoUsuario.guardaActualiza(usuario);
			return true;
		}else
		{
			return false;
		}
	}
	public boolean Eliminar(String nombre) throws ParseException {
		SegUsuario usuario= daoUsuario.daUsuarioByNombre(nombre);
		if(usuario!=null){
			daoUsuario.eliminar(usuario);
			return true;
		}else
		{
			return false;
		}
	}
	public SegUsuario daUsuarioById(Integer id){
		return daoUsuario.daUsuarioById(id);
	}
	public SegUsuario daUsuarioByNombre(String nombre){
		return daoUsuario.daUsuarioByNombre(nombre);
	}
	 public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		 sv.edu.ues.igf115.eleccionesgrupo12.dominio.SegUsuario  domainUser = daoUsuario.daUsuarioByNombre(login);
		
	        boolean enabled = true;
	        boolean accountNonExpired = true;
	        boolean credentialsNonExpired = true;
	        boolean accountNonLocked = true;
	 
	        return new User(
	                domainUser.getUsuario(), 
	                domainUser.getClave(), 
	                enabled, 
	                accountNonExpired, 
	                credentialsNonExpired, 
	                accountNonLocked,
	                getAuthorities(domainUser.getIdRol())
	        );
	    }
	 public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
	        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
	        return authList;
	    }
	 public List<String> getRoles(Integer id) {
	        List<String> roles = new ArrayList<String>();
	        sv.edu.ues.igf115.eleccionesgrupo12.dominio.Roles listaRoles= daoRoles.daRolesById(id); 
	        roles.add(listaRoles.getNombreRol());	        
	        return roles;
	    }
	 public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	         
	        for (String role : roles) {
	            authorities.add(new SimpleGrantedAuthority(role));
	        }
	        return authorities;
	    }
}
