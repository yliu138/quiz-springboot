/**
 * 
 */
package com.enmasseQuiz.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enmasseQuiz.models.Quiz;

/**
 * @author leoliu
 *
 */
@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long>{
	List<Quiz> findQuizByQuizType(String quizType);
}
