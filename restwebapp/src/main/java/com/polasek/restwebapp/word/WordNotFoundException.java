package com.polasek.restwebapp.word;

public class WordNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3593097259939739501L;

	public WordNotFoundException(String word) {
		super("Could not find word " + word);
	}
	
}
