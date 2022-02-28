package com.konman.clipper.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konman.clipper.dto.ClipperCardDTO;
import com.konman.clipper.entity.ClipperCard;
import com.konman.clipper.model.ClipperCardVO;
import com.konman.clipper.service.ClipperCardService;

@RestController
@RequestMapping("/cardapi")
public class ClipperCardController {
	
	// AutoWiring the Service
	@Autowired
	private ClipperCardService clipperCardService;
	
	// End point to create clipper card to the user
	@PostMapping("/clippercard")
	public ClipperCardDTO createCard(@RequestBody ClipperCardVO theClipperVO) {
		
		ClipperCardDTO clipperCardDto = clipperCardService.addClipperCard(theClipperVO);
		
		System.out.println(clipperCardDto);
		
		return clipperCardDto;
	}
	
	@GetMapping("/clippercard/{clipperId}")
	public ClipperCardDTO getClipperCardById(@PathVariable int clipperId) {
		return clipperCardService.getClipperCardById(clipperId);
	}

}
