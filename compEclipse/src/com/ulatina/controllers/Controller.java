package com.ulatina.controllers;

import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class Controller{
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
	
	/**
	 * This method will return a list of all the registers in a table. Each item in the list will be saved as an object
	 * @return a list of all the registers in a table. Each item in the list will be saved as an object
	 */
	abstract public List<?> selectAll();
	
	/**
	 * This method is used to select everything from one register, specified by the primary key
	 * @param id primary key
	 * @return an object which contains all the attributes(columns) of the chosen register
	 */
	abstract public Object selectRegister(String id);

	/**
	 * 
	 * @param o object that needs updating
	 */
	abstract public void update(Object o);
	
	/**
	 * 
	 * @param o object to be deleted
	 */
	abstract public void delete(Object o);
	
	/**
	 * 
	 * @param o the object to be added
	 */
	abstract public void insert (Object o);
}
