package com.konman.clipper.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClipperOrderVO {
	
	@JsonProperty("clipper_id")
	private int clipperId;
	
	@JsonProperty("amount")
	private double amount;
	
	@JsonProperty("order_date")
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime orderDate;
	
	public ClipperOrderVO() {
		
	}
	
	

	
	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	
	

	public int getClipperId() {
		return clipperId;
	}

	public void setClipperId(int clipperId) {
		this.clipperId = clipperId;
	}

	@Override
	public String toString() {
		return "ClipperOrderVO [amount=" + amount + ", orderDate=" + orderDate + "]";
	}
	
}
