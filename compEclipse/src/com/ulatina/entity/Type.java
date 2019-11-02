package com.ulatina.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Type
 *
 */
@Entity

public class Type implements Serializable {

	   
	@Id
	private int id;
	private String type;
	private static final long serialVersionUID = 1L;

	public Type() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
   
}
