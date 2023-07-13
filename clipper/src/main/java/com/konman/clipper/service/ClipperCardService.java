package com.konman.clipper.service;

import com.konman.clipper.dto.ClipperCardDTO;
import com.konman.clipper.entity.ClipperCard;
import com.konman.clipper.model.AddClipperCardRequestVO;

public interface ClipperCardService {
	
	public ClipperCardDTO addClipperCard(AddClipperCardRequestVO theClipperCardVO);
	
	public ClipperCardDTO getClipperCardById(int clipperId);
	
	public ClipperCardDTO updateClipperCardStatus(AddClipperCardRequestVO theClipperCardVO);
}
