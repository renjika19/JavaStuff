package com.fred.Dao;

import static com.fred.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.fred.beans.Member;
import com.fred.Dao.MemberDao;
import com.fred.util.ConnectionUtil;

public class MemberDaoImpl implements MemberDao{
	
	@Override
	public Boolean insertMember(Member m) {
		PreparedStatement stmt = null;

		
		try(Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("INSERT INTO MEMBERS(fname, lname, username, pass, email, address, phone) VALUES(?,?,?,?,?,?,?)");

			
			stmt.setString(1, m.getFname());
			stmt.setString(2, m.getLname());
			stmt.setString(3, m.getUsername());
			stmt.setString(4, m.getPass());
			stmt.setString(5, m.getEmail());
			stmt.setString(6, m.getAddress());
			stmt.setString(7, m.getPhone());
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
	public Member selectMemberById(Integer id) {
		Statement stmt = null;
		ResultSet rs = null;
		Member membera = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			stmt = conn.createStatement(); 
			rs= stmt.executeQuery("SELECT * FROM Members WHERE members_id ="+id);
			if(rs.next()) {
				membera = new Member(
						rs.getInt("members_id"), // grab data by name
						rs.getString("fname"), // or we can grab by index
						rs.getString("lname"),
						rs.getString("username"),
						rs.getString("pass"),
						rs.getString("email"),
						rs.getString("address"),
						rs.getString("phone")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return membera;

	}

	@Override
	public List<Member> selectAllMember() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> memberas = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			stmt = conn.createStatement(); // create a statement
			//object from the connection
			//statement objects can exectue sql queries connected
			//to DB
			
			rs = stmt.executeQuery("SELECT * FROM Members");
			/*
			 * ResultSet stores all the records from the successful
			 * query
			 */
			while(rs.next()) {
				memberas.add(new Member(
						rs.getInt("members_id"), // grab data by name
						rs.getString("fname"), // or we can grab by index
						rs.getString("lname"),
						rs.getString("username"),
						rs.getString("pass"),
						rs.getString("email"),
						rs.getString("address"),
						rs.getString("phone")
						));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return memberas;

	}



	@Override
	public Boolean updateMemberById(Integer id) {
		PreparedStatement stmt = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("DELETE FROM Members WHERE members_id = ?"); 
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
