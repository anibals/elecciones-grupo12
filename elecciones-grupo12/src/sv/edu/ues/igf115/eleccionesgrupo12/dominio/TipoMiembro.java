package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class TipoMiembro {

	private String idTipoMiembro;
	private String descripcion;
	
	
	//columnas auditoria
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
	private TipoMiembro() {
		
	}
	
	
	public TipoMiembro(String idTipoMiembro, String descripcion) {
		super();
		this.idTipoMiembro = idTipoMiembro;
		this.descripcion = descripcion;
	}

	//set y get
	
	public String getIdTipoMiembro() {
		return idTipoMiembro;
	}

	public void setIdTipoMiembro(String idTipoMiembro) {
		this.idTipoMiembro = idTipoMiembro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
