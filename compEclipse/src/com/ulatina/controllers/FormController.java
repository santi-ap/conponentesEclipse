package com.ulatina.controllers;

import java.util.List;
import javax.persistence.TypedQuery;
import com.ulatina.entity.Form;

@SuppressWarnings("finally")
public class FormController extends Controller {

	private TypedQuery<Form> query;
	private Form form;

	@Override
	public List<Form> selectAll() {
		try {
			this.startEntityManagerFactory();
			this.query = this.getEm().createNamedQuery("Form.findAll", Form.class);
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
			this.form = this.getEm().createNamedQuery("Form.findOne", Form.class).
					setParameter("param", Integer.parseInt(id)).getSingleResult();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.stopEntityManagerFactory();
			return this.form;
		}

	}

	@Override
	public void update(Object o) {
		if (o instanceof Form)
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
		if (o instanceof Form)
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
		if (o instanceof Form)
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
