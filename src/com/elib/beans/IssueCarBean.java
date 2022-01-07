package com.elib.beans;

import java.sql.Date;

public class IssueCarBean {
	
	private String callno, rentalid, rentalname;
	private long rentalmobile;
	private Date issueddate;
	private String returnstatus;
	
	public IssueCarBean() {
		
	}

	public IssueCarBean(String callno, String rentalid, String rentalname, long rentalmobile) {
		super();
		this.callno = callno;
		this.rentalid = rentalid;
		this.rentalname = rentalname;
		this.rentalmobile = rentalmobile;
	}

	public String getCallno() {
		return callno;
	}

	public void setCallno(String callno) {
		this.callno = callno;
	}

	public String getRentalid() {
		return rentalid;
	}

	public void setRentalid(String rentalid) {
		this.rentalid = rentalid;
	}

	public String getRentalname() {
		return rentalname;
	}

	public void setRentalname(String rentalname) {
		this.rentalname = rentalname;
	}

	public long getRentalmobile() {
		return rentalmobile;
	}

	public void setRentalmobile(long rentalmobile) {
		this.rentalmobile = rentalmobile;
	}

	public Date getIssueddate() {
		return issueddate;
	}

	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}

	public String getReturnstatus() {
		return returnstatus;
	}

	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}
	
	
	
	

}
