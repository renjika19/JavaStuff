package com.fred.Library;

import java.util.List;

import com.fred.Dao.BookDao;
import com.fred.beans.Book;

public class Member implements BookDao {
	protected String fname;
	protected String lname;
	protected String username;
	protected String password;
	protected String address;
	protected String phone;
	String memberType;
	int memberID;
	int member = 1000000;
	
	
	
	public Member(){
		super();
		memberID = member++;
	}
	
	
	
	public String getMemberType() {
		return memberType;
	}


	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}



	@Override
	public Boolean insertBook(Book b) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Book selectBookById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Book> selectAllBook() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Boolean updateBookById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}



	

}
