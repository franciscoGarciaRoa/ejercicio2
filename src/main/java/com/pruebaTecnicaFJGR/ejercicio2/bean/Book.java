package com.pruebaTecnicaFJGR.ejercicio2.bean;

import java.util.Comparator;
import java.util.Date;

public class Book {
	private Integer id;
	private String title;
	private Integer pages;
	private String summary;
	private Author author;
	private String publicationTimestamp;
	private Date publicationDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getPublicationTimestamp() {
		return publicationTimestamp;
	}
	public void setPublicationTimestamp(String publicationTimestamp) {
		this.publicationTimestamp = publicationTimestamp;
		
		if (publicationTimestamp != null && !publicationTimestamp.isBlank()) {
			Long publicationTimestampLong = Long.parseLong(publicationTimestamp);
			this.publicationDate = new Date(publicationTimestampLong*1000);			
		}
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", pages=" + pages + ", summary=" + summary + ", author="
				+ author + ", publicationTimestamp=" + publicationTimestamp + ", publicationDate=" + publicationDate
				+ "]";
	}
	
	public Book(Integer id, String title, Integer pages, String summary, Author author, String publicationTimestamp) {
		super();
		this.id = id;
		this.title = title;
		this.pages = pages;
		this.summary = summary;
		this.author = author;
		setPublicationTimestamp(publicationTimestamp);
	}
	
	public Book() {
		super();
	}

	
}
