package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seg_usuario", catalog="elecciones2014", schema="")
public class SegUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="idusuario")
	private Integer idUsuario;
	
	@Column(name="idpersona")
	private Integer idPersona;
	
	@Column(name="idrol")
	private Integer idRol;
	
	@Basic(optional=false)
	@Column(name="usuario")
	private String usuario;
	
	@Basic(optional=false)
	@Column(name="clave")
	private String clave;
	
	@Basic(optional=false)
	@Column(name="activo")
	private int activo;
	
public SegUsuario (Integer idPersona, Integer idRol, String usuario, String clave, int activo){
	
	this.idPersona=idPersona;
	this.idRol=idRol;
	this.usuario=usuario;
	this.clave=clave;
	this.activo=activo;
	}
	public SegUsuario (){
		
	}
	
	public Integer getIdUsuario(){
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario){
		this.idUsuario=idUsuario;
	}
	public Integer getIdRol(){
		return idRol;
	}
	public void setIdRol(Integer idRol){
		this.idRol=idRol;
	}
	
	public Integer getIdPersona(){
		return idPersona;
	}
	public void setIdPersona(Integer idPersona){
		this.idPersona=idPersona;
	}
	
	public String getUsuario(){
		return usuario;
	}
	public void setUsuario(String usuario){
		this.usuario=usuario;
	}
	public String getClave(){
		return clave;
	}
	public void setClave(String clave){
		this.clave=clave;
	}
	public int getActivo(){
		return activo;
	}
	public void setActivo(int activo){
		this.activo=activo;
	}
}
