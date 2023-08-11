package ua.kushnir.petproject.contractor.supplier;

import lombok.Data;
import ua.kushnir.petproject.contractor.Contractor;
import ua.kushnir.petproject.orders.OrderDTO;
import ua.kushnir.petproject.product.ProductDAO;
import ua.kushnir.petproject.product.ProductDTO;

import java.util.List;

@Data
public class SupplierDTO extends Contractor {
    private List<ProductDTO> products;
    private List<OrderDTO> purchaseOrders;

}
