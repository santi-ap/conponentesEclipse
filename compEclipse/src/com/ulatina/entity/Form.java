package com.ulatina.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Set;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Form
 *
 */
@Entity
@NamedQueries (value = {
		@NamedQuery(
				name = "Form.findAll", 
				query = "SELECT f FROM Form f"),
		@NamedQuery(
				name = "Form.findOne", 
				query = "SELECT f FROM Form f WHERE f.id = :param ")
})
public class Form implements Serializable {

	   
	@Id @GeneratedValue
	private int id;
	private String title;
	@OneToMany (mappedBy="form", cascade = CascadeType.MERGE)
	private Set<Question> questionList;
	@ManyToOne
	@JoinColumn(name = "user_email", referencedColumnName="email")
	private User user;

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
	public Set<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(Set<Question> questionList) {
		this.questionList = questionList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
   
}
