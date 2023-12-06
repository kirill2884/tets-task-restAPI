package kameleoon.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import kameleoon.model.UserDto;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	String login;
	String password;
	String email;
	LocalDateTime date;
	

	
	public User(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
		this.date = LocalDateTime.now();
	}



	public User() {
		
	}

	public static User of(UserDto dto) {

		return new User(dto.getLogin(), dto.getPassword(), dto.getEmail());
	}
	
	public static UserDto build(User user) {
		
		return new UserDto(user.login, user.password, user.email, user.date);
	}



	public String getLogin() {
		return login;
	}


	public String getPassword() {
		return password;
	}



	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", email=" + email + ", date=" + date + "]";
	}
	
	
	
	
}
