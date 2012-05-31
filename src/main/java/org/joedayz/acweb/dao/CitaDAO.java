package org.joedayz.acweb.dao;

import java.util.List;

import org.joedayz.acweb.domain.BNCita;

public interface CitaDAO {

	public List<BNCita> getListaCitas() throws Exception;
	public List<BNCita> getCitasPorMedico() throws Exception;
	public int registrarCita(BNCita cita) throws Exception;
	public int eliminarCita(String idCita) throws Exception;
	
}
