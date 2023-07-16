package com.konman.clipper;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.konman.clipper.dao.UserRepository;
import com.konman.clipper.dto.ClipperCardDTO;
import com.konman.clipper.dto.ContactDTO;
import com.konman.clipper.dto.UserDTO;
import com.konman.clipper.entity.ClipperCard;
import com.konman.clipper.entity.Contact;
import com.konman.clipper.entity.User;
import com.konman.clipper.service.UserService;
import com.konman.clipper.utility.ClipperUtility;

@SpringBootTest
public class UserDetailTests {
	
private int count = 0;
	
	@Value("${info.app.name}")
	String appName;
	
	@Value("${info.app.description}")
	String appDescription;
	
	@Value("${info.app.version}")
	String appVersion;
	
	@MockBean
	private UserRepository userRepository;
	
	
	
	@Autowired
	private UserService userService;
	
	
	
	
	@DisplayName("User Details without clipper details")
	@Test
	public void getUserDetailWithoutClipperDetails() {
		
		User theMockUser = new User("Manjunatha", "Koni Gururaja", "konimanjunatha@gmail.com", "6692104716");
		theMockUser.setClipperCards(new ArrayList<ClipperCard>());
		theMockUser.setContactDetail(new Contact());
		// set up
		when(userRepository.findById(1)).thenReturn(Optional.of(theMockUser));
		UserDTO userDto = userService.findUserById(1);
		//assertEquals(userDto, new UserDTO("Manjunatha", "Koni Gururaja", "konimanjunatha@gmail.com", "6692104716", new ContactDTO(), new ArrayList<ClipperCardDTO>()));
		assertNotNull(userDto);
		assertAll(()->{
			assertEquals(userDto.getFirstName(), "Manjunatha");
			assertEquals(userDto.getLastName(), "Koni Gururaja");
			assertEquals(userDto.getEmail(), "konimanjunatha@gmail.com");
			assertEquals(userDto.getPhoneNumber(), "6692104716");
			//assertIterableEquals(userDto.getClipperCardsDto(),new ArrayList<ClipperCard>(), "Clipper Cards are matching");
			//assertNotNull(userDto.getContactDetailDto());
		});
		
		verify(userRepository, times(1)).findById(1);
	}
	
	@BeforeEach
	public void beforeEach() {
		count = count + 1;
		ClipperUtility.clipperLogger.info("Testing: "+ appName +",Which is "+appDescription
				+" ,Version: "+appVersion+". Execution of test method " + count);
	}
	
	@AfterEach
	public void afterEach() {
		ClipperUtility.clipperLogger.info("Testing: "+ appName +",Which is "+appDescription
				+" ,Version: "+appVersion+". Execution of test method completed: " + count);
	}
}
