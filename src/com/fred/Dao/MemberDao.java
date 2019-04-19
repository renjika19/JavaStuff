package com.fred.Dao;

import java.util.List;
import com.fred.beans.Member;

public interface MemberDao {
	
	public Boolean insertMember(Member m);
	public Member selectMemberById(Integer id);
	public List<Member> selectAllMember();
	public Boolean updateMemberById(Integer id);
	/*
	 * In practice, you should NEVER delete data from a DB
	 */
//	public Boolean deleteMemberById(Integer id);


}
