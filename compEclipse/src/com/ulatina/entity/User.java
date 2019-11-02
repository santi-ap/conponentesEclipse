package com.ulatina.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	private String email;
	private String name;
	private String password;
	private ArrayList<Form> formList;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
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
	public ArrayList<Form> getFormList() {
		return formList;
	}
	public void setFormList(ArrayList<Form> formList) {
		this.formList = formList;
	}
   
}
