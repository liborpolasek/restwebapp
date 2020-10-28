package com.polasek.restwebapp.client;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.polasek.restwebapp.sentence.Sentence;

@Service
public class SentenceServiceImpl {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${resource.sentences}")
    private String resource;
    @Value("${resource.sentences}/{id}")
    private String sentenceResource;
    @Value("${resource.sentences}/generate")
    private String generateResource;

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<Sentence> findAll() {
	    return Arrays.stream(restTemplate.getForObject(resource, Sentence[].class)).collect(Collectors.toList());
	}
	
	public Sentence create(Sentence s) {
	    return restTemplate.postForObject(generateResource, s, Sentence.class);
	}
}
