package org.joedayz.acweb.dao.daoFactory;

import org.joedayz.acweb.dao.CitaDAO;
import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.dao.MedicoDAO;
import org.joedayz.acweb.dao.UsuarioDAO;

public abstract class DAOFactory {
	
		public static final int MYSQL = 1;

		public static final int ORACLE = 2;

		public static final int DB2 = 3;

		public static final int SQLSERVER = 4;

		public static final int XML = 5;

		public static final int POSTGRESQL = 6;
		
		public static final int H2 = 7;
		

		public abstract UsuarioDAO getUsuarioDAO();
		
		public abstract EspecialidadDAO getEspecialidadDAO();
		
		public abstract MedicoDAO getMedicoDAO();
		
		public abstract CitaDAO getCitaDAO();
		

		
		public static DAOFactory getDAOFactory(int whichFactory) 
		{
			switch (whichFactory) 
			{
				case H2:
				return new JdbcDAOFactory();
			
			default:
				return null;
			}
		}
	}
