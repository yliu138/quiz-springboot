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
@DiscriminatorValue("paragraph")
public class Paragraph extends Quiz {

//	didn't do anything here as the paragraph quiz won't have any answers
	@Override
	public void appendAnswers(String ans) {
		//do nothing here
	}
	
	@Override
	public void setAnswers(List<String> answers) {
		//Do nothing here
	}

}
