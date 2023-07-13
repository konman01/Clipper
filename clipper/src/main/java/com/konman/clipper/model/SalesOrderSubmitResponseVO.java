package com.konman.clipper.model;

import lombok.Data;

@Data
public class SalesOrderSubmitResponseVO {
	
	String status;
	String errorMessage;
	String orderNumber;
	Double amount;
	Integer clipperId;
	Double balance;

}
