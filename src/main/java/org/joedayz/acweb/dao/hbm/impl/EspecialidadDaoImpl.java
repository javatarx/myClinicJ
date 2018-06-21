/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.joedayz.acweb.dao.hbm.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.joedayz.acweb.dao.EspecialidadDAO;
import org.joedayz.acweb.domain.BNEspecialidad;
import org.joedayz.acweb.util.HibernateUtil;

/**
 *
 * @author javatar
 */
public class EspecialidadDaoImpl implements EspecialidadDAO {

	private SessionFactory sessionFactory;

	public EspecialidadDaoImpl() {
		try {
			this.sessionFactory = HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			System.out.println("Error al obtener la sesion");
		}

	}

	public List<BNEspecialidad> getEspecialidades() throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery("from BNEspecialidad").list();
		for (BNEspecialidad e : (List<BNEspecialidad>) result) {
			System.out.println("Especialidad: " + e.getDeEspecialidad());
		}
		session.getTransaction().commit();
		session.close();
		return result;
	}

	public List<BNEspecialidad> getEspecialidadPorMedico(String idMedico) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("MEDICO");
		List result = session.createQuery(
				"select e from BNEspecialidad as e inner join BNMedico as m on m.especialidad=e.coEspecialidad where m.coMedico = :idMedico")
				.setParameter("idMedico", new Long(idMedico)).list();
		for (BNEspecialidad e : (List<BNEspecialidad>) result) {
			System.out.println("Especialidad: " + e.getDeEspecialidad());
		}
		session.getTransaction().commit();
		session.close();
		return result;
	}

	public BNEspecialidad getEspecialidadPorId(String idEspecialidad) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		BNEspecialidad especialidad = session.load(BNEspecialidad.class, idEspecialidad);
		session.close();
		return especialidad;
	}

	public int guardar(BNEspecialidad especialidad) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(especialidad);
		session.getTransaction().commit();
		session.close();
		return 1;
	}

}
