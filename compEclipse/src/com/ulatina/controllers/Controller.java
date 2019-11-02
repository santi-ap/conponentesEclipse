package com.ulatina.controllers;

import javax.persistence.Persistence;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class Controller implements ControllableEntity{
	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager em = null;
	
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
	
	@Override
	abstract public ArrayList<Object> selectAll();
	
	@Override
	abstract public Object selectRegister(String id);
	
	@Override
	abstract public void update(String whichColumn, String newValue, String primaryColumn, String certainValue);
	
	@Override
	abstract public void delete(String primaryColumn, String certanValue);
}
