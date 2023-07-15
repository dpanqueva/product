package com.electronic.commerce.product.application;

import com.electronic.commerce.product.domain.entity.Price;

import java.time.LocalDateTime;

public interface PriceRepository {

    Price findApplicablePrice(LocalDateTime applicationDate, Long productId, Long brandId);
}
