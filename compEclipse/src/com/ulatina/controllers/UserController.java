package com.ulatina.controllers;


import java.util.List;

import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import com.ulatina.entity.User;

@SuppressWarnings("finally")
public class UserController extends Controller {

	private TypedQuery<User> query;
	private User user;

	@Override
	public List<User> selectAll() {
		try {
			this.startEntityManagerFactory();
			this.query = this.getEm().createNamedQuery("User.findAll", User.class);
			return query.getResultList();
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			this.stopEntityManagerFactory();
			
		}
		return null;
	}

	@Override
	public Object selectRegister(String id) {
		try {
			this.startEntityManagerFactory();
			this.user = this.getEm().createNamedQuery("User.findOne", User.class).
					setParameter("param", id).getSingleResult();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.stopEntityManagerFactory();
			return this.user;
		}

	}

	@Override
	public void update(Object o) {
		if (o instanceof User)
		{
			try 
			{
				this.startEntityManagerFactory();

				this.getEm().getTransaction().begin();
				this.getEm().merge(o);
				this.getEm().getTransaction().commit();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.stopEntityManagerFactory();
			}
		} else 
			System.out.print("Trying to use an invalid object, error.");
	}

	@Override
	public void delete(Object o) {
		if (o instanceof User)
		{
			try {
				this.startEntityManagerFactory();

				this.getEm().getTransaction().begin();
				this.getEm().remove(this.getEm().contains(o) ? o : this.getEm().merge(o));
				this.getEm().getTransaction().commit();

				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.stopEntityManagerFactory();
			}
		} else 
			System.out.print("Trying to use an invalid object, error.");
	}

	@Override
	public void insert(Object o) {
		if (o instanceof User)
		{
			try 
			{
				this.startEntityManagerFactory();
				
				this.getEm().getTransaction().begin();
				this.getEm().persist(o);
				this.getEm().getTransaction().commit();
				
			} catch (PersistenceException e) {
				if (e.getCause() instanceof ConstraintViolationException) {
					ConstraintViolationException exception = (ConstraintViolationException) e.getCause();
					if (exception.getSQLException().getMessage().contains(" for key 'email'")) {
						System.out.println("this email is already register in our system.");
				
					} else {
						exception.printStackTrace();
					}
				} else {
					e.printStackTrace();
					
				}
				this.getEm().getTransaction().rollback();
				
			}
		}
	}
			
			
	public User loginClient(String email, String password) {
		User usuario = null;
		try {
			this.startEntityManagerFactory();
			Session session = this.getEm().unwrap(Session.class);
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("email", email));
			usuario = (User) criteria.uniqueResult();
			this.stopEntityManagerFactory();
		} catch (NonUniqueResultException e) {
			e.printStackTrace();
		}

		if (usuario == null) {
			System.out.println("user not register on our sysytem!");
		} else if (usuario.ValidPassword(password)) {
			System.out.println("Welcome " + usuario.getName());
		} else {
			System.out.println("invalid Password!");
		}
		
		return usuario;
	

}
}

