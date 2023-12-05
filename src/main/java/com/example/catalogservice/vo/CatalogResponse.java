package com.example.catalogservice.vo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class CatalogResponse {
    private String productId;
    private String productName;
    private BigDecimal unitPrice;
    private Integer stock;
    private LocalDateTime createdAt;
}
