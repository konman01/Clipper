package com.konman.clipper.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konman.clipper.dao.SalesOrderRepository;
import com.konman.clipper.dao.UserRepository;
import com.konman.clipper.dto.ClipperCardDTO;
import com.konman.clipper.dto.ContactDTO;
import com.konman.clipper.dto.UserDTO;
import com.konman.clipper.entity.ClipperCard;
import com.konman.clipper.entity.SalesOrder;
import com.konman.clipper.entity.User;
import com.konman.clipper.model.ClipperCardVO;
import com.konman.clipper.model.SalesOrderDetailListVO;
import com.konman.clipper.model.SalesOrderSubmitRequestVO;
import com.konman.clipper.model.SalesOrderSubmitResponseVO;
import com.konman.clipper.model.SalesOrderVO;
import com.konman.clipper.service.SalesOrderService;
import com.konman.clipper.service.UserService;
import com.konman.clipper.utility.ClipperCardException;
import com.konman.clipper.utility.ClipperCardStatusEnum;
import com.konman.clipper.utility.UserNotFoundException;

@Service
public class SalesOrderServiceImpl implements SalesOrderService{
	
	@Autowired
	private SalesOrderRepository salesOrderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public SalesOrderSubmitResponseVO submitOrder(SalesOrderSubmitRequestVO theOrder) {
		
		SalesOrderSubmitResponseVO response = new SalesOrderSubmitResponseVO();
		StringBuilder salesOrderNumber = new StringBuilder();
		
		// There will be only one user with the email address
		List<User> users = userRepository.findByEmail(theOrder.getEmail());
		
		if(users == null || users.size() == 0) {
			throw new UserNotFoundException("User not found with email: "+theOrder.getEmail());
		}
		
		
		List<ClipperCard> clipperCards = users.get(0).getClipperCards();
		List<ClipperCard> activeClipperCards = clipperCards.stream().filter(x->x.getStatus().equals(ClipperCardStatusEnum.ACTIVE.toString())).collect(Collectors.toList());
		
		if(activeClipperCards.size() == 0) {
			throw new ClipperCardException("No Active Clipper Card available for email Id:"+theOrder.getEmail());
		}
		
		ClipperCard activeClipperCard = activeClipperCards.get(0);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		salesOrderNumber.append("1-");
		salesOrderNumber.append(localDateTime.format(dateFormat));
		
		activeClipperCard.setAmount(activeClipperCard.getAmount() + Integer.valueOf(theOrder.getAmount()));
		SalesOrder salesOrder = new SalesOrder(Double.valueOf(theOrder.getAmount()), salesOrderNumber.toString(), LocalDate.now());
		
		activeClipperCard.addSalesOrder(salesOrder);
		
		
		salesOrderRepository.save(salesOrder);
		
		response.setAmount(salesOrder.getAmount());
		response.setBalance(activeClipperCard.getAmount());
		response.setClipperId(activeClipperCard.getId());
		response.setOrderNumber(salesOrderNumber.toString());
		response.setStatus("SUCESS");
		
		return response;
	}


	@Override
	public SalesOrderDetailListVO getOrderDetailsForUser(String theEmail) {
		
		SalesOrderDetailListVO response = new SalesOrderDetailListVO();
		List<ClipperCardVO> clipperCardVOList = new ArrayList<>();
		
		// Fetch the User using the Email Address
		List<User> users = userRepository.findByEmail(theEmail);
		if(users.size() == 0) {
			throw new UserNotFoundException("User Not available with email: "+theEmail);
		}
		User user = users.get(0);
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setEmail(theEmail);
		
		// For the user fetch the clipper cards
		List<ClipperCard> clipperCards = user.getClipperCards();
		
		TypeMap<ClipperCard, ClipperCardVO> clipperCardTypeMap = modelMapper.typeMap(ClipperCard.class, ClipperCardVO.class);
		clipperCardTypeMap.addMappings(mapper -> {
			mapper.skip(ClipperCardVO::setSalesOrdersVO);
			mapper.map(ClipperCard::getAmount, ClipperCardVO::setBalance);
		});
		
		double totalBalance = 0.0;
		 
		for (ClipperCard clipperCard : clipperCards) {
			
			ClipperCardVO clipperCardVO = modelMapper.map(clipperCard, ClipperCardVO.class);
			
			// For each Clipper Card, get the Sales orders performed
			List<SalesOrder> salesOrders = clipperCard.getSalesOrders();
			List<SalesOrderVO> salesOrderVOs = new ArrayList<>();
			for (SalesOrder salesOrder : salesOrders) {
				salesOrderVOs.add(modelMapper.map(salesOrder, SalesOrderVO.class));
			}
			clipperCardVO.setSalesOrdersVO(salesOrderVOs);
			
			clipperCardVOList.add(clipperCardVO);
			
		}
		
		response.setClipperCardVOs(clipperCardVOList);
		totalBalance = clipperCardVOList.stream().mapToDouble(value -> value.getBalance()).sum();
		response.setTotalBalance(totalBalance);
		
		return response;
	}
	
	

}
