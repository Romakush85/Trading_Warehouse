package ua.kushnir.petproject.product;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name="shelf-life", nullable = false)
    private Date shelfLife;
    @Column(name = "purchase_price", nullable = false)
    private BigDecimal purchasePrice;
    @Column(name = "sale_price")
    private BigDecimal salePrice;
    @Column(name = "category")
    private Category category;




}
