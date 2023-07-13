package com.konman.clipper.service;

import org.springframework.stereotype.Service;

import com.konman.clipper.model.SalesOrderDetailListVO;
import com.konman.clipper.model.SalesOrderSubmitRequestVO;
import com.konman.clipper.model.SalesOrderSubmitResponseVO;


public interface SalesOrderService {
	
	public SalesOrderSubmitResponseVO submitOrder(SalesOrderSubmitRequestVO theOrder);
	
	public SalesOrderDetailListVO getOrderDetailsForUser(String Email);

}
