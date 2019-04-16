package com.fred.Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.fred.util.CloseStreams.close;
import com.fred.util.ConnectionUtil;
import com.fred.beans.Book;
import com.fred.Dao.BookDao;

public class BookDaoImpl implements BookDao {

	@Override
	public Boolean insertBook(Book b) {
		PreparedStatement stmt = null;

		
		try(Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("INSERT INTO BOOKS VALUES(?,?,?)");

		
			stmt.setInt(1, b.getBook_ID());
			stmt.setString(2, b.getTitle());
			stmt.setString(3, b.getAuthor());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			close(stmt);
		}
		return true;
		
	}

	@Override
	public Book selectBookById(Integer id) {
		Statement stmt = null;
		ResultSet rs = null;
		Book booka = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			stmt = conn.createStatement(); 
			rs= stmt.executeQuery("SELECT * FROM BOOKS WHERE BOOK_id ="+id);
			if(rs.next()) {
				booka = new Book(
						rs.getInt("book_Id"), // grab data by name
						rs.getString("title"), // or we can grab by index
						rs.getString("author")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return booka;

	}

	@Override
	public List<Book> selectAllBook() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Book> bookas = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			stmt = conn.createStatement(); // create a statement
			//object from the connection
			//statement objects can exectue sql queries connected
			//to DB
			
			rs = stmt.executeQuery("SELECT * FROM BOOKS");
			/*
			 * ResultSet stores all the records from the successful
			 * query
			 */
			while(rs.next()) {
				bookas.add(new Book(
						rs.getInt("book_Id"), // grab data by name
						rs.getString("title"), // or we can grab by index
						rs.getString("author")
						));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return bookas;

	}



	@Override
	public Boolean updateBookById(Integer id) {
		PreparedStatement stmt = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("DELETE FROM BOOKS WHERE book_id = ?"); 
			stmt.setInt(1, id);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			close(stmt);
		}
		return true;

	
	}
	

}
