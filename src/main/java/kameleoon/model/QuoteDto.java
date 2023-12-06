package kameleoon.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import kameleoon.entities.Votes;

public class QuoteDto {
	
	Long id;
	String score;
	String userId;
	LocalDateTime date;
	Integer likeCount;
	Integer dislikeCount;
	
	public QuoteDto(Long id, String score, String userId, LocalDateTime date, Integer likeCount, Integer dislikeCount) {
		this.id = id;
		this.score = score;
		this.userId = userId;
		this.date = date;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
	}
	
	
	
	public Integer getLikeCount() {
		return likeCount;
	}



	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}



	public Integer getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(Integer dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getScore() {
		return score;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	

}
