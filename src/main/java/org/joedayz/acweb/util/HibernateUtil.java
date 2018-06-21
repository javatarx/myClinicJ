package org.joedayz.acweb.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	// Aplicando patrón Singleton

	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		try {
			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

			SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

			return sessionFactory;
		} catch (Throwable ex) {
			System.err.println("Error al crear la session, " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}

}
