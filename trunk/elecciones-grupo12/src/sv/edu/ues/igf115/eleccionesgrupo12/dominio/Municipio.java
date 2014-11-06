package sv.edu.ues.igf115.eleccionesgrupo12.dominio;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.MunicipioPk;

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
	
	
	
	//RElACIONES<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	/*
	@JoinColumn(name = "id_urna", referencedColumnName = "id_urna")
	@ManyToOne(optional = false)
	private Urna urna;
	
	@JoinColumn(name = "id_partidopolitico", referencedColumnName = "id_partidopolitico")
	@ManyToOne(optional = false)
	private PartidoPolitico partido;
	
	*/
	
	
	@JoinColumn(name = "id_depto", referencedColumnName = "id_depto", insertable=false, updatable=false )
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departamento departamento;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "municipio")
	/*@JoinColumns({
	    @JoinColumn(name="id_municipio", referencedColumnName="id_municipio"),
	    @JoinColumn(name="id_depto", referencedColumnName="id_depto")
	})*/
	private List<Urna> urnaList;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "municipio")
	/*@JoinColumns({
	    @JoinColumn(name="id_municipio", referencedColumnName="id_municipio"),
	    @JoinColumn(name="id_depto", referencedColumnName="id_depto")
	})*/
	private List<Jrv> jrvList;
	//RElACIONES<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	
	
	public Municipio() {
		
	}
	
	public Municipio(String idDepto, String idMunicipio, String nombreMunicipio){
		//this.idMunicipio.idDepartamento = idDepto;
		//this.idMunicipio.idMunicipio = idMunicipio;
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

	/*@Embeddable
    class MunicipioPk implements Serializable{

	
	private static final long serialVersionUID = 1L;
	 //@ManyToOne
	   //@JoinColumn(name="id_depto", referencedColumnName = "id_depto")
	@Column(name="id_depto", insertable=false, updatable=false)
	String idDepartamento;
	
	
	@Column(name="id_municipio")
	String idMunicipio;
	
}
*/