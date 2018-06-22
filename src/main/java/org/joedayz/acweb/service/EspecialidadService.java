package org.joedayz.acweb.service;

import java.util.List;

import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.dao.factory.FactoryDAO;
import org.joedayz.acweb.domain.BNEspecialidad;

public class EspecialidadService {

	FactoryDAO fabrica = FactoryDAO.getFactoryDAO(FactoryDAO.HIBERNATE);
	EspecialidadDAO especialidadDAO = fabrica.getEspecialidadDAO();

	public List<BNEspecialidad> getListaEspecialidades() throws Exception {
		return especialidadDAO.getEspecialidades();
	}

	public List<BNEspecialidad> getEspecialidadesPorMedico(String idMedico) throws Exception {
		return especialidadDAO.getEspecialidadPorMedico(idMedico);
	}

	public BNEspecialidad getEspecialidadPorId(String idEspecialidad) throws Exception {
		return especialidadDAO.getEspecialidadPorId(idEspecialidad);
	}
}
