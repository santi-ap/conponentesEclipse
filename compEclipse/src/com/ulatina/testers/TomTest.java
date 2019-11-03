package com.ulatina.testers;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.ulatina.entity.Form;
import com.ulatina.entity.Choice;
import com.ulatina.entity.User;

public class TomTest {
		private static EntityManagerFactory entityManagerFactory = null;
		private static EntityManager em = null;

		public static void main(String[] args) {
			try {
				startEntityManagerFactory();
				Choice op = new Choice();
				
				// Insertar
				em.getTransaction().begin();
				em.persist(op);
				em.getTransaction().commit();
			System.out.print("Stopping...");

				stopEntityManagerFactory();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		
		
		public static void startEntityManagerFactory() {
			if (entityManagerFactory == null) {
				try {
					entityManagerFactory = Persistence
							.createEntityManagerFactory("compEclipse");
					em = entityManagerFactory.createEntityManager();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		public static void stopEntityManagerFactory() {
			if (entityManagerFactory != null) {
				if (entityManagerFactory.isOpen()) {
					try {
						entityManagerFactory.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				em.close();
				entityManagerFactory = null;
			}
		}

	}

