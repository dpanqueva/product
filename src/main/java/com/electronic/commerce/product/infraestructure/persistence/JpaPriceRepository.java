package com.electronic.commerce.product.infraestructure.persistence;

import com.electronic.commerce.product.application.PriceRepository;
import com.electronic.commerce.product.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface JpaPriceRepository extends JpaRepository<Price, Long>, PriceRepository {

    @Query("SELECT p FROM Price p WHERE :applicationDate BETWEEN p.startDate AND p.endDate " +
            "AND p.product.id = :productId " +
            "AND p.brand.id = :brandId " +
            "ORDER BY p.priority DESC LIMIT 1")
    Price findApplicablePrice(@Param("applicationDate") LocalDateTime applicationDate,
                              @Param("productId") Long productId,
                              @Param("brandId") Long brandId);
}
