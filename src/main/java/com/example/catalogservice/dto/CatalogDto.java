package com.example.catalogservice.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import java.math.BigDecimal;

@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CatalogDto {
    private String productId;

    private Integer qty;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    private String orderId;
    private String userId;
}
