package ua.kushnir.petproject.models.contractor.supplier;


import lombok.Data;
import ua.kushnir.petproject.models.contractor.Contractor;
import ua.kushnir.petproject.models.order.Order;
import ua.kushnir.petproject.models.product.Product;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="supplier")
public class Supplier extends Contractor {
    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    private List<Product> products;
    @OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY)
    private List<Order> purchaseOrders;


    public Supplier(String name, String registrationNumber, String number, Date date,
                    String contactPersonName, String phoneNumber, String email, String address) {
        super(name, registrationNumber, number, date, contactPersonName, phoneNumber, email, address);
        this.products = new ArrayList<>();
        this.purchaseOrders = new ArrayList<>();
    }

    public Supplier() {
        super();
    }

    public void addProduct(Product product) {
            this.products.add(product);
    }

}