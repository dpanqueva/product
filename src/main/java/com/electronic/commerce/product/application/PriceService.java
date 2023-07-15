package com.electronic.commerce.product.application;

import com.electronic.commerce.product.infraestructure.dto.PriceDTO;

import java.time.LocalDateTime;

public interface PriceService {

    PriceDTO getPrice(LocalDateTime applicationDate, Long productId, Long brandId);
}
