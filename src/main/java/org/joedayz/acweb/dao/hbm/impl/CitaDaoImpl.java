package org.joedayz.acweb.dao.hbm.impl;

import java.util.Date;
import java.util.List;

import org.joedayz.acweb.dao.CitaDAO;
import org.joedayz.acweb.domain.BNCita;

public class CitaDaoImpl implements CitaDAO {

	public BNCita getCitaPorId(String idCita) throws Exception {
		return null;
	}

	public List<BNCita> getListaCitas() throws Exception {
		return null;
	}

	public List<BNCita> getListaCitasPorUsuario(String idUsuario) throws Exception {
		return null;
	}

	public List<BNCita> getCitasPorMedico() throws Exception {
		return null;
	}

	public int registrarCita(BNCita cita) throws Exception {
		return 0;
	}

	public int actualizarCita(BNCita cita) throws Exception {
		return 0;
	}

	public int eliminarCita(String idCita) throws Exception {
		return 0;
	}

	public List<String> getListaHorariosDisponibles(Date fecha, String idMedico) throws Exception {
		return null;
	}

}
