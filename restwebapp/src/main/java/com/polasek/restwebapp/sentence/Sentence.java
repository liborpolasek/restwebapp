package com.polasek.restwebapp.sentence;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sentence {

	private String text;
	private String yodaTalk;
	private @Id @GeneratedValue int id;
	private LocalDateTime dateTime;
	private int numberOfViews;

	public Sentence() {
	}
	
	public Sentence(String text, LocalDateTime dateTime) {
		this.text = text;
		this.dateTime = dateTime;
		this.numberOfViews = 0;
	}
	
	public Sentence(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getYodaTalk() {
		return yodaTalk;
	}

	public void setYodaTalk(String yodaTalk) {
		this.yodaTalk = yodaTalk;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public int getNumberOfViews() {
		return numberOfViews;
	}
	
	public void setNumberOfViews(int numberOfViews) {
		this.numberOfViews = numberOfViews;
	}
	
	public void increaseNumberOfViews() {
		this.numberOfViews++;
	}
	
	@Override
	public String toString() {
		return "{ " + "Sentence{" + "text=" + this.text + ", showDisplayCount='" + this.numberOfViews + '}' + '}';
	}
}
