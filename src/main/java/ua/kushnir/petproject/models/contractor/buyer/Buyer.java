package ua.kushnir.petproject.models.contractor.buyer;

import jakarta.persistence.*;
import ua.kushnir.petproject.models.contractor.Contractor;
import ua.kushnir.petproject.models.order.Order;

import java.util.List;

@Entity
@Table(name="buyer")
public class Buyer extends Contractor {
    @OneToMany(mappedBy = "contractor", fetch = FetchType.EAGER)
    private List<Order> saleOrders;
}
