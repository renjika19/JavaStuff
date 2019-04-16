package com.fred.Library;

public class StudentMember extends Member {
	private final String memberType = "Student";
	private static int memberID;



	public StudentMember() {
		super.member = 2000000;
		memberID = member++;
	}

	
	
	
	public static int getMemberID() {
		return memberID;
	}
	
	
	public static void setMemberID(int memberID) {
		StudentMember.memberID = memberID;
	}
	
	

	public StudentMember(String fname, String lname, String username, String password, String address, String phone){
			this.fname = fname;
			this.lname = lname;
			this.username = username;
			this.password = password;
			this.address = address;
			this.phone = phone;
	}
			
			





		@Override
		public String toString() {
			return "Member Information" + memberType + "\nStudent" +
					"\nFirst Name" + fname +
					"\nLast Name" + lname +
					"\nUsername" + username +
   					"\nAddress" + address +
					"\nPhone Number" + phone +
					"\npassword" + password +
					"\nMemberID" + StudentMember.memberID;
	    }
	}
	

//	@Override
//	public String toString() {
//		return "StudentMember [getFname()=" + getfname() + ", getLname()=" + getlname() + ", getUserName()="
//				+ getUserName() + ", getPassword()=" + getPassword() + ", getAddress()=" + getAddress()
//				+ ", getPhone()=" + getPhone() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
//				+ ", toString()=" + super.toString() + "]";
//	}
//	
	
	

