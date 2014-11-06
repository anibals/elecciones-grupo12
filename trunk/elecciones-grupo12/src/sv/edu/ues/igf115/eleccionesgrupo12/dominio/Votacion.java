package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Votacion", catalog = "elecciones2014", schema = "")
@NamedQuery(name = "Votacion.findAll", query = "SELECT v FROM Votacion v")
public class Votacion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_votacion")
	private BigDecimal idVotacion;
	
	@Basic(optional = false)
	@Column(name = "cant_votos_validos")
	private BigDecimal cantVotosValidos;
	
	
	
	//RElACIONES<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	@JoinColumn(name = "id_urna", referencedColumnName = "id_urna")
	@ManyToOne(optional = false)
	private Urna urna;
	
	@JoinColumn(name = "id_partidopolitico", referencedColumnName = "id_partidopolitico")
	@ManyToOne(optional = false)
	private PartidoPolitico partido;
	
	//RElACIONES<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	//columnas de auditoria
	
	@Basic(optional=true)
	@Column(name="usercrea")
	private String usuarioCreacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechacreacion")
	private Date fechaCreacion;
	
	@Basic(optional=true)
	@Column(name="usermodifica")
	private String usuarioModificacion; 

	@Temporal(TemporalType.DATE)
	@Column(name="fechamodificacion")
	private Date fechaModificacion;
	
	//constructores
	
	private Votacion(){
		
	}
	
	
	//set y get

	public Votacion(BigDecimal idVotacion, BigDecimal cantVotosValidos,
			Urna urna, PartidoPolitico partido) {
		super();
		this.idVotacion = idVotacion;
		this.cantVotosValidos = cantVotosValidos;
		this.urna = urna;
		this.partido = partido;
	}



	public BigDecimal getIdVotacion() {
		return idVotacion;
	}


	public void setIdVotacion(BigDecimal idVotacion) {
		this.idVotacion = idVotacion;
	}

	public BigDecimal getCantVotosValidos() {
		return cantVotosValidos;
	}

	public void setCantVotosValidos(BigDecimal cantVotosValidos) {
		this.cantVotosValidos = cantVotosValidos;
	}

	
	public Urna getUrna() {
		return urna;
	}



	public void setUrna(Urna urna) {
		this.urna = urna;
	}



	public PartidoPolitico getPartido() {
		return partido;
	}



	public void setPartido(PartidoPolitico partido) {
		this.partido = partido;
	}



	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	
}
