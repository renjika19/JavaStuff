package com.fred.Library;

public class FacultyMember extends Member {
	private final String memberType = "Faculty";
	private static int memberID;
	static int number = 2000000;
	
	FacultyMember() {
		while (member < number) {
			member++;
		}
	}
	
	public static int getMemberID() {
		return memberID;
	}
	
	
	public static void setMemberID(int memberID) {
		FacultyMember.memberID = memberID;
	}
	
	
	FacultyMember(String fname, String lname, String username, String password, String address, String phone){
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone = phone;
		
		
	}
	
	@Override
	public String toString() {
		return "Member Information" + 
				"\nFaculty"   + memberType + 
				"\nFirst Name" + fname +
				"\nLast Name" + lname +
				"\nUsername" + username +
				"\nAddress" + address +
				"\nPhone Number" + phone +
				"\npassword" + password +
				"\nMemberID" + FacultyMember.memberID;
				

    }
	


}
