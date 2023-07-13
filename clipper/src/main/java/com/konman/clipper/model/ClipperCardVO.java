package com.konman.clipper.model;


import java.util.List;

import lombok.Data;

@Data
public class ClipperCardVO {
	
	private Integer id;
	private Double balance;
	private String type;
	private String status;
	private List<SalesOrderVO> salesOrdersVO;
	
}
