package kameleoon.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import kameleoon.entities.User;
import kameleoon.model.UserDto;
import kameleoon.repositories.UserRepository;
import kameleoon.services.interfaces.KameleoonLoginService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KameleoonLoginServiceImpl implements KameleoonLoginService {
	
	@Autowired
	UserRepository userRepo;
	
	
	@Override
	public UserDto login(UserDto userDto) {
		log.trace("Recived request for logIn for user with id: {}", userDto.getLogin());
		UserDto result = null;
		User user = userRepo.findById(userDto.getLogin()).orElse(null);
			if(user != null && userDto.getPassword().equals(user.getPassword())) {
				result = User.build(user);
				log.trace("logIn for user with id:{} success", userDto.getLogin());
			} else {
				throw new IllegalArgumentException("Wrong credential");
			}
		return result;
	}

	@Override
	public boolean signIn(UserDto userDto) {
		User user = userRepo.findById(userDto.getLogin()).orElse(null);
		if(user == null) {
			userRepo.save(User.of(userDto));
			return true;
		} else {
			throw new IllegalStateException("User already exist");
		}
	}
	
	@PostConstruct
	void initializationFirstUser() {
		User user = userRepo.save(new User("admin", "admin", "admin@kamelioon.com"));
		log.info("Initialization of first user with username:{} complite", user.getLogin());
	}

}
