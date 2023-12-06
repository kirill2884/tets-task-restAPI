package kameleoon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kameleoon.model.UserDto;
import kameleoon.services.interfaces.KameleoonLoginService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("users/")
@Slf4j
public class KameleoonUserController {

	@Autowired
	KameleoonLoginService service;
	
	@PostMapping("login")
	public UserDto login(@RequestBody UserDto userDto) {
		log.trace("Controller received request for login of user whith id: {}", userDto.getLogin()); 
		return service.login(userDto); 
	}

	@PostMapping("signin")
	public boolean signIn(@RequestBody UserDto userDto) {
		log.trace("Controller received request for signIn of user: {}", userDto); 
		return service.signIn(userDto);
	}

}
