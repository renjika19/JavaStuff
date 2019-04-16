package com.fred.Dao;

import java.util.List;
import com.fred.beans.Book;


public interface BookDao {
	public Boolean insertBook(Book b);
	public Book selectBookById(Integer id);
	public List<Book> selectAllBook();
	public Boolean updateBookById(Integer id);

//		public void createTransaction();
//		public void deleteTransaction();
//		public void retrieveTransaction();	

	
}
