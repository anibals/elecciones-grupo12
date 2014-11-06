package sv.edu.ues.igf115.eleccionesgrupo12.datos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MunicipioPk implements Serializable{


private static final long serialVersionUID = 1L;
 //@ManyToOne
   //@JoinColumn(name="id_depto", referencedColumnName = "id_depto")
@Column(name="id_depto", insertable=false, updatable=false)
String idDepartamento;


@Column(name="id_municipio")
String idMunicipio;


public String getIdDepartamento() {
	return idDepartamento;
}


public void setIdDepartamento(String idDepartamento) {
	this.idDepartamento = idDepartamento;
}


public String getIdMunicipio() {
	return idMunicipio;
}


public void setIdMunicipio(String idMunicipio) {
	this.idMunicipio = idMunicipio;
}


public MunicipioPk(String idDepartamento, String idMunicipio) {
	super();
	this.idDepartamento = idDepartamento;
	this.idMunicipio = idMunicipio;
}



}