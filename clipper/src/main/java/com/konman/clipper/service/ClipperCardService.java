package com.konman.clipper.service;

import java.util.List;

import com.konman.clipper.dto.ClipperCardDTO;
import com.konman.clipper.dto.ClipperCardOrderDTO;
import com.konman.clipper.entity.ClipperCard;
import com.konman.clipper.model.ClipperCardVO;

public interface ClipperCardService {
	
	public ClipperCardDTO addClipperCard(ClipperCardVO theClipperCardVO);
	
	public ClipperCardDTO getClipperCardById(int clipperId);
	
	public ClipperCardDTO updateClipperCardStatus(ClipperCardVO theClipperCardVO);
	
	public List<ClipperCardOrderDTO> getClipperCardOrders();
}
