package ua.kushnir.petproject.models.order;

import org.hibernate.annotations.GenericGenerator;
import ua.kushnir.petproject.models.contractor.Contractor;
import ua.kushnir.petproject.models.product.Product;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "number", nullable = false)
    private String number;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractor_id", referencedColumnName = "id", nullable = false)
    private Contractor contractor;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="order_product",
    joinColumns = @JoinColumn(name="order_id"), inverseJoinColumns = @JoinColumn(name="product_id"))
    private Map<Integer, Product> products;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
