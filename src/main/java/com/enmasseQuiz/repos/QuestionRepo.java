/**
 * 
 */
package com.enmasseQuiz.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enmasseQuiz.models.Question;

/**
 * @author leoliu
 *
 */
@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{
	public List<Question> findQuestionByQuestionType(String questionType);
	
	@Query("select q from Question q where q.description like %:desc% and q.questionType = :type")
	public List<Question> findByDescAndTitle(@Param("desc") String desc,
												 @Param("type") String type);
}
