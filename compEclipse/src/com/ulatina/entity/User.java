package com.ulatina.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@NamedQueries (value = {
		@NamedQuery(
				name = "User.findAll", 
				query = "SELECT u FROM User u"),
		@NamedQuery(
				name = "User.findOne", 
				query = "SELECT u FROM User u WHERE u.email = :param ")
})
public class User implements Serializable {

	   
	@Id
	private String email;
	private String name;
	private String password;
	@OneToMany (fetch = FetchType.EAGER, mappedBy="user", cascade = CascadeType.MERGE)
	private Set<Form> formList;
	private static final long serialVersionUID = 1L;

	public User() {
		this.setFormList(new HashSet<Form>());
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public boolean ValidPassword(String password) {
		return this.password.equals(password);
	}
	public Set<Form> getFormList() {
		return formList;
	}
	public void setFormList(Set<Form> formList) {
		this.formList = formList;
	}
   
}
