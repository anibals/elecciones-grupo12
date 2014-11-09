package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="seg_persona", catalog="elecciones2014", schema="")
public class SegPersona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="idpersona")
	private Integer idPersona;
	
	@Basic(optional=false)
	@Column(name="nombre")
	private String nombre;
	
	@Basic(optional=false)
	@Column(name="apellido")
	private String apellido;
	
	@Basic(optional=false)
	@Column(name="telefono")
	private String telefono;
	
	@Basic(optional=false)
	@Column(name="dui")
	private String dui;
	
	@Basic(optional=false)
	@Column(name="email")
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<SegUsuario> segUsuario= new ArrayList<SegUsuario>();
	
	
	
	public SegPersona (String nombre, String apellido, String telefono,String dui,String email ) throws ParseException {
		this.nombre=nombre;
		this.apellido= apellido;
		this.telefono= telefono;
		this.dui= dui;
		this.email= email;
	}
	
	public SegPersona (Integer id, String nombre, String apellido, String telefono,String dui,String email ) throws ParseException {
		this.idPersona=id;
		this.nombre=nombre;
		this.apellido= apellido;
		this.telefono= telefono;
		this.dui= dui;
		this.email= email;
	}
	public SegPersona(){
		
	}
	public Integer getIdPersona(){
		return idPersona;
	}
	public void setIdPersona(Integer idPersona){
		this.idPersona=idPersona;
	}
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getApellido(){
		return apellido;
	}
	public void setApellido(String apellido){
		this.apellido=apellido;
	}
	public String getTelefono(){
		return telefono;
	}
	public void setTelefono(String telefono){
		this.telefono=telefono;
	}
	public String getDui(){
		return dui;
	}
	public void setDui(String dui){
		this.dui=dui;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
}
