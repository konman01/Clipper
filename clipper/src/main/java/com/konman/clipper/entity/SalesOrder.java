package com.konman.clipper.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sales_order")
@Getter
@Setter
@ToString
public class SalesOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "sales_order_number")
	private String salesOrderNumber;
	
	@Column(name = "order_date")
	private LocalDate orderDate;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "clipper_id")
	private ClipperCard clipperCard;
	
	public SalesOrder(double theAmount, String theSalesOrderNumber, LocalDate theOrderDate) {
		amount = theAmount;
		salesOrderNumber = theSalesOrderNumber;
		orderDate = theOrderDate;
	}
	
	public SalesOrder() {
		
	}

}
