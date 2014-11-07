package sv.edu.ues.igf115.eleccionesgrupo12.negocio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.INTERNAL;

import sv.edu.ues.igf115.eleccionesgrupo12.datos.DepartamentoDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.datos.PartidoPoliticoDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.datos.UrnaDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.datos.VotacionDAO;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Departamento;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.PartidoPolitico;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Urna;
import sv.edu.ues.igf115.eleccionesgrupo12.dominio.Votacion;

public class CtrlVotacion {

	
	
	private VotacionDAO daoVotacion = new VotacionDAO();

	public int guardar(BigDecimal idVotacion, int idUrna, String idPartido, BigDecimal cantVotosValidos, String creo, Date fechaCreo, String modifico, Date fechaModifico){
		PartidoPoliticoDAO daoPartido=new PartidoPoliticoDAO();
		UrnaDAO daoUrna= new UrnaDAO();
		//Votacion votacion=daoVotacion.daVotacionById(idVotacion);
				
		if (daoVotacion.daVotacionById(idVotacion) == null) {
			PartidoPolitico partido=daoPartido.daPartidoPoliticoById(idPartido);
			Urna urna=daoUrna.daUrnaById(idUrna);
			if (urna!=null) {
				if (partido!=null) {
			   
					Votacion votacion=new Votacion(idVotacion, cantVotosValidos, urna, partido);
					votacion.setUsuarioCreacion(creo);
					votacion.setFechaCreacion(fechaCreo);
					votacion.setUsuarioModificacion(modifico);
					votacion.setFechaModificacion(fechaModifico);
					daoVotacion.guardaActualiza(votacion);
					return 3;
				}return 2;
			}else
				return 1;
			
		} else
			return 0;
	}

	
	
	public Votacion daVotacionById(BigDecimal idVotacion) {
		return daoVotacion.daVotacionById(idVotacion);
	}

	
	public List<Votacion> daVotacioness() {
		return daoVotacion.daVotacion();
	}
	
	
	
	
	public boolean eliminar(BigDecimal idVotacion) {
		Votacion votacion =daoVotacion.daVotacionById(idVotacion) ;
		if (votacion != null) {
			daoVotacion.eliminar(votacion);
			return true;
		} else
			return false;
	}
	
	
	public int actualizar(BigDecimal idVotacion, int idUrna, String idPartido, BigDecimal cantVotosValidos, String modifico, Date fechaModifico){
		PartidoPoliticoDAO daoPartido=new PartidoPoliticoDAO();
		UrnaDAO daoUrna= new UrnaDAO();
		Votacion votacion=daoVotacion.daVotacionById(idVotacion);
				
		if (votacion == null) {
			PartidoPolitico partido=daoPartido.daPartidoPoliticoById(idPartido);
			Urna urna=daoUrna.daUrnaById(idUrna);
			if (urna!=null) {
				if (partido!=null) {
					votacion.setCantVotosValidos(cantVotosValidos);
					votacion.setUrna(urna);
					votacion.setPartido(partido);
					votacion.setUsuarioModificacion(modifico);
					votacion.setFechaModificacion(fechaModifico);
					daoVotacion.guardaActualiza(votacion);
					return 3;
				}return 2;
			}else
				return 1;
			
		} else
			return 0;
	}

	
	
	
	
}
