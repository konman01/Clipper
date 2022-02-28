package com.konman.clipper.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konman.clipper.dao.ClipperCardRepository;
import com.konman.clipper.dao.UserRepository;
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

	@Override
	public ClipperCard addClipperCard(ClipperCardVO theClipperCardVo) {
		
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
		
		ClipperCard card = mapper.map(theClipperCardVo, ClipperCard.class);
		
		card.setType(ClipperCardStatusEnum.ACTIVE.toString());
		
		// Adding Card to User
		user.addCard(card);
		
		// Setting the User onn Clipper Card
		card.setUser(user);
		
		
		ClipperCard dbClipperCard = clipperCardRepository.save(card);
		
		return dbClipperCard;
	}

}
