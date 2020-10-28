package com.polasek.restwebapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.polasek.restwebapp.word.WordController;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.json;

@SpringBootTest
public class WordControllerTests {
	
	@LocalServerPort
	private int port;

	@Autowired
	private WordController wordController;
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(wordController).isNotNull();
	}
	
	@Test
	public void returnsList() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:"
				+ port + "/words", String.class));
		
	}

}
