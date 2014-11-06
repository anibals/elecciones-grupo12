package sv.edu.ues.igf115.eleccionesgrupo12.dominio;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Municipio", catalog="elecciones2014", schema="")
public class Municipio {
	
	
	@Id
	@Basic(optional = false)
	@JoinColumn(name="id_depto", referencedColumnName="id_depto")
	@ManyToOne(optional = false)
	private Departamento id_depto;
	
	
	@Id
	@Basic(optional = false)
	@Column(name = "id_municipio")
	private String municipio;
	
	@Basic(optional=false)
	@Column(name="nomb_municipio")
	private String nomb_municipio;
	
	public Municipio() {
		
	}
	
	

	public Municipio(Departamento id_depto, String municipio,
			String nomb_municipio) {
		super();
		this.id_depto = id_depto;
		this.municipio = municipio;
		this.nomb_municipio = nomb_municipio;
	}

	public Departamento getId_depto() {
		return id_depto;
	}

	public void setId_depto(Departamento id_depto) {
		this.id_depto = id_depto;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNomb_municipio() {
		return nomb_municipio;
	}

	public void setNomb_municipio(String nomb_municipio) {
		this.nomb_municipio = nomb_municipio;
	}
		
		
}
