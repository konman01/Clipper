package com.konman.clipper.dto;

public class ClipperCardDTO {
	
	private int Id;
	private String email;
	private String status;
	private String type;
	private double amount;
	
	public ClipperCardDTO(){
		
	}

	public ClipperCardDTO(int id, String email, String status, String type, double amount) {
		Id = id;
		this.email = email;
		this.status = status;
		this.type = type;
		this.amount = amount;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
