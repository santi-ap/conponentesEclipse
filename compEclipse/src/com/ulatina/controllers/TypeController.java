package com.ulatina.controllers;

import java.util.List;
import javax.persistence.TypedQuery;
import com.ulatina.entity.Type;

@SuppressWarnings("finally")
public class TypeController extends Controller {

	private TypedQuery<Type> query;
	private Type type;

	@Override
	public List<Type> selectAll() {
		try {
			this.startEntityManagerFactory();
			this.query = this.getEm().createNamedQuery("Type.findAll", Type.class);
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
			this.type = this.getEm().createNamedQuery("Type.findOne", Type.class).
					setParameter("param", Integer.parseInt(id)).getSingleResult();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.stopEntityManagerFactory();
			return this.type;
		}

	}

	@Override
	public void update(Object o) {
		if (o instanceof Type)
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
		if (o instanceof Type)
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
		if (o instanceof Type)
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
