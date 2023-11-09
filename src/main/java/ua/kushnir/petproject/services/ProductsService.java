package ua.kushnir.petproject.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kushnir.petproject.models.contractor.supplier.Supplier;
import ua.kushnir.petproject.models.product.Product;
import ua.kushnir.petproject.repositories.ProductsRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Data
@Transactional(readOnly = true)
public class ProductsService {
    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public Product findOne(UUID id) {
        Optional<Product> foundProduct = productsRepository.findById(id);
        return foundProduct.orElse(null);
    }

    @Transactional
    public void save(Product product) {
        productsRepository.save(product);
    }

    @Transactional
    public void update(UUID id, Product updatedProduct) {
        Product productToBeUpdated = findOne(id);
        updatedProduct.setOrderPositions(productToBeUpdated.getOrderPositions());
        updatedProduct.setId(id);
        productsRepository.save(updatedProduct);
    }

    @Transactional
    public void delete(UUID id) {
        productsRepository.deleteById(id);
    }

    public boolean isProductAllreadyAdded(Supplier supplier, Product product) {
        return supplier.getProducts().contains(product);
    }

    public List<Product> findAllBySupplierId(UUID supplierId) {
        return productsRepository.findProductsBySupplierId(supplierId);
    }
}
