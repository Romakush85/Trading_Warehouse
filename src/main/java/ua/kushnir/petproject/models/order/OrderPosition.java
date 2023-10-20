package ua.kushnir.petproject.models.order;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import ua.kushnir.petproject.models.product.Product;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "order_position")
public class OrderPosition {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName = "id")
    private Product product;
    @Column(name = "quantity", nullable = false)
    @Min(value = 0, message = "Quantity should not be less than 0")
    private int quantity;
    @Column(name = "price", nullable = false)
    @Min(value = 0, message = "Price should not be less than 0")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name="order_id", referencedColumnName = "id")
    private Order order;
}
