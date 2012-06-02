package org.joedayz.acweb.service;

import java.util.List;

import org.joedayz.acweb.dao.CitaDAO;
import org.joedayz.acweb.dao.daoFactory.DAOFactory;
import org.joedayz.acweb.domain.BNCita;

public class CitaService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.H2);
	CitaDAO citaDAO = fabrica.getCitaDAO();
	
	public BNCita getCitaPorId(String idCita) throws Exception{
		return citaDAO.getCitaPorId(idCita);
	}
	
	public List<BNCita> getListaCitas() throws Exception{
		return citaDAO.getListaCitas();
	}
	
	public List<BNCita> getListaCitasPorUsuario(String idUsuario) throws Exception{
		return citaDAO.getListaCitasPorUsuario(idUsuario);
	}
	
	public int registrarCita(BNCita cita) throws Exception{
		return citaDAO.registrarCita(cita);
	}
	
	public int eliminarCita(String idCita) throws Exception{
		return citaDAO.eliminarCita(idCita);
	}
	
	public int actualizarCita(BNCita cita) throws Exception{
		return citaDAO.actualizarCita(cita);
	}
}
