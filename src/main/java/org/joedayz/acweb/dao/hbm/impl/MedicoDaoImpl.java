package org.joedayz.acweb.dao.hbm.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.joedayz.acweb.dao.MedicoDAO;
import org.joedayz.acweb.domain.BNMedico;

public class MedicoDaoImpl implements MedicoDAO {
	private SessionFactory sessionFactory;

	public MedicoDaoImpl() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}

	}

	public List<BNMedico> getListaMedicos() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<BNMedico> lista = session.createQuery("from BNMedico").list();
		session.close();
		return lista;
	}

	public List<BNMedico> getMedicosPorEspecialidad(String idEspecialidad) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<BNMedico> lista = session
				.createQuery("select m from BNMedico as m inner join BNEspecialidad as e "
						+ "on m.especialidad=e.coEspecialidad where e.coEspecialidad = :idEspecialidad")
				.setParameter("idEspecialidad", idEspecialidad).list();
		session.close();
		return lista;
	}

	public BNMedico getMedicoPorId(String idMedico) throws Exception {
		Session session = sessionFactory.openSession();
		BNMedico medico = session.load(BNMedico.class, idMedico);
		session.close();
		return medico;
	}

	public int guardar(BNMedico medico) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(medico);
		session.getTransaction().commit();
		session.close();
		return 1;
	}

}
