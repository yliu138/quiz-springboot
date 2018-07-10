package com.enmasseQuiz.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MCQ")
public class Mcq extends Question {
	
	public Mcq(String quesType, String desc) {
		super(quesType, desc);
	}
	
	@SuppressWarnings("unused")
	private Mcq() {
		super();
	}
	
	@Override
	public String toString() {
		return "MCQ: " + super.toString();
	}
}
