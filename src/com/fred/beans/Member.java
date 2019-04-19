package com.fred.beans;

public class Member {
	private Integer members_ID;
	private String fname;
	private String lname;
	private String username;
	private String pass;
	private String email;
	private String address;
	private String phone;
	
	
	public Member() {
		super();
	}
	
	public Member(Integer members_ID,String fname, String lname, String username, String pass, String email, String address, String phone) {
		this.setMembers_ID(members_ID);
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	
	public Member(String fname, String lname, String username, String pass, String email, String address, String phone) {
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	
	
	
	public Integer getMembers_ID() {
		return members_ID;
	}
	
	public void setMembers_ID(Integer members_ID) {
		this.members_ID = members_ID;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [members_ID=" + members_ID + ", fname=" + fname + ", lname=" + lname + ", username=" + username
				+ ", pass=" + pass + ", email=" + email + ", address=" + address + ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((members_ID == null) ? 0 : members_ID.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (members_ID == null) {
			if (other.members_ID != null)
				return false;
		} else if (!members_ID.equals(other.members_ID))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}





}
