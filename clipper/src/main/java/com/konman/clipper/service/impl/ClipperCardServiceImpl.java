package com.konman.clipper.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konman.clipper.dao.ClipperCardRepository;
import com.konman.clipper.dao.UserRepository;
import com.konman.clipper.dto.ClipperCardDTO;
import com.konman.clipper.entity.ClipperCard;
import com.konman.clipper.entity.User;
import com.konman.clipper.model.ClipperCardVO;
import com.konman.clipper.service.ClipperCardService;
import com.konman.clipper.utility.ClipperCardStatusEnum;

@Service
public class ClipperCardServiceImpl implements ClipperCardService {
	
	@Autowired
	private ClipperCardRepository clipperCardRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired ModelMapper mapper;

	// Service to save a Clipper Card to a Customer
	@Override
	public ClipperCardDTO addClipperCard(ClipperCardVO theClipperCardVo) {
		
		// If the User Account is not present, then throw Exception
		String userEmail = theClipperCardVo.getEmail();
		String currentStatus = theClipperCardVo.getStatus();
		
		// Fetch the user with the Email Account
		List<User> users = userRepository.findByEmail(userEmail);
		
		if(users.size() == 0) {
			throw new RuntimeException("User Not Found with the Email Id:"+userEmail);
		}
		
		// If the status is not initiated, then it is not possible to create the Clipper Card
		if(!currentStatus.equals(ClipperCardStatusEnum.INITIATE.toString())) {
			throw new RuntimeException("Clipper Card cannot be created with status:"+currentStatus);
		}
		
		User user = users.get(0);
		
		
		// If the clipper card already exists for the user with status Actice, then do not allow to create new Clipper Card
		List<ClipperCard> cards = clipperCardRepository.findByUserAndStatus(user, ClipperCardStatusEnum.ACTIVE.toString());
		
		if(cards.size() > 0) {
			throw new RuntimeException("Clipper Card already exist with email:"+userEmail);
		}
		
		// Create and Save Clipper card to DB
		ClipperCard card = mapper.map(theClipperCardVo, ClipperCard.class);
		card.setStatus(ClipperCardStatusEnum.ACTIVE.toString());
		
		// Adding Card to User
		user.addCard(card);
		
		// Setting the User on Clipper Card
		card.setUser(user);
		
		// Saving the Clipper Card into Repository
		ClipperCard dbClipperCard = clipperCardRepository.save(card);
		
		ClipperCardDTO clipperCardDto = mapper.map(dbClipperCard, ClipperCardDTO.class);
		clipperCardDto.setEmail(user.getEmail());
		
		return clipperCardDto;
	}

	// Service to get the Clipper Card Detail based on Clipper Id
	@Override
	public ClipperCardDTO getClipperCardById(int clipperId) {
		
		Optional<ClipperCard> clipperCardOptional = clipperCardRepository.findById(clipperId);
		
		if(!clipperCardOptional.isPresent()) {
			throw new RuntimeException("Clipper Card does not exist with clipper id:"+clipperId);
		}
		
		ClipperCard clipperCard =  clipperCardOptional.get();
		
		ClipperCardDTO clipperCardDTO = mapper.map(clipperCard, ClipperCardDTO.class);
		
		clipperCardDTO.setEmail(clipperCard.getUser().getEmail());
		
		return clipperCardDTO;
	}

}
