package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PartidoPolitico", catalog="", schema="")
public class PartidoPolitico {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_partidopolitico")
	String idPartidoPolitico;
	
	@Basic(optional=false)
	@Column(name="nomb_partido")
	String nombrePartido;
	
	@Basic(optional=false)
	@Column(name="fech_fundac")
	Date fechaFundacion;
	
	@Basic(optional=false)
	@Column(name="nomb_secret_gral")
	String nombreSecretarioGeneral;

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

	
}
