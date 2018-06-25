/**
 * 
 */
package com.enmasseQuiz.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author leoliu
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class QuizHasAnswerId implements Serializable {
	@Column(name = "quiz_id")
	private long quizId;
	
	@Column(name = "answer_id")
	private long answerId;
	
//	JPA
	@SuppressWarnings("unused")
	private QuizHasAnswerId() {}

	public QuizHasAnswerId(long quizId, long answerId) {
		this.quizId = quizId;
		this.answerId = answerId;
	}
	
//	Note: for the serializable, equals and hasCode better to be overwritten
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) 
            return false;
 
        QuizHasAnswerId that = (QuizHasAnswerId) o;
        return Objects.equals(this.quizId, that.quizId) && 
               Objects.equals(this.answerId, that.answerId);
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(this.quizId, this.answerId);
    }
}
