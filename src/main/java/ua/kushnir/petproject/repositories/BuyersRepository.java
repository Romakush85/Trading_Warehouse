package ua.kushnir.petproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kushnir.petproject.models.contractor.buyer.Buyer;

import java.util.UUID;

public interface BuyersRepository extends JpaRepository<Buyer, UUID> {
}
