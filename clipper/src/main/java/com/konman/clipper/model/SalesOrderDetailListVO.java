package com.konman.clipper.model;

import java.util.List;

import lombok.Data;

@Data
public class SalesOrderDetailListVO {
	
	String firstName;
	String lastName;
	String email;
	Double totalBalance;
	List<ClipperCardVO> clipperCardVOs;

}
