package com.konman.clipper.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClipperCardDTO {
	
	@JsonProperty("id")
	private int Id;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("amount")
	private double amount;
	
	public ClipperCardDTO(){
		
	}

	public ClipperCardDTO(int id, String status, String type, double amount) {
		Id = id;
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
