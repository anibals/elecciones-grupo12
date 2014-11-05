package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Departamento", catalog = "elecciones2014", schema = "")
@NamedQueries({
@NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
@NamedQuery(name = "Departamento.findByNombreDepto", query = "SELECT d FROM Departamento d WHERE d.nomb_depto = :nombDepto") })
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_depto")
	private String idDepto;
	
	@Basic(optional = false)
	@Column(name = "nom_depto")
	private String nombDepto;
	
	@Basic(optional = false)
	@Column(name = "zona_geografica")
	private String zonaGeografica;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Departamento" )
	private List<Municipio> municipioList;
	
	
	
	//auditoria
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
	
	
	private Departamento() {
		
	}
	
		
	
	public Departamento(String idDepto, String nombDepto,
			String zonaGeografica) {
		super();
		this.idDepto = idDepto;
		this.nombDepto = nombDepto;
		this.zonaGeografica = zonaGeografica;
	}





	//get y set
	
	public String getIdDepto() {
		return idDepto;
	}

	public void setIdDepto(String idDepto) {
		this.idDepto = idDepto;
	}

	public String getNombDepto() {
		return nombDepto;
	}

	public void setNombDepto(String nombDepto) {
		this.nombDepto = nombDepto;
	}

	public String getZonaGeografica() {
		return zonaGeografica;
	}

	public void setZonaGeografica(String zonaGeografica) {
		this.zonaGeografica = zonaGeografica;
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


	public List<Municipio> getMunicipioList() {
		return municipioList;
	}


	public void setMunicipioList(List<Municipio> municipioList) {
		this.municipioList = municipioList;
	}
	
	
	
}
