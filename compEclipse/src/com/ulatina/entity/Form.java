package com.ulatina.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Form
 *
 */
@Entity

public class Form implements Serializable {

	   
	@Id
	private int id;
	private String title;
	private ArrayList<Question> questionList;
	private static final long serialVersionUID = 1L;

	public Form() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(ArrayList<Question> questionList) {
		this.questionList = questionList;
	}
   
}
