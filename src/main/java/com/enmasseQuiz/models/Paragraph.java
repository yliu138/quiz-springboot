/**
 * 
 */
package com.enmasseQuiz.models;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author leoliu
 *
 */
@Entity
@DiscriminatorValue("PARAGRAPH")
public class Paragraph extends Quiz {

//	didn't do anything here as the paragraph quiz won't have any answers
	@Override
	public void appendAnswers(Answer ans, boolean isCorrect) {
		//do nothing here
	}
	
	@Override
	public void setAnswers(List<QuizHasAnswer> answers) {
		//Do nothing here
	}
	
	@Override
	public String toString() {
		return "Paragraph: " + super.toString();
	}

}
