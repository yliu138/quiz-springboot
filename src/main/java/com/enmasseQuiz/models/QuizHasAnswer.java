/**
 * 
 */
package com.enmasseQuiz.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

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
	
}
