package sv.edu.ues.igf115.eleccionesgrupo12.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Departamento;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.PadronElectoral;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "JRV", catalog = "elecciones2014", schema = "")
public class Jrv implements Serializable {
	private static final long serialVersionUID = 1L;
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
@Basic(optional = false)
@Column(name = "id_jrv")	
private int id;




//RELACIONES<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

@OneToMany(cascade=CascadeType.ALL, mappedBy = "jrv")
private List<MiembroJRV> miembroList;

@ManyToOne
@JoinColumn(name="dui",referencedColumnName="dui")
private PadronElectoral dui;

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
//RELACIONES<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



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


public Municipio getIdmunicipio() {
	return municipio;
}


public void setIdmunicipio(Municipio idmunicipio) {
	this.municipio = idmunicipio;
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


public Jrv(int id, Municipio idmunicipio,
		PadronElectoral dui, String usercrea, Date fechacreacion,
		String usermodifica, Date fechamodificacion) {
	super();
	this.id = id;
	this.municipio = idmunicipio;
	this.dui = dui;
	this.usercrea = usercrea;
	this.fechacreacion = fechacreacion;
	this.usermodifica = usermodifica;
	this.fechamodificacion = fechamodificacion;
}



}
