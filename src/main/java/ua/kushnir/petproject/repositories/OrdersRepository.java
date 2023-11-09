package ua.kushnir.petproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kushnir.petproject.models.order.Order;

import java.util.UUID;
@Repository
public interface OrdersRepository extends JpaRepository<Order, UUID> {
}
