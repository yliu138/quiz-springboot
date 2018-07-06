/**
 * 
 */
package com.enmasseQuiz.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enmasseQuiz.models.Quiz;

/**
 * @author leoliu
 *
 */
@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long>{
	public List<Quiz> findQuizByQuizType(String quizType);
	
//	@Query(value = "SELECT * FROM quiz q where q.id = :id",
//			nativeQuery = true)
//	public Quiz getQuizByQuizId(@Param("id") long id);
}
