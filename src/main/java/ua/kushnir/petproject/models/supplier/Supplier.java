package ua.kushnir.petproject.models.supplier;

import jakarta.persistence.*;
import ua.kushnir.petproject.models.contractor.Contractor;
import ua.kushnir.petproject.models.order.Order;
import ua.kushnir.petproject.models.product.Product;

import java.util.List;

@Entity
@Table(name="supplier")
public class Supplier extends Contractor {
    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
    private List<Product> products;
    @OneToMany(mappedBy = "contractor", fetch = FetchType.EAGER)
    private List<Order> purchaseOrders;


}