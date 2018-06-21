package org.joedayz.acweb.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	// Aplicando patrón Singleton

	private static SessionFactory sessionFactory;

	private static synchronized SessionFactory buildSessionFactory() {
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

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}

}
