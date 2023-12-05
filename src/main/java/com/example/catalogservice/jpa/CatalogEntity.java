package com.example.catalogservice.jpa;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
//@Builder
@Entity
@Table(name = "catalogs")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CatalogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    // @Column(nullable = false, updatable = false, insertable = false)
    // @ColumnDefault(value = "CURRENT_TIMESTAMP") // MySql v5.6.5 >=
    private LocalDateTime createdAt;
}
