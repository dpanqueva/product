package com.electronic.commerce.product.infraestructure.controller;

import com.electronic.commerce.product.application.PriceService;
import com.electronic.commerce.product.infraestructure.dto.PriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public ResponseEntity<PriceDTO> getPrice(@RequestParam("applicationDate")
                                             @DateTimeFormat(pattern = "yyyy-MM-ddHH:mm:ss")
                                                     LocalDateTime applicationDate,
                                             @RequestParam("productId") Long productId,
                                             @RequestParam("brandId") Long brandId) {
        PriceDTO priceDTO = priceService.getPrice(applicationDate, productId, brandId);
        return ResponseEntity.ok(priceDTO);
    }
}
