package com.fred.Library;

public class Patron {
	private Member account;

	public Patron(Member account) {
		this.account = account;
	}
	

	@Override
	public String toString() {
		return "Member Information" + 
				account;
    }
}
