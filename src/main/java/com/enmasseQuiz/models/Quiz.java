/**
 * 
 */
package com.enmasseQuiz.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="quizType")
public abstract class Quiz {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	@JsonIgnore
	private long id;
	
	@NotNull
	protected String quizType;
	@NotNull
	protected String description;
	@Transient
	protected String[] answers;
	
//	Getter and setters
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQuizType() {
		return this.quizType;
	}
	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String[] getAnswers() {
		return this.answers;
	}
	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
	
}
