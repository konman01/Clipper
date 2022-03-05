package com.konman.clipper.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.konman.clipper.entity.ClipperOrderDTO;
import com.konman.clipper.model.ClipperOrderVO;
import com.konman.clipper.service.ClipperOrderService;

@RestController
@RequestMapping("/orderapi")
public class ClipperOrderController {
	
	// Autowiring the Service
	@Autowired
	private ClipperOrderService clipperOrderService;
	
	@PostMapping("/clipperOrder")
	public ClipperOrderDTO saveClipperOrder(@RequestBody ClipperOrderVO clipperOrderVO) {
		ClipperOrderDTO clipperOrderDTO = clipperOrderService.saveClipperOrder(clipperOrderVO);
		return clipperOrderDTO;
	}

}
