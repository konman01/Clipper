package com.konman.clipper.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import java.time.LocalDateTime;

@Entity
@Table(name = "order_detail")
public class ClipperOrder {
	
	// Defining the Literals
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "order_date")
	private LocalDateTime orderDate;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "clipper_id")
	private ClipperCard clipperCard;
	
	// Default and Parameterialised Constructor
	public ClipperOrder(){
		
	}

	public ClipperOrder(double amount, LocalDateTime orderDate) {
		this.amount = amount;
		this.orderDate = orderDate;
	}
	
	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public ClipperCard getClipperCard() {
		return clipperCard;
	}

	public void setClipperCard(ClipperCard clipperCard) {
		this.clipperCard = clipperCard;
	}

	@Override
	public String toString() {
		return "ClipperOrder [id=" + id + ", amount=" + amount + ", orderDate=" + orderDate + "]";
	}

}// End of the class
