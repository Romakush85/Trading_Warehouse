package ua.kushnir.petproject.models.contractor.buyer;

import lombok.Data;
import ua.kushnir.petproject.models.contractor.Contract;
import ua.kushnir.petproject.models.contractor.Contractor;
import ua.kushnir.petproject.models.order.Order;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="buyer")
public class Buyer extends Contractor {
    @OneToMany(mappedBy = "contractor", fetch = FetchType.LAZY)
    private List<Order> saleOrders;

    public Buyer(String name, String registrationNumber,
                 String number, Date date,
                 String contactPersonName, String phoneNumber, String email, String address) {
        super(name, registrationNumber, number, date, contactPersonName, phoneNumber, email, address);
        this.getContract().setContractType(Contract.ContractType.SaleContract);
        this.saleOrders = new ArrayList<>();
    }

    public Buyer() {}
}
