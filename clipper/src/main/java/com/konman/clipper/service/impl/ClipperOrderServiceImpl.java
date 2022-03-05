package com.konman.clipper.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konman.clipper.dao.ClipperCardRepository;
import com.konman.clipper.dao.ClipperOrderRepository;
import com.konman.clipper.entity.ClipperCard;
import com.konman.clipper.entity.ClipperOrder;
import com.konman.clipper.entity.ClipperOrderDTO;
import com.konman.clipper.model.ClipperOrderVO;
import com.konman.clipper.service.ClipperOrderService;

@Service
public class ClipperOrderServiceImpl implements ClipperOrderService{
	
	@Autowired
	private ClipperCardRepository clipperCardRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ClipperOrderRepository clipperOrderRepository;

	@Override
	public ClipperOrderDTO saveClipperOrder(ClipperOrderVO clipperOrderVO) {
		
		int clipperId = clipperOrderVO.getClipperId();
		
		// For the clipper Id, get the Clipper Order details
		Optional<ClipperCard> clipperCardOptional = clipperCardRepository.findById(clipperId);
		
		if(!clipperCardOptional.isPresent()) {
			throw new RuntimeException("Clipper Card with Clipper Id :"+clipperId+" is not found");
		}
		
		ClipperCard clipperCard = clipperCardOptional.get();
		
		// Map the Clipper Order VO to Clipper Order
		ClipperOrder clipperOrder = modelMapper.map(clipperOrderVO, ClipperOrder.class);
		
		// create the relationship between the Clipper Order and Clipper Card
		clipperCard.addClipperOrder(clipperOrder);
		
		// Save the clipper order to DB
		ClipperOrder clipperOrderDb = clipperOrderRepository.save(clipperOrder);
		
		// Set the Type Map to skip[ the mapping on the Clipper Id
		TypeMap< ClipperOrder, ClipperOrderDTO> clipperOrderTypeMap = modelMapper.typeMap(ClipperOrder.class, ClipperOrderDTO.class);
		
		clipperOrderTypeMap.addMappings(mapper->{
			mapper.skip(ClipperOrderDTO::setClipperId);
		});
		
		// Map the ClipperOrderDb to Clipper Order DTO object
		ClipperOrderDTO clipperOrderDTO = modelMapper.map(clipperOrderDb, ClipperOrderDTO.class);
		
		// Set the Clipper Card Id on the Clipper Order
		clipperOrderDTO.setClipperId(clipperId);
		
		return clipperOrderDTO;
	}

	

}
