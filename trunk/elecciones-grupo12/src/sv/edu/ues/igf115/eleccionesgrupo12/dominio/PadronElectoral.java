package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PadronElectoral", catalog="elecciones2014", schema="")
public class PadronElectoral implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional=false)
	@Column(name="dui")
	private String dui;
	
	@Basic(optional=false)
	@Column(name="nombre")
	private String nombre;
	
	@Basic(optional=false)
	@Column(name="apellidos")
	private String apellidos;
	
	@Basic(optional=false)
	@Column(name="fecha_nac")
	private Date fecha_nac;
	
	@Basic(optional=false)
	@Column(name="domicilio")
	private String domicilio;
	
	@Basic(optional=false)
	@Column(name="estado_votacion")
	private String estadoVotacion;
	
	/*
	@Basic(optional = false)
	@Column(name = "id_urna")	
	private Urna idUrna;
	*/
	
	//RELACION<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "dui")
	private List<Jrv> jrvList;
	
	//@JoinColumn(name = "id_urna")    //pienso que puede ser solo asi
	@JoinColumn(name = "id_urna", referencedColumnName = "id_urna")
	@ManyToOne(optional = false)
	private Urna idUrna;
	
	//RELACION<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	
	
	
	@Basic(optional=true)
	@Column(name="usercrea")
	private String userCrea;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechacreacion")
	private Date fechaCreacion;
	
	@Basic(optional=true)
	@Column(name="usermodifica")
	private String userModifica;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechamodificacion")
	private Date fechaModificacion;
	
	
	public PadronElectoral() {
		
	}
	

	

	public PadronElectoral(String dui, String nombre, String apellidos,
			Date fecha_nac, String domicilio, String estadoVotacion,
			Urna idUrna, String userCrea, Date fechaCreacion,
			String userModifica, Date fechaModificacion) {
		super();
		this.dui = dui;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nac = fecha_nac;
		this.domicilio = domicilio;
		this.estadoVotacion = estadoVotacion;
		this.idUrna = idUrna;
		this.userCrea = userCrea;
		this.fechaCreacion = fechaCreacion;
		this.userModifica = userModifica;
		this.fechaModificacion = fechaModificacion;
	}




	public String getDui() {
		return dui;
	}




	public void setDui(String dui) {
		this.dui = dui;
	}




	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEstadoVotacion() {
		return estadoVotacion;
	}

	public void setEstadoVotacion(String estadoVotacion) {
		this.estadoVotacion = estadoVotacion;
	}

	public Urna getIdUrna() {
		return idUrna;
	}

	public void setIdUrna(Urna idUrna) {
		this.idUrna = idUrna;
	}

	public String getUserCrea() {
		return userCrea;
	}

	public void setUserCrea(String userCrea) {
		this.userCrea = userCrea;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUserModifica() {
		return userModifica;
	}

	public void setUserModifica(String userModifica) {
		this.userModifica = userModifica;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}




	public List<Jrv> getJrvList() {
		return jrvList;
	}




	public void setJrvList(List<Jrv> jrvList) {
		this.jrvList = jrvList;
	}




	
	
}
