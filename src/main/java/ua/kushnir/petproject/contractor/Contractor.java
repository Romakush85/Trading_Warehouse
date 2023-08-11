package ua.kushnir.petproject.contractor;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@MappedSuperclass
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "reg_number", nullable = false)
    private String registrationNumber;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contract_id", nullable = false)
    private Contract contract;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contacts_id", nullable = false)
    private Contacts contacts;
}
