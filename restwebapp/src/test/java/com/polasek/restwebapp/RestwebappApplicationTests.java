package com.polasek.restwebapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.polasek.restwebapp.sentence.SentenceController;
import com.polasek.restwebapp.word.WordController;

@SpringBootTest
class RestwebappApplicationTests {

	@Autowired
	private WordController wordController;
	@Autowired
	private SentenceController sentenceController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(wordController).isNotNull();
		assertThat(sentenceController).isNotNull();
	}

}
