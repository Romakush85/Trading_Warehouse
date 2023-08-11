package ua.kushnir.petproject.orders;

import jakarta.persistence.*;
import ua.kushnir.petproject.contractor.Contractor;
import ua.kushnir.petproject.product.ProductDAO;

import java.util.HashMap;
import java.util.UUID;

@Entity
@Table(name="orders")
public class OrderDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "number", nullable = false)
    private String number;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "contractor_id", nullable = false)
//    private Contractor contractor;
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Map<ProductDAO, int> products;
//    private OrderType orderType;
//    private OrderStatus orderStatus;
}
