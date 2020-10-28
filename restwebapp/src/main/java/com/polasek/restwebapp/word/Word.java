package com.polasek.restwebapp.word;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Word {

	private String word;
	private  @Id @GeneratedValue int id;
	private String wordCategory;
	
	public Word() {
		
	}
	
	public Word(String word, String wordCategory) {
		this.word = word;
		this.wordCategory = wordCategory;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getWordCategory() {
		return wordCategory;
	}
	
	public void setWordCategory(String wordCategory) {
		this.wordCategory = wordCategory;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
		    return true;
		if (!(o instanceof Word))
			return false;
		Word w = (Word) o;
		return Objects.equals(this.word, w.word) && Objects.equals(this.wordCategory, w.wordCategory);
	}	
	
	
	@Override
	public String toString() {
		return "{ " + "word:" + '{' + "word=" + this.word + " wordCategory:" + this.wordCategory + '}' + '}';
	}
	
}
