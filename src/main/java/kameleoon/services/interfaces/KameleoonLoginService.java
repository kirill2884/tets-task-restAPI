package kameleoon.services.interfaces;

import kameleoon.model.UserDto;

public interface KameleoonLoginService {
	
	UserDto login(UserDto userSto);
	boolean signIn(UserDto userDto);

}
