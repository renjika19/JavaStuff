package com.fred.services;


import com.fred.beans.Member;

import java.util.List;

import com.fred.Dao.MemberDao;
import com.fred.Dao.MemberDaoImpl;

public class MemberService {
	private MemberDao md = null;
	
	public Boolean addNewMember(Member m) {
		md = new MemberDaoImpl();
		return md.insertMember(m);
	}

	public List<Member> getAllMembers(){
		md = new MemberDaoImpl();
		return md.selectAllMember();
	}
	
	public Member getMembersById(Integer id){
		md = new MemberDaoImpl();
		return md.selectMemberById(id);
	}
	
	public Boolean updateMemberById(Integer id){
		md = new MemberDaoImpl();
		return md.updateMemberById(id);
	}
}

