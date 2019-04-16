package com.fred.main;

import java.util.List;

import com.fred.beans.Book;
import com.fred.services.BookService;

public class Driver {

	public static void main(String[] args) {

		System.out.println("====START====");
		BookService bs = new BookService();
		List<Book> bs1 = bs.getAllBooks();
		
		for(Book b: bs1) {
			System.out.println(b);
		}

	}

	
}
