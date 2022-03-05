package com.konman.clipper.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konman.clipper.dao.ClipperCardRepository;
import com.konman.clipper.dao.ClipperOrderRepository;
import com.konman.clipper.dto.ClipperOrderDTO;
import com.konman.clipper.entity.ClipperCard;
import com.konman.clipper.entity.ClipperOrder;
import com.konman.clipper.model.ClipperOrderVO;
import com.konman.clipper.service.ClipperOrderService;
import com.konman.clipper.utility.ClipperCardException;
import com.konman.clipper.utility.ClipperCardStatusEnum;

@Service
public class ClipperOrderServiceImpl implements ClipperOrderService{
	
	@Autowired
	private ClipperCardRepository clipperCardRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ClipperOrderRepository clipperOrderRepository;

	// Service to Save the order to Clipper Card
	@Override
	public ClipperOrderDTO saveClipperOrder(ClipperOrderVO clipperOrderVO) {
		
		int clipperId = clipperOrderVO.getClipperId();
		
		// For the clipper Id, get the Clipper Order details
		Optional<ClipperCard> clipperCardOptional = clipperCardRepository.findById(clipperId);
		
		// If the clipper card is not found, then throw exception
		if(!clipperCardOptional.isPresent()) {
			throw new ClipperCardException("Clipper Card with Clipper Id :"+clipperId+" is not found");
		}
		
		ClipperCard clipperCard = clipperCardOptional.get();
		
		if(!clipperCard.getStatus().equals(ClipperCardStatusEnum.ACTIVE)) {
			throw new ClipperCardException("Clipper Card with Clipper Id: "+clipperId+ " is not Active");
		}
		
		// Map the Clipper Order VO to Clipper Order
		ClipperOrder clipperOrder = modelMapper.map(clipperOrderVO, ClipperOrder.class);
		
		// create the relationship between the Clipper Order and Clipper Card
		clipperCard.addClipperOrder(clipperOrder);
		
		clipperCard.setAmount(clipperCard.getAmount() + clipperOrderVO.getAmount());
		
		// Save the clipper order to DB
		ClipperOrder clipperOrderDb = clipperOrderRepository.save(clipperOrder);
		
		// Map the ClipperOrderDb to Clipper Order DTO object
		ClipperOrderDTO clipperOrderDTO = modelMapper.map(clipperOrderDb, ClipperOrderDTO.class);
		
		
		return clipperOrderDTO;
	}

	

}
