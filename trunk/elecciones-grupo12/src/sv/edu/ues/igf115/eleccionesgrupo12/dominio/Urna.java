package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Urna", catalog="", schema="")
public class Urna implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_urna")
	int idUrna;
	
	@Basic(optional=false)
	@Column(name="Num_Junta")
	BigDecimal numeroDeJunta;
	
	@Basic(optional=false)
	@Column(name="presidente")
	String presidente;
	
	@Basic(optional=false)
	@Column(name="secretario")
	String secretario;
	
	@Basic(optional=false)
	@Column(name="cant_votos_nulos")
	BigDecimal cantidadVotosNulos;
	
	@Basic(optional=false)
	@Column(name="cant_votos_no_valid")
	String cantidadVotosNoValidos;

	
	//RElACIONES<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name="id_municipio", referencedColumnName="id_municipio"),
	    @JoinColumn(name="id_depto", referencedColumnName="id_depto")
	})
	private Municipio municipio;

	/*
	@ManyToOne
	@JoinColumn(name="municipioPK",referencedColumnName="municipioPK")
	private Municipio municipio;*/
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "urna")
	private List<PadronElectoral> padronelectoralList;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "urna")
	private List<Votacion> votacionList;
	
	
	//RElACIONES<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public Urna()
	{
		
	}
	
	public int getIdUrna() {
		return idUrna;
	}

	public void setIdUrna(int idUrna) {
		this.idUrna = idUrna;
	}

	public BigDecimal getNumeroDeJunta() {
		return numeroDeJunta;
	}

	public void setNumeroDeJunta(BigDecimal numeroDeJunta) {
		this.numeroDeJunta = numeroDeJunta;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public String getSecretario() {
		return secretario;
	}

	public void setSecretario(String secretario) {
		this.secretario = secretario;
	}

	public BigDecimal getCantidadVotosNulos() {
		return cantidadVotosNulos;
	}

	public void setCantidadVotosNulos(BigDecimal cantidadVotosNulos) {
		this.cantidadVotosNulos = cantidadVotosNulos;
	}

	public String getCantidadVotosNoValidos() {
		return cantidadVotosNoValidos;
	}

	public void setCantidadVotosNoValidos(String cantidadVotosNoValidos) {
		this.cantidadVotosNoValidos = cantidadVotosNoValidos;
	}

	public List<PadronElectoral> getPadronelectoralList() {
		return padronelectoralList;
	}

	public void setPadronelectoralList(List<PadronElectoral> padronelectoralList) {
		this.padronelectoralList = padronelectoralList;
	}

	public List<Votacion> getVotacionList() {
		return votacionList;
	}

	public void setVotacionList(List<Votacion> votacionList) {
		this.votacionList = votacionList;
	}
	
	
	
	
}
