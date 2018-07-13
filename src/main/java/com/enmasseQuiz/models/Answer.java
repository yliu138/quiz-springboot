/**
 * 
 */
package com.enmasseQuiz.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.validator.constraints.Length;

/**
 * @author leoliu
 *
 */

/**
 * 
 * The @NaturalId annotation allows us to fetch the Tag entity by its business key.
 * The @Cache annotation marks the cache concurrency strategy.
 * The @NaturalIdCache tells Hibernate to cache the entity identifier associated with a given business key.
 *
 */
@Entity(name = "Answer")
@Table(name = "answer")
@NaturalIdCache
@Cache(
	usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private long id;
	
	@Length(max=600, message="Content is too long")
	@NotEmpty(message = "Content is required")
	private String content;
	
	@OneToMany(
		mappedBy = "answer"
	)
	private List<QuestionHasAnswer> questionHasAnswer;
	
	@SuppressWarnings("unused")
	private Answer() {}

	public Answer(String content) {
		this.content = content;
		this.questionHasAnswer = new ArrayList<QuestionHasAnswer>();
	}

	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}
	
	public List<QuestionHasAnswer> getQuestions() {
		return questionHasAnswer;
	}

	public void setQuestions(List<QuestionHasAnswer> questionHasAnswer) {
		this.questionHasAnswer = questionHasAnswer;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer ans = (Answer) o;
        return Objects.equals(this.content, ans.content);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(this.content);
    }

	@Override
	public String toString() {
		return "Answer [id=" + id + ", content=" + content + ", quizes=" + this.questionHasAnswer + "]";
	}
}
