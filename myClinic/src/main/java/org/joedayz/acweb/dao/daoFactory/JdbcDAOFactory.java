package org.joedayz.acweb.dao.daoFactory;

import org.joedayz.acweb.dao.CitaDAO;
import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.dao.MedicoDAO;
import org.joedayz.acweb.dao.UsuarioDAO;
import org.joedayz.acweb.dao.impl.JdbcCitaDaoImpl;
import org.joedayz.acweb.dao.impl.JdbcEspecialidadDaoImpl;
import org.joedayz.acweb.dao.impl.JdbcMedicoDaoImpl;
import org.joedayz.acweb.dao.impl.JdbcUsuarioDaoImpl;



public class JdbcDAOFactory extends DAOFactory{
	
	public UsuarioDAO getUsuarioDAO() {
		return new JdbcUsuarioDaoImpl();
	}
	
	public EspecialidadDAO getEspecialidadDAO(){
		return new JdbcEspecialidadDaoImpl();
	}

	public MedicoDAO getMedicoDAO() {
		return new JdbcMedicoDaoImpl();
	}
	
	public CitaDAO getCitaDAO() {
		return new JdbcCitaDaoImpl();
	}

}
