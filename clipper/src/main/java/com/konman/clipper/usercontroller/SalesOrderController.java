package com.konman.clipper.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konman.clipper.model.SalesOrderDetailListVO;
import com.konman.clipper.model.SalesOrderSubmitRequestVO;
import com.konman.clipper.model.SalesOrderSubmitResponseVO;
import com.konman.clipper.service.SalesOrderService;

@RestController
@RequestMapping("/orderapi")
public class SalesOrderController {
	
	@Autowired
	private SalesOrderService salesOrderService;
	
	@PostMapping("/submitorder")
	public SalesOrderSubmitResponseVO submitSalesOrder(@RequestBody SalesOrderSubmitRequestVO request) {
		System.out.println("Executing the submit request:controller");
		return salesOrderService.submitOrder(request);
	}
	
	@GetMapping("/getOrderDetails/{email}")
	public SalesOrderDetailListVO getOrderDetailsForUser(@PathVariable String email) {
		
		return salesOrderService.getOrderDetailsForUser(email);
	}

}
