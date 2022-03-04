package com.konman.clipper.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClipperCardVO {
	
	
	private int Id;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("status")
	private String status;
	
	// Constructors 
	public ClipperCardVO() {
		
	}
	
	public ClipperCardVO(String email, String type, String status) {
		this.email = email;
		this.type = type;
		this.status = status;
	}
	
	// Getters and Setters

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	// toString mathod

	@Override
	public String toString() {
		return "ClipperCardVO [email=" + email + ", type=" + type + ", status=" + status + "]";
	}

}// End of the class
