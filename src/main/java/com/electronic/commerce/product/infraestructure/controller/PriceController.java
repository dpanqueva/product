package com.electronic.commerce.product.infraestructure.controller;

import com.electronic.commerce.product.application.PriceService;
import com.electronic.commerce.product.infraestructure.dto.PriceDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get a product by applicationDate and productId and brandId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the product",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PriceDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "UPS! Bad request, date must have the format yyyy-mm-ddHH:mm:ss. Example: 2020-06-1410:10:00",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "UPS! Unexpected error, contact system administrator",
                    content = @Content) })
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
