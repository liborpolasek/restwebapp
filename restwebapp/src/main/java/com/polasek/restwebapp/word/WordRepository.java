package com.polasek.restwebapp.word;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Integer> {

	public Optional<Word> findByWord(String word);
	
	public List<Word> findByWordCategory(String wordCategory);
	
}
