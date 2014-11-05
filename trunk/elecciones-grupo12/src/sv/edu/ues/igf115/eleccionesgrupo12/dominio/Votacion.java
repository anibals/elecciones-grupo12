package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Votacion {

	

	private BigDecimal idVotacion;
	private BigDecimal cantVotosValidos;
	private BigDecimal idUrna;
	private String idPartidoPolitico;
	
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
	
	public Votacion(BigDecimal idVotacion, BigDecimal cantVotosValidos,
			BigDecimal idUrna, String idPartidoPolitico) {
		super();
		this.idVotacion = idVotacion;
		this.cantVotosValidos = cantVotosValidos;
		this.idUrna = idUrna;
		this.idPartidoPolitico = idPartidoPolitico;
	}
	
	//set y get

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

	public BigDecimal getIdUrna() {
		return idUrna;
	}

	public void setIdUrna(BigDecimal idUrna) {
		this.idUrna = idUrna;
	}

	public String getIdPartidoPolitico() {
		return idPartidoPolitico;
	}

	public void setIdPartidoPolitico(String idPartidoPolitico) {
		this.idPartidoPolitico = idPartidoPolitico;
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
