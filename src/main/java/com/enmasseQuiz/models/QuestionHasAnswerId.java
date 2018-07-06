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
public class QuestionHasAnswerId implements Serializable {
	@Column(name = "question_id")
	private long questionId;
	
	@Column(name = "answer_id")
	private long answerId;
	
//	JPA
	@SuppressWarnings("unused")
	private QuestionHasAnswerId() {}

	public QuestionHasAnswerId(long questionId, long answerId) {
		this.questionId = questionId;
		this.answerId = answerId;
	}
	
//	Note: for the serializable, equals and hasCode better to be overwritten
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass()) 
            return false;
 
        QuestionHasAnswerId that = (QuestionHasAnswerId) o;
        return Objects.equals(this.questionId, that.questionId) && 
               Objects.equals(this.answerId, that.answerId);
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(this.questionId, this.answerId);
    }
}
