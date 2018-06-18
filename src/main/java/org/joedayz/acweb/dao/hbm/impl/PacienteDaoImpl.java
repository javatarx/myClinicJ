package org.joedayz.acweb.dao.hbm.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.joedayz.acweb.dao.PacienteDAO;
import org.joedayz.acweb.domain.BNPaciente;

public class PacienteDaoImpl implements PacienteDAO {
	private SessionFactory sessionFactory;

	public PacienteDaoImpl() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}

	}

	public List<BNPaciente> getListaPacientes() throws Exception {
		Session session = sessionFactory.openSession();
		List lista = session.createQuery("from BNPaciente").list();
		for (BNPaciente p : (List<BNPaciente>) lista) {
			System.out.println("Paciente: " + p.getNombre());
		}
		session.close();
		return lista;
	}

	public BNPaciente getPacientePorId(String idPaciente) throws Exception {
		Session session = sessionFactory.openSession();
		BNPaciente paciente = session.load(BNPaciente.class, idPaciente);
		session.close();
		return paciente;
	}

	public int guardar(BNPaciente paciente) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(paciente);
		session.getTransaction().commit();
		session.close();
		return 0;
	}

}
