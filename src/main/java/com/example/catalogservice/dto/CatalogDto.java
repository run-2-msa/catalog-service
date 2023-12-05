package com.example.catalogservice.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CatalogDto {
    private String productId;

    private Integer qty;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    private String orderId;
    private String userId;
}
