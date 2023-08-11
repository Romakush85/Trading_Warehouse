package ua.kushnir.petproject.product;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
public class ProductDTO {
    private UUID id;
    private String title;
    private Date shelfLife;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private Category category;
}
