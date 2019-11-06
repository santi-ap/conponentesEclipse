package com.ulatina.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Choice
 *
 */
@Entity
@NamedQueries (value = {
		@NamedQuery(
				name = "Choie.findAll", 
				query = "SELECT c FROM Choice c"),
		@NamedQuery(
				name = "Choice.findOne", 
				query = "SELECT c FROM Choice c WHERE c.id = :param ")
})
public class Choice implements Serializable {

	   
	@Id @GeneratedValue
	private int id;
	private String choice;
	private static final long serialVersionUID = 1L;
	
	@OneToMany (fetch = FetchType.EAGER, mappedBy="choice", cascade = CascadeType.MERGE)
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
		this.setAnswerList(new HashSet<Answer>());
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
