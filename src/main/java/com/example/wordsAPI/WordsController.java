package com.example.wordsAPI;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/words")
public class WordsController {

	private final WordsRepository repository;

	public WordsController(WordsRepository repository) {
		super();
		this.repository = repository;
	}
	
	//ADD WORD
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public void create(@RequestBody Word word) {
		repository.save(word);
	}
	
	//DELETE WORD
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		repository.delete(id);
	}
	
	//UPDATE WORD
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	public void update(@RequestBody Word word, @PathVariable Integer id) {
		if(!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
		}
		repository.save(word);
	}
	
	//FIND ONE WORD
	@GetMapping("/{id}")
	public Word findByID(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
	}
	
	//FIND ALL WORDS
	@GetMapping("")
	public List<Word> findAll() {
		return repository.findAll();
	}
	
	//FIND PALINDROMES
	@GetMapping("/palindromes")
	public List<Word> findPalindromes() {
		return repository.findPalindromes();
	}
	
	
	
	
}
