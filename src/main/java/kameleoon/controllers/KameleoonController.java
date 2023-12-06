package kameleoon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kameleoon.model.QuoteDto;
import kameleoon.services.interfaces.KameleoonQuoteService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("quotes/")
@Slf4j
public class KameleoonController{

	@Autowired
	KameleoonQuoteService service;
	

	@GetMapping("{id}")
	public QuoteDto getQuote(@PathVariable Long id) {
		log.trace("Controller received request for quote whith id: {}", id);
		return service.getQuote(id);
	}

	@PostMapping("add")
	public QuoteDto addQuote(@RequestBody QuoteDto quoteDto) {
		log.trace("Controller received request for add quote: {}", quoteDto);
		return service.addQuote(quoteDto);
	}
	
	@PutMapping("{id}")
	public QuoteDto updateQuote(@PathVariable Long id, @RequestBody QuoteDto quoteDto) {
		log.trace("Controller received request for update quote with id: {}", id );
		return service.updateQuote(id, quoteDto);
	}
	
	@PutMapping("like/{id}")
	public QuoteDto addLike(@PathVariable Long id) {
		log.trace("Controller received request for add like to quote with id: {}", id);
		return service.setLike(id);
	}
	
	@PutMapping("dislike/{id}")
	public QuoteDto addDislike(@PathVariable Long id) {
		log.trace("Controller received request for add dislike to quote with id: {}", id);
		return service.setDislike(id);
	}
	
	@GetMapping("top")
	public List<QuoteDto> getTopQuotes(){
		log.trace("Controller received request for top quotes");
		return service.getTopQuotes();
	}
	
	@GetMapping("worst")
	public List<QuoteDto> getWorstQuotes(){
		log.trace("Controller received request for worst quotes");
		return service.getWorstQoutes();
	}
	
	@GetMapping("last/{userId}")
	public List<QuoteDto> getLastQuotes(@PathVariable String userId){
		log.trace("Controller received request for last quotes od user with id: {}", userId);
		return service.getLastQuotesByUser(userId);
	}
	
	@GetMapping("random")
	public QuoteDto getRandomQuotes(){
		log.trace("Controller received request for random quote");
		return service.getRandomQuote();
	}
	
	@DeleteMapping("{id}")
	public QuoteDto deleteQuote(@PathVariable Long id){
		log.trace("Controller received request for removing quote with if: {}", id);
		return service.deleteQuote(id);
	}
	
	

	
}
