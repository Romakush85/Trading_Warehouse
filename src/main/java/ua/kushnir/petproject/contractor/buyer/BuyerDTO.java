package ua.kushnir.petproject.contractor.buyer;

import lombok.Data;
import ua.kushnir.petproject.contractor.Contractor;
import ua.kushnir.petproject.orders.OrderDTO;

import java.util.List;

@Data
public class BuyerDTO extends Contractor {
    private List<OrderDTO> saleOrders;
}
