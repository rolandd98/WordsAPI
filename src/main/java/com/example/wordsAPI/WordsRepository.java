package com.example.wordsAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class WordsRepository {

	private final List<Word> wordList = new ArrayList<>();

	public WordsRepository() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void save(Word word) {
		wordList.removeIf(w -> w.id().equals(word.id()));
		wordList.add(word);
		
	}
	
	public Optional<Word> findById(Integer id) {
		return wordList.stream().filter(w -> w.id().equals(id)).findFirst();
	}
	
	public List<Word> findAll() {
		return wordList;
	}

	public void delete(Integer id) {
		wordList.removeIf(w -> w.id().equals(id));
	}
	
	public boolean existsById(Integer id) {
		return wordList.stream().filter(w -> w.id().equals(id)).count() == 1;
	}
	
	public List<Word> findPalindromes() {
		return wordList.stream().filter(w -> WordsUtils.isPalindrome(w.value())).toList();	
	}
	
	@PostConstruct
	private void init() {
		Word word = new Word(1, "ABBA");
		wordList.add(word);
	}

}
