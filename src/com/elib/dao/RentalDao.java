package com.elib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.elib.beans.RentalBean;







public class RentalDao {
	
	public static int save(RentalBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into e_rental(name,email,password,mobile) values(?,?,?,?)");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getPassword());
			ps.setLong(4,bean.getMobile());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
	public static List<RentalBean> getAll() {
		List<RentalBean> users = new ArrayList<RentalBean>();
		try {
			Connection con = JDBCProperties.getConnection();
			String selectQuery = "Select * FROM e_rental";
			PreparedStatement pst = con.prepareStatement(selectQuery);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				RentalBean user = new RentalBean();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setMobile(rs.getLong(5));
				users.add(user);
			}
			pst.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	public static int deleteRental(RentalBean user) {
		int status = 0;
		try {
			Connection con = JDBCProperties.getConnection();
			String deleteQuery = "DELETE FROM e_rental WHERE id = ?";
			PreparedStatement pst = con.prepareStatement(deleteQuery);
			pst.setInt(1, user.getId());
			status = pst.executeUpdate();
			pst.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public static RentalBean getRentalById(int id) {
		RentalBean user = null;
		try {
			Connection con = JDBCProperties.getConnection();
			String selectQuery = "Select * FROM e_rental WHERE id = ?";
			PreparedStatement pst = con.prepareStatement(selectQuery);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				user = new RentalBean();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setMobile(rs.getLong(5));
			}
			pst.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static int updateRental(RentalBean user) {
		int status = 0;
		try {
			Connection con = JDBCProperties.getConnection();
			String updateQuery = "UPDATE e_rental SET name = ?, email = ?, password = ?, mobile=? WHERE id = ?";
			PreparedStatement pst = con.prepareStatement(updateQuery);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			pst.setLong(4, user.getMobile());
			pst.setInt(5, user.getId());
			status = pst.executeUpdate();
			pst.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public static boolean authenticate(String email,String password){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_rental where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

}
