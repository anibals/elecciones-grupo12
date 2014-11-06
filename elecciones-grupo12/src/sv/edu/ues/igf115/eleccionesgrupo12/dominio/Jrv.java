package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.util.Date;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Departamento;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.PadronElectoral;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "JRV", catalog = "elecciones2014", schema = "")
public class Jrv {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Basic(optional = false)
@Column(name = "id_jrv")	
private int id;

/*@ManyToOne
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Departamento iddepto;*/

@JoinColumn(name="id_municipio", referencedColumnName="id_municipio")
@ManyToOne(optional=false)
private Municipio idmunicipio;


//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
@JoinColumn(name="dui", referencedColumnName="dui")
@ManyToOne(optional=false)
private PadronElectoral dui;

@Basic(optional = false)
@Column(name = "usercrea")
private String usercrea;

@Basic(optional = false)
@Column(name = "fechacreacion")
private Date fechacreacion;

@Basic(optional = false)
@Column(name = "usermodifica")
private String usermodifica;

@Basic(optional = false)
@Column(name = "fechamodificacion")
private Date fechamodificacion;



public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}

/*
public Departamento getIddepto() {
	return iddepto;
}


public void setIddepto(Departamento iddepto) {
	this.iddepto = iddepto;
}*/


public Municipio getIdmunicipio() {
	return idmunicipio;
}


public void setIdmunicipio(Municipio idmunicipio) {
	this.idmunicipio = idmunicipio;
}


public PadronElectoral getDui() {
	return dui;
}


public void setDui(PadronElectoral dui) {
	this.dui = dui;
}


public String getUsercrea() {
	return usercrea;
}


public void setUsercrea(String usercrea) {
	this.usercrea = usercrea;
}


public Date getFechacreacion() {
	return fechacreacion;
}


public void setFechacreacion(Date fechacreacion) {
	this.fechacreacion = fechacreacion;
}


public String getUsermodifica() {
	return usermodifica;
}


public void setUsermodifica(String usermodifica) {
	this.usermodifica = usermodifica;
}


public Date getFechamodificacion() {
	return fechamodificacion;
}


public void setFechamodificacion(Date fechamodificacion) {
	this.fechamodificacion = fechamodificacion;
}





public Jrv(){
	
	
}


public Jrv(int id, Departamento iddepto, Municipio idmunicipio,
		PadronElectoral dui, String usercrea, Date fechacreacion,
		String usermodifica, Date fechamodificacion) {
	super();
	this.id = id;
	//this.iddepto = iddepto;
	this.idmunicipio = idmunicipio;
	this.dui = dui;
	this.usercrea = usercrea;
	this.fechacreacion = fechacreacion;
	this.usermodifica = usermodifica;
	this.fechamodificacion = fechamodificacion;
}



}
