package com.fred.services;

import com.fred.beans.Book;

import java.util.List;

import com.fred.Dao.BookDao;
import com.fred.Dao.BookDaoImpl;


public class BookService {
	private BookDao bd = null;
	
	public Boolean addNewBook(Book b) {
		bd = new BookDaoImpl();
		return bd.insertBook(b);
	}

	public List<Book> getAllBooks(){
		bd = new BookDaoImpl();
		return bd.selectAllBook();
	}
	
	public Book getBooksById(Integer id){
		bd = new BookDaoImpl();
		return bd.selectBookById(id);
	}
	
	public Boolean deleteBookById(Integer id){
		bd = new BookDaoImpl();
		return bd.updateBookById(id);
	}

}
