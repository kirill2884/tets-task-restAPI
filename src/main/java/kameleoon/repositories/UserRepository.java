package kameleoon.repositories;

import org.springframework.data.repository.CrudRepository;

import kameleoon.entities.User;

public interface UserRepository extends CrudRepository<User, String>{

}
