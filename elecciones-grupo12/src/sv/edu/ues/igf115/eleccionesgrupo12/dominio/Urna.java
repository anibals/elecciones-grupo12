package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Urna", catalog="", schema="")
public class Urna {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id_urna")
	int idUrna;
	
	@OneToOne
	Municipio municipio;
	
	@OneToOne
	Departamento departamento;
	
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
	
	
}
