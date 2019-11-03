package com.ulatina.testers;

//import java.util.List;

import javax.persistence.*;


public class SantiTester {
	



		private static EntityManagerFactory entityManagerFactory = null;
		private static EntityManager em = null;

		public static void main(String[] args) {
			try {
				startEntityManagerFactory();
				
				
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
