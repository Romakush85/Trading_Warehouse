package ua.kushnir.petproject.models.product;


import jakarta.persistence.*;
import ua.kushnir.petproject.models.supplier.Supplier;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {
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
    @ManyToOne
    @JoinColumn(name="supplier_id", referencedColumnName = "id")
    private Supplier supplier;




}
