/**
 * 
 */
package com.enmasseQuiz.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.enmasseQuiz.models.Question;
import com.enmasseQuiz.repos.QuizRepo;

/**
 * @author leoliu
 *
 */
@Component
public class QuizCommandRunner implements CommandLineRunner {
	
	@Autowired
	QuizRepo quizRepo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("=== Available services: ");
		for (Question q: this.quizRepo.findAll()) {
			System.out.println(q);
		}

		System.out.println(this.quizRepo.findQuizByQuizType("mcq"));

	}
	
}
