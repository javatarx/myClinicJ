package org.joedayz.acweb.dao.factory;

import org.joedayz.acweb.dao.CitaDAO;
import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.dao.MedicoDAO;
import org.joedayz.acweb.dao.PacienteDAO;
import org.joedayz.acweb.dao.UsuarioDAO;

public abstract class FactoryDAO {
	public static final int JDBC = 1;
	public static final int HIBERNATE = 2;

	public abstract CitaDAO getCitaDAO();

	public abstract MedicoDAO getMedicoDAO();

	public abstract EspecialidadDAO getEspecialidadDAO();

	public abstract UsuarioDAO getUsuarioDAO();

	public abstract PacienteDAO getPacienteDAO();

	public static FactoryDAO getFactoryDAO(int whichFactory) {

		switch (whichFactory) {
		case JDBC:
			return new FactoryDaoJDBC();
		case HIBERNATE:
			return new FactoryDaoHBM();

		default:
			return null;
		}
	}

}
