package com.polasek.restwebapp.sentence;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polasek.restwebapp.word.Word;
import com.polasek.restwebapp.word.WordRepository;

@RestController
public class SentenceController {
	
	private final SentenceRepository sentenceRepository;
	private final WordRepository wordRepository;
	
	public SentenceController(SentenceRepository sentenceRepository, WordRepository wordRepository) {
		this.sentenceRepository = sentenceRepository;
		this.wordRepository = wordRepository;
	}
	
	@GetMapping(value = "/sentences")
	public List<Sentence> getSentences() {
		return sentenceRepository.findAll();
	}
	
	@PostMapping(value = "/sentences/generate")
	public Sentence generateSentence() {
		Random rand = new Random();
		List<Word> nouns = wordRepository.findByWordCategory("NOUN");
		List<Word> verbs = wordRepository.findByWordCategory("VERB");
		List<Word> adjectives = wordRepository.findByWordCategory("ADJECTIVE");
		
		String noun = nouns.get(rand.nextInt(nouns.size())).getWord();
		String verb = verbs.get(rand.nextInt(verbs.size())).getWord();
		String adjective = adjectives.get(rand.nextInt(adjectives.size())).getWord();
		
		Sentence s = new Sentence();
		s.setText(noun + " " + verb + " " + adjective);
		s.setYodaTalk(adjective + " " + noun + " " + verb);
		s.setDateTime(LocalDateTime.now());
		return sentenceRepository.save(s);
	}
	
	@GetMapping(value = "/sentences/{sentenceID}")
	public Sentence getSentence(@PathVariable int sentenceID) {
		Sentence s = sentenceRepository.findById(sentenceID).get();
		s.increaseNumberOfViews();
		return sentenceRepository.save(s);
	}
	
	@GetMapping(value = "/sentences/{sentenceID}/yodaTalk")
	public String getYodaTalk(@PathVariable int sentenceID) {
		return sentenceRepository.findById(sentenceID).get().getYodaTalk();
	}

}
