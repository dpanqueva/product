package com.electronic.commerce.product.infraestructure.dto;

import com.electronic.commerce.product.domain.entity.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO {

    private Long productId;
    private Long brandId;
    private Long tariff;
    private List<LocalDateTime> applicationDates;
    private Float price;
    private String currency;

    public PriceDTO(Price price) {
        this.productId = price.getProduct().getId();
        this.brandId = price.getBrand().getId();
        this.tariff = price.getPriceList();
        this.applicationDates = List.of(price.getStartDate(), price.getEndDate());
        this.price = price.getValPri();
        this.currency = price.getCurrency();
    }
}
