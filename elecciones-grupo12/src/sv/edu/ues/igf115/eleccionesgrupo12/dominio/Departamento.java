package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Departamento {

	private String idDepto;
	private String nombDepto;
	private String zonaGeografica;
	
	
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
	
	
	public Departamento(String idDepto, String nombDepto, String zonaGeografica) {
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
	
}
