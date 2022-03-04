package com.konman.clipper.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.Converters.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konman.clipper.dao.UserRepository;
import com.konman.clipper.dto.ClipperCardDTO;
import com.konman.clipper.dto.ContactDTO;
import com.konman.clipper.dto.UserDTO;
import com.konman.clipper.entity.ClipperCard;
import com.konman.clipper.entity.Contact;
import com.konman.clipper.entity.User;
import com.konman.clipper.model.UserVO;
import com.konman.clipper.service.UserService;
import com.konman.clipper.utility.ClipperUtility;
import com.konman.clipper.utility.UserAlreadyExistException;
import com.konman.clipper.utility.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	// Autowiring the UserRepository Object
	@Autowired
	private UserRepository userRepository;
	
	// Autowiring the Model Mapper
	@Autowired
	private ModelMapper modelMapper;

	// Service to get All the Clipper users
	@Override
	public List<UserDTO> findUsers() {
		
		// Get all the users
		List<User> users =  userRepository.findAll();
		List<UserDTO> userDtos = null;
		
		if(users.size() > 0) {
			
			ClipperUtility.clipperLogger.info("Size is greater than 0");
			// Create List of UserDTO
			userDtos = new ArrayList<>();
			
			for(User user: users) {
				
				// Create the Type Map and assign Mappings required for UserDTO
				TypeMap<User, UserDTO> userTypeMap = modelMapper.typeMap(User.class, UserDTO.class);
				
				userTypeMap.addMappings(mapper->{
					mapper.skip(UserDTO::setContactDetailDto);
					mapper.skip(UserDTO::setClipperCardsDto);
				});
				
				//Map user to UserDTO
				UserDTO userDto = modelMapper.map(user, UserDTO.class);

				// Get the Contact Detail and map to ContactDTO
				Contact contact = user.getContactDetail();
				ContactDTO contactDto = modelMapper.map(contact, ContactDTO.class);
				userDto.setContactDetailDto(contactDto);
				
				
				// Map the ClipperCard to ClipperCard DTO
				List<ClipperCard> clipperCards = user.getClipperCards();
				List<ClipperCardDTO> clipperCardDtos = new ArrayList<>();
				clipperCards.forEach(clippercard -> clipperCardDtos.add(modelMapper.map(clippercard, ClipperCardDTO.class)));
				
				// Add the user DTO to list
				userDto.setClipperCardsDto(clipperCardDtos);
				
				userDtos.add(userDto);
				
			}// End of for loop
			
			
		}// End of id condition
		
		
		return userDtos;
	}

	// Service to save an user into Clipper DB
	@Override
	public User saveUser(UserVO theUserVO) {
		
		modelMapper.typeMap(UserVO.class, User.class).addMappings(mapper -> {
			mapper.map(UserVO::getContactCreateJson,User::setContactDetail);
		});
		
		
		User user = modelMapper.map(theUserVO, User.class);
		
		String email = theUserVO.getEmail();
		
		List<User> users = userRepository.findByEmail(email);
		
		if(users.size() > 0) {
			ClipperUtility.clipperLogger.info("Already Exists Account with Email id:"+email);
			throw new UserAlreadyExistException("User already exist with email id:"+email);
		}
		
		User dbUser = userRepository.save(user);
		
		return dbUser;
		
	}

	// Service to fetch the user based on UserId
	@Override
	public User findUserById(int userId) {
		
		Optional<User> optionUser = userRepository.findById(userId);
		
		// If the User is Not present then throw the User Not Found Exception
		if(!optionUser.isPresent()) {
			throw new UserNotFoundException("User Not found with is:"+userId);
		}
		
		return optionUser.get();
	}
	
	// Service to update the User Details
	@Override
	public User updateUser(UserVO theUserVO) {
		
		// first get the user from the DB with the User Id
		Optional<User> currentUserOptional = userRepository.findById(theUserVO.getId());
		
		// If the user is not present in the database, then throw EWxception
		if(!currentUserOptional.isPresent()) {
			throw new UserNotFoundException("User not found with User Id:"+theUserVO.getId());
		}
		
		modelMapper.typeMap(UserVO.class, User.class).addMappings(mapper -> {
			mapper.map(UserVO::getContactCreateJson,User::setContactDetail);
		});
		
		
		User user = modelMapper.map(theUserVO, User.class);
		
		// Save the user
		User theDbUser = userRepository.save(user);
		
		return theDbUser;
	}
	
	// Service to delete a User
	@Override
	public void deleteUser(int userId) {
		
		// first get the user from the DB with the User Id
		Optional<User> currentUserOptional = userRepository.findById(userId);
		
		// If the user is not present in the database, then throw EWxception
		if(!currentUserOptional.isPresent()) {
			throw new UserNotFoundException("User not found with User Id:"+userId);
		}		
		
		// Delete the User By User Id
		userRepository.deleteById(userId);
				
		return;
	}
	
	// Service to Get the User Detail based on the Email
	@Override
	public User findUserByEmail(String email) {
		
		// Get the Users By Email Id
		List<User>  users = userRepository.findByEmail(email);
		
		User dBUser  = users.get(0);
		
		return dBUser;
		
	}
	
}
