package com.konman.clipper.service;

import com.konman.clipper.entity.ClipperOrderDTO;
import com.konman.clipper.model.ClipperOrderVO;

public interface ClipperOrderService {

	public ClipperOrderDTO saveClipperOrder(ClipperOrderVO clipperOrderVO);
}
