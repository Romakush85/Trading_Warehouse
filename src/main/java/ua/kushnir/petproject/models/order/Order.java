package ua.kushnir.petproject.models.order;

import jakarta.persistence.*;
import ua.kushnir.petproject.models.contractor.Contractor;
import ua.kushnir.petproject.models.product.Product;

import java.util.Map;
import java.util.UUID;

@Entity
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "number", nullable = false)
    private String number;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contractor_id", referencedColumnName = "id", nullable = false)
    private Contractor contractor;
    @OneToMany(fetch = FetchType.EAGER)
    private Map<Integer, Product> products;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
