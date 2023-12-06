package kameleoon.repositories;


import org.springframework.data.repository.CrudRepository;

import kameleoon.entities.Votes;

public interface VotesRepository extends CrudRepository<Votes, Long> {

}
