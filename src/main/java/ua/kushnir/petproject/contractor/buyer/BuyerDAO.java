package ua.kushnir.petproject.contractor.buyer;

import jakarta.persistence.*;
import ua.kushnir.petproject.contractor.Contractor;
import ua.kushnir.petproject.orders.OrderDAO;

import java.util.List;

@Entity
@Table(name="buyers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "contractor_type", discriminatorType = DiscriminatorType.STRING)
public class BuyerDAO extends Contractor {
    @OneToMany(fetch = FetchType.EAGER)
    private List<OrderDAO> saleOrders;
}
