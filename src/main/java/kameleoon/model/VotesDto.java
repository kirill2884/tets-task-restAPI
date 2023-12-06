package kameleoon.model;

public class VotesDto {
	
	String idQuote;
	Integer like;
	Integer dislike;
	
	public VotesDto(String idQuote, Integer like, Integer dislike) {
		this.idQuote = idQuote;
		this.like = like;
		this.dislike = dislike;
	}
	
	
	public String getIdQuote() {
		return idQuote;
	}
	public void setIdQuote(String idQuote) {
		this.idQuote = idQuote;
	}
	public Integer getLike() {
		return like;
	}
	public void setLike(Integer like) {
		this.like = like;
	}
	public Integer getDislike() {
		return dislike;
	}
	public void setDislike(Integer dislike) {
		this.dislike = dislike;
	}
	
	

}
