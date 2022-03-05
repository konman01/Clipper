package com.konman.clipper.service;

import com.konman.clipper.dto.ClipperOrderDTO;
import com.konman.clipper.model.ClipperOrderVO;

public interface ClipperOrderService {

	public ClipperOrderDTO saveClipperOrder(ClipperOrderVO clipperOrderVO);
}
