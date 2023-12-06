package kameleoon.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kameleoon.entities.Quote;
import kameleoon.entities.User;
import kameleoon.entities.Votes;
import kameleoon.exception.NotFoundException;
import kameleoon.model.IdQuote;
import kameleoon.model.QuoteDto;
import kameleoon.repositories.QuotesRepository;
import kameleoon.repositories.UserRepository;
import kameleoon.repositories.VotesRepository;
import kameleoon.services.interfaces.KameleoonQuoteService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(readOnly = true)
public class KameleoonQuoteServiceImpl implements KameleoonQuoteService {

	@Autowired
	QuotesRepository quoteRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	VotesRepository votesRepo;
	
	@Override
	public QuoteDto getRandomQuote() {
			
		List<IdQuote> listIds = quoteRepo.findIds();
		int randomIndex = getRandomNumber(0,listIds.size());
		Quote quote = quoteRepo.findById(listIds.get(randomIndex).getId()).orElse(null);
		
		return quote != null ? Quote.build(quote) : null;
	}

	private int getRandomNumber(int min, int max) {
		
		return new Random().nextInt(min,max);
	}

	@Override
	@Transactional(readOnly=false)
	public QuoteDto addQuote(QuoteDto quoteDto) {
		User user = userRepo.findById(quoteDto.getUserId()).orElse(null);
		Quote quote = null;
		if (user != null) {
			Votes votes = votesRepo.save(new Votes(0, 0));
			quote = quoteRepo.save(Quote.of(quoteDto, user, votes));
		} else {
			throw new IllegalArgumentException("Wrong user");
		}
		return quote != null ? Quote.build(quote) : null;
	}

	@Override
	public QuoteDto getQuote(Long id) {
		log.trace("Recived request for gettind quote with id: {}", id);
		Quote quote = quoteRepo.findById(id).orElse(null);
		log.trace("Quote with id {}: {}", id, quote);
		return quote != null ? Quote.build(quote) : null;
	}
	
	@Override
	public List<QuoteDto> getTopQuotes() {
		log.trace("Recived request for top quotes");
		List<Quote> list = quoteRepo.findTopQuotes(10);
		log.trace("Recived 10 top quotes: {}", list);
		return list.stream().map((quote) -> Quote.build(quote)).toList();
	}

	@Override
	public List<QuoteDto> getWorstQoutes() {
		log.trace("Recived request for worst quotes");
		List<Quote> list = quoteRepo.findWorstQuotes(10);
		log.trace("Recived 10 worst quotes: {}", list);
		return list.stream().map((quote) -> Quote.build(quote)).toList();
	}

	@Override
	@Transactional(readOnly=false)
	public QuoteDto setLike(Long id) {
		log.trace("Recived request for like to quote whith id: {}", id);
		Quote quote = quoteRepo.findById(id).orElse(null);
		if (quote != null) {
			Votes votes = quote.getVotes();
			votes.incrementLike();
			votesRepo.save(votes);
			log.trace("Like to quote whith id: {} added", id);
		}
		
		return Quote.build(quote);
	}

	@Override
	@Transactional(readOnly=false)
	public QuoteDto setDislike(Long id) {
		log.trace("Recived request for dislike to quote whith id: {}", id);
		Quote quote = quoteRepo.findById(id).orElse(null);
		if (quote != null) {
			try {
				Votes votes = quote.getVotes();
				votes.incrementDislike();
				votesRepo.save(votes);
				log.trace("Dislike to quote whith id: {} added", id);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return Quote.build(quote);
	}

	@Override
	@Transactional(readOnly=false)
	public QuoteDto updateQuote(Long id, QuoteDto quoteDto) {
		log.trace("Recived request for update quote whith id: {}", id);
		Quote quote = quoteRepo.findById(id).orElse(null);
		if (quote != null) {
			quote.setDate(LocalDateTime.now());
			quote.setScore(quoteDto.getScore());
			quote = quoteRepo.save(quote);
			log.trace("Quote whith id: {} updated. New quote: {}", id, quote);
		} else {
			throw new NotFoundException ("Quote with id: " + id + " not found");
		}
		return Quote.build(quote);
	}

	@Override
	@Transactional(readOnly=false)
	public QuoteDto deleteQuote(Long id) {
		log.trace("Recived request for delete quote with id: {}", id);
		Quote quote = quoteRepo.findById(id).orElse(null);
		if (quote != null) {
			quoteRepo.delete(quote);
			log.trace("Quote with id: {} removed", id);
		}else {
			throw new NotFoundException ("Quote with id: " + id + " not found");
		}
		
		return Quote.build(quote);
	}

	@Override
	public List<QuoteDto> getLastQuotesByUser(String userId) {	
		log.trace("Recived request for getiing last 5 quotes of user with id: {}", userId);
		List<Quote> list = quoteRepo.findLastQuotes(5, userId);
		log.trace("Recived quotes: {}", list);
		
		return list.stream().map((quote) -> Quote.build(quote)).toList();
	}

}
