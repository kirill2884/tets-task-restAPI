package kameleoon.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import kameleoon.model.QuoteDto;

@Entity
@Table(name = "quotes")
public class Quote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	@Column
	String score;
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	User user;
	@Column
	LocalDateTime date;
	@OneToOne
	@JoinColumn(name = "votes_id")
	Votes votes;
	
	public Quote(String score, User user, LocalDateTime date, Votes votes) {
		this.score = score;
		this.user = user;
		this.date = date;
		this.votes = votes;
	}
	
	
	public static Quote of(QuoteDto dto, User user, Votes votes) {
		
		return new Quote(dto.getScore(), user, LocalDateTime.now(), votes);
	}
	
	public Quote() {
		
	}


	public static QuoteDto build(Quote quote) {
		
		return new QuoteDto(quote.id, quote.score, quote.user.login, quote.date, quote.votes.likeCount, quote.votes.dislikeCount);
	}

	

	public String getScore() {
		return score;
	}


	public void setScore(String score) {
		this.score = score;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public Votes getVotes() {
		return votes;
	}


	public void setVotes(Votes votes) {
		this.votes = votes;
	}


	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Quote [id=" + id + ", score=" + score + ", user=" + user + ", date=" + date + ", votes=" + votes + "]";
	}
	
	
	
}



