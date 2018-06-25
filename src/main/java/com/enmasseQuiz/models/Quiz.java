/**
 * 
 */
package com.enmasseQuiz.models;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DiscriminatorFormula;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Quiz")
@Table(name = "table")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorFormula(
		"CASE WHEN quizType='mcq' THEN 'MCQ' " +
		"WHEN quizType='paragraph' THEN 'PARAGRAPH' END"
)
public abstract class Quiz {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	@JsonIgnore
	private long id;
	
	@NotNull
	private String quizType;
	@NotNull
	private String description;
	@Transient
	protected List<String> answers;
	
//	JPA
	protected Quiz() {
		this.answers = new LinkedList<String>();
	}
	
	public Quiz(long quizId, String quizType, String desc) {
		this.id = quizId;
		this.quizType = quizType;
		this.description = desc;
		this.answers = new LinkedList<String>();
	}
	
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
	
	public List<String> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	
	public void clearAnswers() {
		this.answers = new LinkedList<String>();
	}
	
//	Abstract methods
	public abstract void appendAnswers(String ans);
	
	@Override
	public String toString() {
		return "Question Id: " + this.id + "\nContent: " + this.description + "\nQuiz type: " + this.quizType;
	}
}
