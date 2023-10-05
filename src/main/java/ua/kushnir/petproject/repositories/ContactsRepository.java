package ua.kushnir.petproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kushnir.petproject.models.contractor.Contacts;


import java.util.UUID;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, UUID> {
}
