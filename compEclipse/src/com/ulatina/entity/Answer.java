package com.ulatina.entity;

import com.ulatina.entity.Choice;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Answer
 *
 */
@Entity
@NamedQueries (value = {
		@NamedQuery(
				name = "Answer.findAll", 
				query = "SELECT a FROM Answer a"),
		@NamedQuery(
				name = "Answer.findOne", 
				query = "SELECT a FROM Answer a WHERE a.id = :param ")
})
public class Answer implements Serializable {

	   
	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name = "option_id", referencedColumnName="id")
	private Choice choice;
	private String answer;
	private int anonymous_id;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "question_id", referencedColumnName="id")
	private Question question;

	public Answer() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Choice getChoice() {
		return this.choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}   
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}   
	public int getAnonymous_id() {
		return this.anonymous_id;
	}

	public void setAnonymous_id(int anonymous_id) {
		this.anonymous_id = anonymous_id;
	}
   
}
