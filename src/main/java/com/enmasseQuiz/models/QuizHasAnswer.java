/**
 * 
 */
package com.enmasseQuiz.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author leoliu
 *
 */
@Entity(name = "QuizHasAnswer")
@Table(name = "quiz_has_answer")
public class QuizHasAnswer {
	
	@EmbeddedId
	private QuizHasAnswerId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("quizId")
	private Quiz quiz;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("answerId")
	private Answer answer;
	
	@NotNull
	@Column(name = "is_correct")
	private boolean isCorrect;
	
	@SuppressWarnings("unused")
	private QuizHasAnswer() {}

	public QuizHasAnswer(Quiz quiz, Answer answer, boolean isCorrect) {
		this.quiz = quiz;
		this.answer = answer;
		this.isCorrect = isCorrect;
		this.id = new QuizHasAnswerId(quiz.getId(), answer.getId());
	}

//	Getters and setters
	public QuizHasAnswerId getId() {
		return id;
	}

	public void setId(QuizHasAnswerId id) {
		this.id = id;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
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
		return "QuizHasAnswer [id=" + id + ", quiz=" + quiz + ", answer=" + answer + ", isCorrect=" + isCorrect + "]";
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        QuizHasAnswer that = (QuizHasAnswer) o;
        return Objects.equals(this.quiz, that.quiz) &&
        		Objects.equals(this.answer, that.answer);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(this.quiz, this.answer);
    }
}
