package com.ulatina.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Choice
 *
 */
@Entity

public class Choice implements Serializable {

	   
	@Id @GeneratedValue
	private int id;
	private String choice;
	private static final long serialVersionUID = 1L;
	
	@OneToMany (mappedBy="choice", cascade = CascadeType.ALL)
	private Set<Answer> answerList;

	@ManyToOne
	@JoinColumn(name = "question_id", referencedColumnName="id")
	private Question question;
	
	
	public Set<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(Set<Answer> answerList) {
		this.answerList = answerList;
	}
	public Choice() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
   
}
