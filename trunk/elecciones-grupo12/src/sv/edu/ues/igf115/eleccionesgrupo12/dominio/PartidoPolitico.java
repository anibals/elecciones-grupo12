package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PartidoPolitico", catalog="elecciones2014", schema="")
public class PartidoPolitico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_partidopolitico")
	private String idPartidoPolitico;
	
	@Basic(optional=false)
	@Column(name="nomb_partido")
	private String nombrePartido;
	
	@Basic(optional=false)
	@Column(name="fech_fundac")
	private Date fechaFundacion;
	
	@Basic(optional=false)
	@Column(name="nomb_secret_gral")
	private String nombreSecretarioGeneral;
	
	
															//RELACION<<<<<<<<<<<<<<<<<<<<<
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "partido")
	private List<Votacion> votacionList;
	
	
	
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
	
	public PartidoPolitico(String idPartidoPolitico, String nombrePartido,
			String fechaFundacion, String secretarioGeneral) throws ParseException {
		this.idPartidoPolitico = idPartidoPolitico;
		this.nombrePartido = nombrePartido;
		this.fechaFundacion = new SimpleDateFormat("dd/MM/yyyy").parse(fechaFundacion);
		this.nombreSecretarioGeneral = secretarioGeneral;
	}
	
	public PartidoPolitico(){
		
	}

	public String getIdPartidoPolitico() {
		return idPartidoPolitico;
	}

	public void setIdPartidoPolitico(String idPartidoPolitico) {
		this.idPartidoPolitico = idPartidoPolitico;
	}

	public String getNombrePartido() {
		return nombrePartido;
	}

	public void setNombrePartido(String nombrePartido) {
		this.nombrePartido = nombrePartido;
	}

	public Date getFechaFundacion() {
		return fechaFundacion;
	}

	public void setFechaFundacion(Date fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

	public String getNombreSecretarioGeneral() {
		return nombreSecretarioGeneral;
	}

	public void setNombreSecretarioGeneral(String nombreSecretarioGeneral) {
		this.nombreSecretarioGeneral = nombreSecretarioGeneral;
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

	public List<Votacion> getVotacionList() {
		return votacionList;
	}

	public void setVotacionList(List<Votacion> votacionList) {
		this.votacionList = votacionList;
	}

	
	
	
}

