package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.text.ParseException;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Roles", catalog="elecciones2014", schema="")
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="idrol")
	private Integer idRol;
	
	@Basic(optional=false)
	@Column(name="rol")
	private String nombreRol;
	
	public Roles(String nombreRol) throws ParseException {
		this.nombreRol= nombreRol;		
	}
	public Roles(){	
	}
	public Integer getIdRol(){
		return idRol;
	}
	public void setIdRol(Integer idRol){
		this.idRol=idRol;
	}
	public String getNombreRol(){
		return nombreRol;
	}
	public void setNombreRol(String nombreRol){
		this.nombreRol=nombreRol;
	}
	
}
