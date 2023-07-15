package com.electronic.commerce.product.domain.service;

import com.electronic.commerce.product.application.PriceRepository;
import com.electronic.commerce.product.application.PriceService;
import com.electronic.commerce.product.infraestructure.dto.PriceDTO;
import com.electronic.commerce.product.infraestructure.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public PriceDTO getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        var priceResult = priceRepository.findApplicablePrice(applicationDate, productId, brandId);
        if(priceResult == null){
            throw new NotFoundException("Product not found");
        }
        return new PriceDTO(priceResult);
    }
}
