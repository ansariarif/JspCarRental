package com.elib.beans;

public class AddCar {
	
	private String callno, name, owners, typee;
	private int quantity, issued;
	
	public AddCar() {
		super();
		
	}

	public AddCar(String callno, String name, String owners, String typee, int quantity) {
		super();
		this.callno = callno;
		this.name = name;
		this.owners = owners;
		this.typee = typee;
		this.quantity = quantity;
		
	}

	public String getCallno() {
		return callno;
	}

	public void setCallno(String callno) {
		this.callno = callno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public String getTypee() {
		return typee;
	}

	public void setTypee(String typee) {
		this.typee = typee;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getIssued() {
		return issued;
	}

	public void setIssued(int issued) {
		this.issued = issued;
	}
	
	
	
	

}
