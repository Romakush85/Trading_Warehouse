package ua.kushnir.petproject.models.contractor;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;


@Entity
@Data
@Table(name="contract")
public class Contract {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "number", nullable = false)
    @NotEmpty(message = "Number should not be empty")
    @Size(min = 3, message = "Number should be more than 2  characters")
    private String number;
    @Column(name = "date", nullable = false)
    @NotNull(message = "Date cannot be null")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;
    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type", nullable = true)
    private  ContractType contractType;
    @OneToOne()
    @JoinColumn(name="contractor_id", referencedColumnName = "id")
    private Contractor contractor;

    public Contract() {

    }

    public enum ContractType {
        SaleContract, PurchaseContract
    }
    public Contract(String number, Date date) {
        this.number = number;
        this.date = date;
    }
}
