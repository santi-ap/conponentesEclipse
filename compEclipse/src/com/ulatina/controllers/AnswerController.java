package com.ulatina.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import com.ulatina.entity.Answer;
@SuppressWarnings("finally")
public class AnswerController extends Controller {

	private TypedQuery<Answer> query;
	private Answer answer;

	@Override
	public List<Answer> selectAll() {
		try {
			this.startEntityManagerFactory();
			this.query = this.getEm().createNamedQuery("Answer.findAll", Answer.class);
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
			this.answer = this.getEm().createNamedQuery("Answer.findOne", Answer.class).
					setParameter("param", Integer.parseInt(id)).getSingleResult();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.stopEntityManagerFactory();
			return this.answer;
		}

	}

	@Override
	public void update(Object o) {
		if (o instanceof Answer)
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
		if (o instanceof Answer)
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
		if (o instanceof Answer)
		{
			try 
			{
				this.startEntityManagerFactory();
				
				this.getEm().getTransaction().begin();
				this.getEm().persist(o);
				this.getEm().getTransaction().commit();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.stopEntityManagerFactory();
			}
		}  else 
			System.out.print("Trying to use an invalid object, error.");
	}

}
