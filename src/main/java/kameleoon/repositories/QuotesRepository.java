package kameleoon.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kameleoon.entities.Quote;
import kameleoon.model.IdQuote;

import java.util.List;


public interface QuotesRepository extends CrudRepository<Quote, Long> {
	
	@Query(value = "SELECT * "
					+ "FROM quotes q "
					+ "JOIN votes v ON v.v_id = q.votes_id "
					+ "ORDER BY v.like_count desc "
					+ "LIMIT :count", nativeQuery = true)
	List<Quote> findTopQuotes(int count);
	
	@Query(value = "SELECT * "
					+ "FROM quotes q "
					+ "JOIN votes v ON v.v_id = q.votes_id "
					+ "ORDER BY v.dislike_count desc "
					+ "LIMIT :count", nativeQuery = true)
	List<Quote> findWorstQuotes(int count);
	
	@Query(value = "SELECT q.id "
					+ "FROM quotes q", nativeQuery = true)
	List<IdQuote> findIds();
	
	@Query(value = "SELECT * "
				+ "FROM quotes "
				+ "WHERE "
				+ "user_id = :userId "
				+ "ORDER BY "
				+ "date desc "
				+ "LIMIT :count", nativeQuery = true)
	List<Quote> findLastQuotes(int count, String userId);
}
