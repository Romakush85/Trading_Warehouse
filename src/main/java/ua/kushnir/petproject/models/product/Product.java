package ua.kushnir.petproject.models.product;


import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import ua.kushnir.petproject.models.contractor.supplier.Supplier;
import ua.kushnir.petproject.models.order.OrderPosition;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "title", nullable = false)
    @NotEmpty(message = "Product's title should not be empty")
    @Size(min = 3, max = 30, message = "Title should be between 3 and 30 characters")
    private String title;
    @Column(name = "purchase_price", nullable = false)
    @Min(value = 0, message = "Price should not be less than 0")
    private BigDecimal purchasePrice;
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Category should not be empty")
    private Category category;
    @ManyToOne
    @JoinColumn(name="supplier_id", referencedColumnName = "id")
    @NotNull(message="You should choose supplier of product")
    private Supplier supplier;
    @OneToMany(mappedBy = "product")
    private List<OrderPosition> orderPositions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
