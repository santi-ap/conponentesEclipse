package com.ulatina.entity;

import com.ulatina.entity.Type;
import java.io.Serializable;
import java.lang.String;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Question
 *
 */
@Entity
@NamedQueries (value = {
		@NamedQuery(
				name = "Question.findAll", 
				query = "SELECT q FROM Question q"),
		@NamedQuery(
				name = "Question.findOne", 
				query = "SELECT q FROM Question q WHERE q.id = :param ")
})
public class Question implements Serializable {

	   
	@Id @GeneratedValue
	private int id;
	private String question;
	
	@OneToMany (mappedBy="question", cascade = CascadeType.MERGE)
	private Set<Choice> choiceList;
	
	@ManyToOne
	@JoinColumn(name = "type_id", referencedColumnName="id")
	private Type type;
	
	@OneToMany (mappedBy="question", cascade = CascadeType.MERGE)
	private Set<Answer> answerList;
	
	@ManyToOne
	@JoinColumn(name = "id_form", referencedColumnName="id")
	private Form form;
	
	private static final long serialVersionUID = 1L;

	public Question() {
		super();
	} 
	
	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
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
	public Set<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(Set<Answer> answerList) {
		this.answerList = answerList;
	}
   
}
