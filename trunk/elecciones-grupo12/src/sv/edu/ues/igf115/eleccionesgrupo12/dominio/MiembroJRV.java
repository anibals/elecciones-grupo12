package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class MiembroJRV {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	//@OneToOne
	//private JRV jrv;
		
	//@OneToOne
	//private TipoMiembro tipoMiembro;
	
	public MiembroJRV(){
		
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
	
	
	

}
