package kameleoon.model;
import java.time.LocalDateTime;

public class UserDto {

	String email;
	String login;
	String password;
	LocalDateTime date;
	
	
	public UserDto(String email, String login, String password, LocalDateTime date) {
		this.email = email;
		this.login = login;
		this.password = password;
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDate() {
		return date;
	}




	public void setDate(LocalDateTime date) {
		this.date = date;
	}




	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
