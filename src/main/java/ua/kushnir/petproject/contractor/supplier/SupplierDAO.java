package ua.kushnir.petproject.contractor.supplier;

import jakarta.persistence.*;
import ua.kushnir.petproject.contractor.Contractor;
import ua.kushnir.petproject.orders.OrderDAO;
import ua.kushnir.petproject.product.ProductDAO;

import java.util.List;

@Entity
@Table(name="suppliers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "contractor_type", discriminatorType = DiscriminatorType.STRING)
public class SupplierDAO extends Contractor {
    @OneToMany(fetch = FetchType.EAGER)
    private List<ProductDAO> products;
    @OneToMany(fetch = FetchType.EAGER)
    private List<OrderDAO> purchaseOrders;


}