package com.fred.beans;

public class Book {
	private Integer book_ID;
	private String title;
	private String author;
	
	public Book() {
		super();
	}
	
	public Book(Integer book_ID, String title, String author ) {
		super();
		this.book_ID = book_ID;
		this.title = title;
		this.author = author;

	}
	
	public Book( String title, String author ) {
		super();
		this.title = title;
		this.author = author;

	}

	public Integer getBook_ID() {
		return book_ID;
	}

	public void setBook_ID(Integer book_ID) {
		this.book_ID = book_ID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [book_ID=" + book_ID + ", title=" + title + ", author=" + author + "]";
	}

}
