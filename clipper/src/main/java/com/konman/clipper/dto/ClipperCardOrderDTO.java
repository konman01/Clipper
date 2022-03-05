package com.konman.clipper.dto;

import java.util.List;

public class ClipperCardOrderDTO {
	
	// Literals
	private int id;
	
	private String status;
	
	private String type;
	
	private double amount;
	
	private List<ClipperOrderDTO> clipperOrders;
	
	// Constructors
	public ClipperCardOrderDTO() {
		
	}

	public ClipperCardOrderDTO(int id, String status, String type, double amount) {
		this.id = id;
		this.status = status;
		this.type = type;
		this.amount = amount;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<ClipperOrderDTO> getClipperOrders() {
		return clipperOrders;
	}

	public void setClipperOrders(List<ClipperOrderDTO> clipperOrders) {
		this.clipperOrders = clipperOrders;
	}

	// toString Method
	@Override
	public String toString() {
		return "ClipperCardOrderDTO [id=" + id + ", status=" + status + ", type=" + type + ", amount=" + amount
				+ ", clipperOrders=" + clipperOrders + "]";
	}
	
	

}
