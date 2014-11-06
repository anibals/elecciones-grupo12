package sv.edu.ues.igf115.eleccionesgrupo12.dominio;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Departamento;

@Entity
@Table(name="Municipio", catalog="elecciones2014", schema="")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MunicipioPk idMunicipio;
	

    /*@ManyToOne
    @JoinColumns ({
        @JoinColumn(name="parentCivility", referencedColumnName = "isMale"),
        @JoinColumn(name="parentLastName", referencedColumnName = "lastName"),
        @JoinColumn(name="parentFirstName", referencedColumnName = "firstName")})
	private Departamento departamento;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_municipio")
	private String municipio;*/
	
	@Basic(optional=false)
	@Column(name="nomb_municipio")
	private String nomb_municipio;
	
	public Municipio() {
		
	}
	
	public Municipio(String idDepto, String idMunicipio, String nombreMunicipio){
		this.idMunicipio.departamento = idDepto;
		this.idMunicipio.idMunicipio = idMunicipio;
		this.nomb_municipio = nombreMunicipio;
	}

	public Municipio(MunicipioPk idMunicipio, String nomb_municipio) {
		super();
		this.idMunicipio = idMunicipio;
		this.nomb_municipio = nomb_municipio;
	}

	public MunicipioPk getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(MunicipioPk idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getNomb_municipio() {
		return nomb_municipio;
	}

	public void setNomb_municipio(String nomb_municipio) {
		this.nomb_municipio = nomb_municipio;
	}
	

	
		
}

	@Embeddable
    class MunicipioPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="id_depto")
	String departamento;
	
	@Column(name="id_municipio")
	String idMunicipio;
	
}
