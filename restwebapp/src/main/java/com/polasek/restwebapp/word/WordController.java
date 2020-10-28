package com.polasek.restwebapp.word;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.polasek.restwebapp.sentence.SentenceRepository;

@RestController
public class WordController {
	
	private final WordRepository wordRepository;
	
	public WordController(SentenceRepository sentenceRepository, WordRepository wordRepository) {
		this.wordRepository = wordRepository;
		Word temp = new Word();
	    temp.setId(1);
	    temp.setWord("power");
	    temp.setWordCategory("NOUN");
	    wordRepository.save(temp);
	      
	    temp = new Word();
	    temp.setId(2);
	    temp.setWord("is");
	    temp.setWordCategory("VERB");
	    wordRepository.save(temp);
	      
	    temp = new Word();
	    temp.setId(3);
	    temp.setWord("fantastic");
	    temp.setWordCategory("ADJECTIVE");
	    wordRepository.save(temp);
	      
	    temp = new Word();
	    temp.setId(4);
	    temp.setWord("poor");
	    temp.setWordCategory("ADJECTIVE");
	    wordRepository.save(temp);
	      
	    temp = new Word();
	    temp.setId(5);
	    temp.setWord("clean");
	    temp.setWordCategory("ADJECTIVE");
	    wordRepository.save(temp);
	      
	    temp = new Word();
	    temp.setId(6);
	    temp.setWord("book");
	    temp.setWordCategory("NOUN");
	    wordRepository.save(temp);
	    
	    temp = new Word();
	    temp.setId(7);
	    temp.setWord("wood");
	    temp.setWordCategory("NOUN");
	    wordRepository.save(temp);
	    
	    temp = new Word();
	    temp.setId(8);
	    temp.setWord("get");
	    temp.setWordCategory("VERB");
	    wordRepository.save(temp);
	}
	
	@GetMapping(value = "/words")
	public List<Word> getWords() {
		return wordRepository.findAll();
	}
	
	@PostMapping(value = "/words/{word}")
	public Word addWord(@PathVariable String word, @RequestBody Word w) {
		w.setWord(word);
		return wordRepository.save(w);
	}

	@GetMapping(value = "/words/{word}")
	public Optional<Word> getWord(@PathVariable String word) {
		return Optional.ofNullable(wordRepository.findByWord(word)
				.orElseThrow(() -> new WordNotFoundException(word)));
	}
	
}
