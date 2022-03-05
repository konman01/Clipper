package com.konman.clipper.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clipper_card")
public class ClipperCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name = "type")
	private String type;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy = "clipperCard", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<ClipperOrder> clipperOrders;
	
	// Constructors
	public ClipperCard() {
		
	}

	public ClipperCard(double amount, String type, String status) {
		this.amount = amount;
		this.type = type;
		this.status = status;
	}
	
	// Generate Getters and Setters
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	// to String Method
	@Override
	public String toString() {
		return "ClipperCard [amount=" + amount + ", type=" + type + ", status=" + status + "]";
	}
	
	
	// Adding the helper function to map the clipper Orders
	public void addClipperOrder(ClipperOrder theClipperOrder) {
		
		if(theClipperOrder == null) {
			clipperOrders = new ArrayList<>();
		}
		
		clipperOrders.add(theClipperOrder);
		theClipperOrder.setClipperCard(this);
		
		return;
		
	}
	

}
