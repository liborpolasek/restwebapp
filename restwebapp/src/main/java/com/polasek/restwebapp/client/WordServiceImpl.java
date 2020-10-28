package com.polasek.restwebapp.client;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.polasek.restwebapp.word.Word;

@Service
public class WordServiceImpl {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${resource.words}")
    private String resource;
    @Value("${resource.words}/{word}")
    private String wordResource;

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<Word> findAll() {
	    return Arrays.stream(restTemplate.getForObject(resource, Word[].class)).collect(Collectors.toList());
	}
	
	public Word create(String word, Word w) {
	    return restTemplate.postForObject(wordResource, w, Word.class, word);
	}
}
