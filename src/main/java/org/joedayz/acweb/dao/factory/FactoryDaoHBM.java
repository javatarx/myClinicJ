package org.joedayz.acweb.dao.factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.joedayz.acweb.dao.CitaDAO;
import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.dao.MedicoDAO;
import org.joedayz.acweb.dao.PacienteDAO;
import org.joedayz.acweb.dao.UsuarioDAO;
import org.joedayz.acweb.dao.hbm.impl.CitaDaoImpl;
import org.joedayz.acweb.dao.hbm.impl.EspecialidadDaoImpl;
import org.joedayz.acweb.dao.hbm.impl.MedicoDaoImpl;
import org.joedayz.acweb.dao.hbm.impl.PacienteDaoImpl;
import org.joedayz.acweb.dao.hbm.impl.UsuarioDaoImpl;

public class FactoryDaoHBM extends FactoryDAO {
	private static SessionFactory sessionFactory;

	private static synchronized SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

			} catch (Throwable ex) {
				System.err.println("Error al crear la session, " + ex);
				throw new ExceptionInInitializerError(ex);
			}

		}
		return sessionFactory;
	}

	@Override
	public CitaDAO getCitaDAO() {
		return new CitaDaoImpl();
	}

	@Override
	public MedicoDAO getMedicoDAO() {
		return new MedicoDaoImpl();
	}

	@Override
	public EspecialidadDAO getEspecialidadDAO() {
		return new EspecialidadDaoImpl();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioDaoImpl();
	}

	@Override
	public PacienteDAO getPacienteDAO() {
		return new PacienteDaoImpl();
	}

}
