package ua.kushnir.petproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kushnir.petproject.models.product.Product;

import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository<Product, UUID> {
}
