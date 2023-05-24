package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import com.dto.Mobile;
import com.exception.Norecord;
import com.exception.Somethin;


public class ServiceImple implements Interface {

	@Override
	public void Add(Mobile s) throws Somethin {
		Connection c=null;
		
		try {
			c=Connect.getco();
			
			String q="create table if not exists Mobile(id int primary key auto_increment,model_no varchar(4) unique not null,company varchar(4) not null,price INT(6) not null,MFG date)";
			
			PreparedStatement ps=c.prepareStatement(q);
			
			ps.executeUpdate();
			
			
			String w = "INSERT INTO mobile (model_no,company, price,MFG) VALUES (?, ?, ?, ?)";
		
		PreparedStatement p=c.prepareStatement(w);
		
			p.setString(1, s.getModelno());
			p.setString(2, s.getCompany());
			p.setInt(3, s.getPrice());
			p.setDate(4, Date.valueOf(s.getDate()));
		
			p.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println(e);
			
			throw new Somethin("Some thing went wrong");
		}finally {
			try {
				Connect.closeCo(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void Update(Mobile s) throws Somethin {
Connection c=null;
		
		try {
			c=Connect.getco();
			String w = "Update Mobile Set company=?, price=?,MFG=? where model_no=?";
		
		PreparedStatement p=c.prepareStatement(w);
		
			
			p.setString(1, s.getCompany());
			p.setInt(2, s.getPrice());
			p.setDate(3, Date.valueOf(s.getDate()));
			p.setString(4, s.getModelno());
		
			if(p.executeUpdate()>0)
			{
				System.out.println("updated Success");
			}else {
				System.out.println("not updated");
			}
			
		
		} catch (SQLException e) {
			System.out.println(e);
			
			throw new Somethin("Some thing went wrong");
		}finally {
			try {
				Connect.closeCo(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void Deleted(String modelno) throws Somethin {
		
Connection c=null;
		
		try {
			c=Connect.getco();
			String w = "Delete from mobile where model_no=?";
		
		PreparedStatement p=c.prepareStatement(w);
		
			
			p.setString(1, modelno);
			
			if(p.executeUpdate()>0)
			{
				System.out.println("Deleted Success");
			}else {
				System.out.println("not Deleted");
			}
			
		
		} catch (SQLException e) {
			System.out.println(e);
			
			throw new Somethin("Some thing went wrong");
		}finally {
			try {
				Connect.closeCo(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Mobile> View() throws Norecord {
		// TODO Auto-generated method stub
		Connection c=null;
		List<Mobile> list1=new ArrayList<>(); 
		
		try {
			c=Connect.getco();
			
			String q="select * from mobile";
			
			PreparedStatement ps=c.prepareStatement(q);
			
			ResultSet rs=ps.executeQuery();
			
			if(isempty(rs)) {
				throw new Norecord("no record found");
			}else {
				while(rs.next()) {
					list1.add(new Mobile(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),LocalDate.parse(rs.getString(5))));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list1;
	}

	private boolean isempty(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return (!rs.isBeforeFirst() && rs.getRow() == 0);
	}

	@Override
	public Mobile Serch(String modelno) throws Norecord, Somethin {
		Connection c=null;
		Mobile mo=null;
		
		
		try {
			c=Connect.getco();
			
			String q="select * from mobile where model_no=?";
			
			PreparedStatement ps=c.prepareStatement(q);
			
			ps.setString(1, modelno);
			
			ResultSet rs=ps.executeQuery();
			
			if(isempty(rs)) {
				throw new Norecord("no record found");
			}else {
				rs.next();
				mo=new Mobile(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),LocalDate.parse(rs.getString(5)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new Somethin("Some thinh went wrong");
		}
		
		
		
		return mo;
	}

}
