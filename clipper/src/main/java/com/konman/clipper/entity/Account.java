package com.konman.clipper.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "account_detail")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "effective_start_date")
	LocalDate effectiveStartDate;
	
	@Column(name = "effective_end_date")
	LocalDate effectiveEndDate;
	
	@Column(name = "total_balance")
	double totalBalance;
	
	@Column(name = "status")
	String status;

	public Account(LocalDate effectiveStartDate, LocalDate effectiveEndDate, double totalAmount, String status) {
		super();
		this.effectiveStartDate = effectiveStartDate;
		this.effectiveEndDate = effectiveEndDate;
		this.totalBalance = totalAmount;
		this.status = status;
	}
	
}
