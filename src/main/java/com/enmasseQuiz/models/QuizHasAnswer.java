/**
 * 
 */
package com.enmasseQuiz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author leoliu
 *
 */
@Entity
public class QuizHasAnswer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	@JsonIgnore
	private long id;
	
	@NotNull
	private long quizId;
	
	@NotNull
	private long answerId;
	
	@NotNull
	private boolean isCorrect;
	
	//JPA
	protected QuizHasAnswer() {};
	
	public QuizHasAnswer(long id, long quizId, long answerId, boolean isCorrect) {
		this.id = id;
		this.quizId = quizId;
		this.answerId = answerId;
		this.isCorrect = isCorrect;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuizId() {
		return quizId;
	}

	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}

	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return "QuizHasAnswer [id=" + id + ", quizId=" + quizId + ", answerId=" + answerId + ", isCorrect=" + isCorrect
				+ "]";
	}
}
