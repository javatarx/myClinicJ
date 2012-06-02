package org.joedayz.acweb.dao;

import java.util.Date;
import java.util.List;

import org.joedayz.acweb.domain.BNCita;

public interface CitaDAO {

	public BNCita getCitaPorId(String idCita) throws Exception;
	public List<BNCita> getListaCitas() throws Exception;
	public List<BNCita> getListaCitasPorUsuario(String idUsuario) throws Exception;
	public List<BNCita> getCitasPorMedico() throws Exception;
	public int registrarCita(BNCita cita) throws Exception;
	public int actualizarCita(BNCita cita) throws Exception;
	public int eliminarCita(String idCita) throws Exception;
	public List<String> getListaHorariosDisponibles(Date fecha,String idMedico) throws Exception;
}
