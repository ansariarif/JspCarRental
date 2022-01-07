package com.elib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.elib.beans.AddCar;
import com.elib.beans.IssueCarBean;
import com.elib.beans.RentalBean;




public class CarDao {
	
	public static int save(AddCar bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into e_car(callno,name,owners,typee,quantity,issued) values(?,?,?,?,?,?)");
			ps.setString(1,bean.getCallno());
			ps.setString(2,bean.getName());
			ps.setString(3,bean.getOwners());
			ps.setString(4,bean.getTypee());
			ps.setInt(5,bean.getQuantity());
			ps.setInt(6, bean.getIssued());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
		
	}	
	
	
	public static List<AddCar> view(){
		List<AddCar> list=new ArrayList<AddCar>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_car");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				AddCar bean=new AddCar();
				bean.setCallno(rs.getString("callno"));
				bean.setName(rs.getString("name"));
				bean.setOwners(rs.getString("owners"));
				bean.setTypee(rs.getString("typee"));
				bean.setQuantity(rs.getInt("quantity"));
				bean.setIssued(rs.getInt("issued"));
				
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	
	public static int deleteCar(AddCar user) {
		int status = 0;
		try {
			Connection con = JDBCProperties.getConnection();
			String deleteQuery = "DELETE FROM e_car WHERE callno = ?";
			PreparedStatement pst = con.prepareStatement(deleteQuery);
			pst.setString(1, user.getCallno());
			status = pst.executeUpdate();
			pst.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	
	public static int getIssued(String callno){
		int issued=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_car where callno=?");
			ps.setString(1,callno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				issued=rs.getInt("issued");
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		
		return issued;
	}
	
	public static boolean checkIssue(String callno){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_car where callno=? and quantity>issued");
			ps.setString(1,callno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
	public static int issueCar(IssueCarBean bean){
		String callno=bean.getCallno();
		boolean checkstatus=checkIssue(callno);
		System.out.println("Check status: "+checkstatus);
		if(checkstatus){
			int status=0;
			try{
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("insert into e_issuecar values(?,?,?,?,?,?)");
				ps.setString(1,bean.getCallno());
				ps.setString(2,bean.getRentalid());
				ps.setString(3,bean.getRentalname());
				ps.setLong(4,bean.getRentalmobile());
				java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
				ps.setDate(5,currentDate);
				ps.setString(6,"no");
				
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=con.prepareStatement("update e_car set issued=? where callno=?");
					ps2.setInt(1,getIssued(callno)+1);
					ps2.setString(2,callno);
					status=ps2.executeUpdate();
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
		}else{
			return 0;
		}
	}
	
	
	public static List<IssueCarBean> viewIssuedCar(){
		List<IssueCarBean> list=new ArrayList<IssueCarBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from e_issuecar order by issueddate desc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				IssueCarBean bean=new IssueCarBean();
				bean.setCallno(rs.getString("callno"));
				bean.setRentalid(rs.getString("rentalid"));
				bean.setRentalname(rs.getString("rentalname"));
				bean.setRentalmobile(rs.getLong("rentalmobile"));
				bean.setIssueddate(rs.getDate("issueddate"));
				bean.setReturnstatus(rs.getString("returnstatus"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	     
	/*
	public static int returnCar(String callno,String rentalid){
		int status=0;
			try{
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("update e_issuecar set returnstatus='yes' where callno=? and rentalid=?");
				ps.setString(1,callno);
				ps.setString(2,rentalid);
				
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=con.prepareStatement("update e_car set issued=? where callno=?");
					ps2.setInt(1,getIssued(callno)-1);
					ps2.setString(2,callno);
					status=ps2.executeUpdate();
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
	}
	*/
	
	//Return Car by CarNo only-->one parameter
	
	public static int returnCarByCarNo(String callno){
		int status=0;
			try{
				Connection con=DB.getCon();
				PreparedStatement ps=con.prepareStatement("update e_issuecar set returnstatus='yes' where callno=?");
				ps.setString(1,callno);
				
				
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=con.prepareStatement("update e_car set issued=? where callno=?");
					ps2.setInt(1,getIssued(callno)-1);
					ps2.setString(2,callno);
					status=ps2.executeUpdate();
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
	}
	
	
	//Delete Booked car Record
	
	public static int deleteCarBooked(IssueCarBean user) {
		int status = 0;
		try {
			Connection con = JDBCProperties.getConnection();
			
			String streturn = "select returnstatus from e_issuecar WHERE callno = ?";
			PreparedStatement pst1 = con.prepareStatement(streturn);
			pst1.setString(1, user.getCallno());
			//System.out.println(pst1);
			//pst1.executeUpdate();
			ResultSet rs=pst1.executeQuery();
			while(rs.next()) {
				if(rs.getString("returnstatus").equals("yes")) {
					String deleteQuery = "DELETE FROM  e_issuecar WHERE callno = ?";
					PreparedStatement pst = con.prepareStatement(deleteQuery);
					pst.setString(1, user.getCallno());
					status = pst.executeUpdate();
					pst.close();
					con.close();
			
			}
			else {
				System.out.println("Record Not return !!");
			}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	

}
