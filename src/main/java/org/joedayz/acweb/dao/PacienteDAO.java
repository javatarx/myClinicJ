package org.joedayz.acweb.dao;

import java.util.List;

import org.joedayz.acweb.domain.BNPaciente;

public interface PacienteDAO {
	public List<BNPaciente> getListaPacientes() throws Exception;

	public BNPaciente getPacientePorId(String idPaciente) throws Exception;

	public int guardar(BNPaciente paciente) throws Exception;
}