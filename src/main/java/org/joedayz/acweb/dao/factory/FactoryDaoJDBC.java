package org.joedayz.acweb.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.joedayz.acweb.dao.CitaDAO;
import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.dao.MedicoDAO;
import org.joedayz.acweb.dao.PacienteDAO;
import org.joedayz.acweb.dao.UsuarioDAO;
import org.joedayz.acweb.dao.jdbc.impl.JdbcCitaDaoImpl;
import org.joedayz.acweb.dao.jdbc.impl.JdbcEspecialidadDaoImpl;
import org.joedayz.acweb.dao.jdbc.impl.JdbcMedicoDaoImpl;
import org.joedayz.acweb.dao.jdbc.impl.JdbcPacienteDaoImpl;
import org.joedayz.acweb.dao.jdbc.impl.JdbcUsuarioDaoImpl;
import org.joedayz.acweb.util.Constantes;

public class FactoryDaoJDBC extends FactoryDAO {
	private static Connection connection;

	public static synchronized Connection getConnexion() throws SQLException {
		if (connection == null) {
			try {
				Class.forName("org.h2.Driver");
				connection = DriverManager.getConnection("jdbc:h2:/" + Constantes.directorioBaseDeDatos + "/myClinic",
						"sa", "");
			} catch (ClassNotFoundException e) {
				System.out.println("Error de Conexion");
			}
		}
		return connection;
	}

	@Override
	public CitaDAO getCitaDAO() {
		return new JdbcCitaDaoImpl();
	}

	@Override
	public MedicoDAO getMedicoDAO() {
		return new JdbcMedicoDaoImpl();
	}

	@Override
	public EspecialidadDAO getEspecialidadDAO() {
		return new JdbcEspecialidadDaoImpl();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new JdbcUsuarioDaoImpl();
	}

	@Override
	public PacienteDAO getPacienteDAO() {
		return new JdbcPacienteDaoImpl();
	}

}
