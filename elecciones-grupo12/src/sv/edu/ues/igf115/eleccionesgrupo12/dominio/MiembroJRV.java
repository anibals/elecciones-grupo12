package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MiembroJRV", catalog="elecciones2014", schema="")
public class MiembroJRV implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional=false)
	@Column(name="id_miembrojrv")
	private String idMiembroJrv;
	
	@Basic(optional=false)
	@Column(name="nombres")
	private String nombres;
	
	@Basic(optional=false)
	@Column(name="apellido_materno")
	private String apellidoMaterno;
	
	@Basic(optional=false)
	@Column(name="apellido_paterno")
	private String apellidoPaterno;
	
	
//RELACIONES<<<<<<<<<<<<<<<<<<<<<<<<<<<

	@JoinColumn(name="id_jrv", referencedColumnName="id_jrv")
	@ManyToOne(optional = false)
	private Jrv jrv;

	

	@JoinColumn(name="id_tipomiembro", referencedColumnName="id_tipomiembro")
	@ManyToOne(optional = false)
	private TipoMiembro tipoMiembro;
	
	//RELACIONES<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	
	private MiembroJRV(){
		
	}
	
	public MiembroJRV(String id, String nombres, String apPaterno, String apMaterno)
	{
		this.idMiembroJrv = id;
		this.nombres = nombres;
		this.apellidoPaterno = apPaterno;
		this.apellidoMaterno = apMaterno;
	}
		

	public String getIdMiembroJrv() {
		return idMiembroJrv;
	}

	public void setIdMiembroJrv(String idMiembroJrv) {
		this.idMiembroJrv = idMiembroJrv;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	
	public Jrv getJrv() {
		return jrv;
	}

	public void setJrv(Jrv jrv) {
		this.jrv = jrv;
	}

	public TipoMiembro getTipoMiembro() {
		return tipoMiembro;
	}

	public void setTipoMiembro(TipoMiembro tipoMiembro) {
		this.tipoMiembro = tipoMiembro;
	}

}
