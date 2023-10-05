package ua.kushnir.petproject.models.contractor;



import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "contacts")
public class Contacts implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "contact_person", nullable = false)
    @NotNull(message = "Contact person name cannot be null")
    @Size(min = 4, max = 50, message
            = "Contact person nam must be between 4 and 50 characters")
    private String contactPersonName;
    @Column(name = "phone_number", nullable = false)
    @NotNull(message = "Phone number  cannot be null")
    private String phoneNumber;
    @Column(name = "email", nullable = false)
    @Email(message = "Email should be valid")
    private String email;
    @Column(name = "address", nullable = false)
    @NotNull(message = "Address cannot be null")
    @Size(min = 10, max = 200, message
            = "Address must be between 10 and 200 characters")
    private String address;
    @OneToOne()
    @JoinColumn(name="contractor_id", referencedColumnName = "id")
    private Contractor contractor;

    public Contacts(String contactPersonName, String phoneNumber, String email, String address) {
        this.contactPersonName = contactPersonName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Contacts() {

    }
}
