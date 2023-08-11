package ua.kushnir.petproject.orders;

import lombok.Data;
import ua.kushnir.petproject.contractor.Contractor;
import ua.kushnir.petproject.product.ProductDTO;

import java.util.HashMap;
import java.util.UUID;

@Data
public class OrderDTO {
    private UUID id;
    private String number;
    private Contractor contractor;
    private HashMap<ProductDTO, Integer> products;
    private OrderType orderType;
    private OrderStatus orderStatus;
}
