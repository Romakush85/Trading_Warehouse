package ua.kushnir.petproject.models.contractor;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Contractor {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "name", nullable = false)
    @NotEmpty(message = "Contractor name should not be empty")
    @Size(min = 3, max = 40, message = "Number should be between 3 and 15 characters")
    private String name;
    @Column(name = "reg_number", nullable = false)
    @NotEmpty(message = "Registration number should not be empty")
    @Size(min = 3, max = 16, message = "Registration number should be between 3 and 16 characters")
    private String registrationNumber;
    @OneToOne(mappedBy = "contractor")
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST,
            org.hibernate.annotations.CascadeType.MERGE})
    private Contract contract;
    @OneToOne(mappedBy = "contractor")
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST,
            org.hibernate.annotations.CascadeType.MERGE})
    private Contacts contacts;

    public Contractor(String name, String registrationNumber, String number, Date date,
                      String contactPersonName, String phoneNumber, String email, String address) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.contract = new Contract(number, date);
        this.contacts = new Contacts(contactPersonName, phoneNumber, email, address);
    }

    public Contractor() {

    }
}
