package com.konman.clipper.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.konman.clipper.dto.ClipperOrderDTO;
import com.konman.clipper.model.ClipperOrderVO;
import com.konman.clipper.service.ClipperOrderService;

@RestController
@RequestMapping("/orderapi")
public class ClipperOrderController {
	
	// Autowiring the Service
	@Autowired
	private ClipperOrderService clipperOrderService;
	
	// End point to Place order for a a clipper card
	@PostMapping("/clipperOrder")
	public ClipperOrderDTO saveClipperOrder(@RequestBody ClipperOrderVO clipperOrderVO) {
		ClipperOrderDTO clipperOrderDTO = clipperOrderService.saveClipperOrder(clipperOrderVO);
		return clipperOrderDTO;
	}
	
	// End points to get All the Orders related to a ClipperCard

}
