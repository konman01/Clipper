package com.konman.clipper.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SalesOrderVO {
	
	private Integer id;
	private Double amount;
	
	@JsonProperty("sales_order_number")
	private String salesOrderNumber;
	
	@JsonProperty("order_date")
	private LocalDate orderDate;

}
