/**
 * 
 */
package com.enmasseQuiz.models;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DiscriminatorFormula;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Quiz")
@Table(name = "quiz")
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
	@OneToMany(
		mappedBy = "quiz",
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	protected List<QuizHasAnswer> answers = new LinkedList<QuizHasAnswer>();
	
//	JPA
	protected Quiz() {}
	
	public Quiz(String quizType, String desc) {
		this.quizType = quizType;
		this.description = desc;
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
	
	public List<QuizHasAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<QuizHasAnswer> answers) {
		this.answers = answers;
	}
	
	public void clearAnswers() {
		this.answers = new LinkedList<QuizHasAnswer>();
	}
	
	public void appendAnswers(Answer ans, boolean isCorrect) {
		QuizHasAnswer qha = new QuizHasAnswer(this, ans, isCorrect);
		this.answers.add(qha);
		ans.getQuizes().add(qha);
	}
	
	@Override
	public String toString() {
		return "Question Id: " + this.id + "\nContent: " + this.description + "\nQuiz type: " + this.quizType;
	}
}
