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

@Entity(name = "Question")
@Table(name = "question")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorFormula(
		"CASE WHEN question_type='mcq' THEN 'MCQ' " +
		"WHEN question_type='paragraph' THEN 'PARAGRAPH' END"
)
public abstract class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	@JsonIgnore
	private long id;
	
	@NotNull
	@Column(name = "question_type")
	private String questionType;
	@NotNull
	private String description;
	@OneToMany(
		mappedBy = "question",
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	protected List<QuestionHasAnswer> questionHasAnswer;
	
//	JPA
	protected Question() {}
	
	public Question(String questionType, String desc) {
		this.questionType = questionType;
		this.description = desc;
		this.questionHasAnswer = new LinkedList<QuestionHasAnswer>();
	}
	
//	Getter and setters
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getQuestionType() {
		return this.questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<QuestionHasAnswer> getQuestionHasAnswer() {
		return questionHasAnswer;
	}

	public void setQuestionHasAnswer(List<QuestionHasAnswer> questionHasAnswer) {
		this.questionHasAnswer = questionHasAnswer;
	}
	
	public void clearQuestionHasAnswer() {
		this.questionHasAnswer = new LinkedList<QuestionHasAnswer>();
	}
	
	public void appendQuestionHasAnswer(Answer ans, boolean isCorrect) {
		QuestionHasAnswer qha = new QuestionHasAnswer(this, ans, isCorrect);
		this.questionHasAnswer.add(qha);
		ans.getQuestions().add(qha);
	}
	
	@Override
	public String toString() {
		return "Question Id: " + this.id + "\nContent: " + this.description + "\nquestion type: " + this.questionType + "\nquestionHasAnswer: " + this.questionHasAnswer;
	}
}
