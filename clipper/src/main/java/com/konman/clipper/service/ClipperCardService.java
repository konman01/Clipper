package com.konman.clipper.service;

import com.konman.clipper.dto.ClipperCardDTO;
import com.konman.clipper.entity.ClipperCard;
import com.konman.clipper.model.ClipperCardVO;

public interface ClipperCardService {
	
	public ClipperCardDTO addClipperCard(ClipperCardVO theClipperCardVO);
	
	public ClipperCardDTO getClipperCardById(int clipperId);
}
