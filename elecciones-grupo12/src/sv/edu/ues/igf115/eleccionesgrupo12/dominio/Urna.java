package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.MunicipioPk;

@Entity
@Table(name="Urna", catalog="", schema="")
public class Urna implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
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

	//RELACIONES<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name="id_municipio", referencedColumnName="id_municipio"),
	    @JoinColumn(name="id_depto", referencedColumnName="id_depto")
	})
	private Municipio municipio;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "idUrna")
	private List<PadronElectoral> padronelectoralList;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "urna")
	private List<Votacion> votacionList;
	
	//RELACIONES<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	public Urna()
	{
		
	}
	
	public Urna(int idUrna, String idMunicipio,
			String idDepartamento, String numJunta, String presidente, String secretario, String votosNulos, String votosNoValidos)
	{
		this.idUrna = idUrna;
		this.municipio = new Municipio();
		this.municipio.setIdMunicipio(new MunicipioPk(idDepartamento, idMunicipio));
		this.numeroDeJunta = new BigDecimal(numJunta);
		this.presidente = presidente;
		this.secretario = secretario;
		this.cantidadVotosNulos = new BigDecimal(votosNulos);
		this.cantidadVotosNoValidos = votosNoValidos;
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

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
}
