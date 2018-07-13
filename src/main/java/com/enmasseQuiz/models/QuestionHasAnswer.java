/**
 * 
 */
package com.enmasseQuiz.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author leoliu
 *
 */
@Entity(name = "QuestionHasAnswer")
@Table(name = "question_has_answer")
public class QuestionHasAnswer implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "answer_id")
	private Answer answer;
	
	@NotNull
	@Column(name = "is_correct")
	private boolean isCorrect;
	
	@SuppressWarnings("unused")
	private QuestionHasAnswer() {}

	public QuestionHasAnswer(Question question, Answer answer, boolean isCorrect) {
		this.question = question;
		this.answer = answer;
		this.isCorrect = isCorrect;
	}

//	Getters and setters
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return "QuestionHasAnswer [question=" + question + ", answer=" + answer + ", isCorrect=" + isCorrect + "]";
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        QuestionHasAnswer that = (QuestionHasAnswer) o;
        return Objects.equals(this.question, that.question) &&
        		Objects.equals(this.answer, that.answer);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(this.question, this.answer);
    }
}
