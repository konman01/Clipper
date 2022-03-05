package com.konman.clipper.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class ClipperOrderDTO {
	
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("amount")
	private String amount;
	
	@JsonProperty("order_date")
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime orderDate;

	
	// Constructors
	public ClipperOrderDTO() {
		
	}

	public ClipperOrderDTO(int id, String amount, LocalDateTime orderDateTime, int clipperId) {
		this.id = id;
		this.amount = amount;
		this.orderDate = orderDateTime;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	
}// End of Classa
