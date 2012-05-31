package org.joedayz.acweb.service;

import java.util.List;

import org.joedayz.acweb.dao.CitaDAO;
import org.joedayz.acweb.dao.daoFactory.DAOFactory;
import org.joedayz.acweb.domain.BNCita;

public class CitaService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.H2);
	CitaDAO citaDAO = fabrica.getCitaDAO();
	
	public List<BNCita> getListaCitas() throws Exception{
		return citaDAO.getListaCitas();
	}
	
	public int registrarCita(BNCita cita) throws Exception{
		return citaDAO.registrarCita(cita);
	}
	
	public int eliminarCita(String idCita) throws Exception{
		return citaDAO.eliminarCita(idCita);
	}
	
}
