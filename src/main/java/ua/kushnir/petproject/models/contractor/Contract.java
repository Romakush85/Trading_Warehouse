package ua.kushnir.petproject.models.contractor;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name="contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "date", nullable = false)
    private Date date;
    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type", nullable = false)
    private  ContractType contractType;

    private enum ContractType {
        SaleContract, PurchaseContract
    }
}
