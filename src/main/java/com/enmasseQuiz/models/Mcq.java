package com.enmasseQuiz.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MCQ")
public class Mcq extends Quiz {
	
	public Mcq(long quizId, String quizType, String desc) {
		super(quizId, quizType, desc);
	}
	
	@SuppressWarnings("unused")
	private Mcq() {
		super();
	}
	
	@Override
	public void appendAnswers(String ans) {
		this.answers.add(ans);
	}
}
