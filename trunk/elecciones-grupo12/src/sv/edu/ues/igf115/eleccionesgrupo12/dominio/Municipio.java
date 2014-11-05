package sv.edu.ues.igf115.eleccionesgrupo12.dominio;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Departamento;

@Entity
@Table(name="Municipio", catalog="elecciones2014", schema="")
public class Municipio {
	
	
	private Departamento id_depto;
	
	@Basic(optional=false)
	@Column(name="id_municipio")
	private Municipio municipio;
	
	@Basic(optional=false)
	@Column(name="nomb_municipio")
	private String nomb_municipio;
	
	public Municipio() {
		
	}
	
	

	public Municipio(Departamento id_depto, Municipio municipio,
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

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getNomb_municipio() {
		return nomb_municipio;
	}

	public void setNomb_municipio(String nomb_municipio) {
		this.nomb_municipio = nomb_municipio;
	}
		
		
}
