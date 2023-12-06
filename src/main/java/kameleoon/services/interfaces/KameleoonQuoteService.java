package kameleoon.services.interfaces;

import java.util.List;

import kameleoon.model.QuoteDto;

public interface KameleoonQuoteService {
	
	QuoteDto getRandomQuote();
	List<QuoteDto> getTopQuotes();
	List<QuoteDto> getWorstQoutes();
	QuoteDto getQuote(Long id);
	List<QuoteDto> getLastQuotesByUser(String userId);
	QuoteDto updateQuote(Long id, QuoteDto quoteDto);
	QuoteDto addQuote(QuoteDto quoteDto);
	QuoteDto setLike(Long id);
	QuoteDto setDislike(Long id);
	QuoteDto deleteQuote(Long id);

}
