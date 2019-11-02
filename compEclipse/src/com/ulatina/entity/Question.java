package com.ulatina.entity;

import com.ulatina.entity.Type;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Question
 *
 */
@Entity

public class Question implements Serializable {

	   
	@Id
	private int id;
	private String question;
	private Type type;
	private ArrayList<Answer> answerList;
	private static final long serialVersionUID = 1L;

	public Question() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}   
	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	public ArrayList<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(ArrayList<Answer> answerList) {
		this.answerList = answerList;
	}
   
}
