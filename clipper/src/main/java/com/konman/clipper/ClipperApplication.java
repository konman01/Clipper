package com.konman.clipper;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.konman.clipper.dao.SalesOrderRepository;
import com.konman.clipper.dao.UserRepository;
import com.konman.clipper.entity.ClipperCard;
import com.konman.clipper.entity.SalesOrder;
import com.konman.clipper.entity.User;

@SpringBootApplication
public class ClipperApplication {
	
	
	
	// Creating the Bean of Model Mapper
	public static void main(String[] args) {
		SpringApplication.run(ClipperApplication.class, args);
	}
	
	@Autowired
	SalesOrderRepository salesOrderRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PostConstruct
	public void addSampleOrder() {
		
		SalesOrder order = new SalesOrder(100, "1-123456", LocalDate.now());
		ClipperCard clipperCard = new ClipperCard(10, "REGULAR", "ACTIVE");
		User user = new User("mkg1", "mkg2", "mkg1@gmail.com", "234567");
		clipperCard.setUser(user);
		
		List<User> users = userRepository.findByEmail("mkg1@gmail.com");
		
		if(users.size() > 0) {
			return;
		}
		
		order.setClipperCard(clipperCard);
		
		salesOrderRepository.save(order);
		
	}

}
