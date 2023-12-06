package kameleoon.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "votes")
public class Votes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long vId;
	@Column(name = "like_count")
	Integer likeCount;
	@Column(name = "dislike_count")
	Integer dislikeCount;
	
	public Votes(Integer likeCount, Integer dislikeCount) {
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
	}
	
	public Votes() {
		
	}
	
	public Integer incrementLike() {
		
		return ++this.likeCount;
	}
	
	public Integer incrementDislike() {
		
		return ++this.dislikeCount;
	}

	@Override
	public String toString() {
		return "Votes [id=" + vId + ", likeCount=" + likeCount + ", dislikeCount=" + dislikeCount + "]";
	}
	
	
	
	

	
	

}


