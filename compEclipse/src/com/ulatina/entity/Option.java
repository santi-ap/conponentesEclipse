package com.ulatina.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Option
 *
 */
@Entity

public class Option implements Serializable {

	   
	@Id
	private int id;
	private String option;
	private static final long serialVersionUID = 1L;

	public Option() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
   
}
