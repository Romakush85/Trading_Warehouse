package ua.kushnir.petproject.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kushnir.petproject.models.contractor.supplier.Supplier;
import ua.kushnir.petproject.repositories.SuppliersRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Data
@Transactional(readOnly = true)
public class SuppliersService {

    private final SuppliersRepository suppliersRepository;

    @Autowired
    public SuppliersService(SuppliersRepository suppliersRepository) {
        this.suppliersRepository = suppliersRepository;
    }

    public List<Supplier> findAll() {
        return suppliersRepository.findAll();
    }

    public Supplier findOne(UUID id) {
        Optional<Supplier> foundSupplier = suppliersRepository.findById(id);
        return foundSupplier.orElse(null);
    }

    @Transactional
    public void save(Supplier supplier) {suppliersRepository.save(supplier);}

    @Transactional
    public void update(UUID id, Supplier updatedSupplier) {
        Supplier supplierToBeUpdate = findOne(id);
        updatedSupplier.getContract().setId(supplierToBeUpdate.getContract().getId());
        updatedSupplier.getContacts().setId(supplierToBeUpdate.getContacts().getId());
        updatedSupplier.setId(id);
        suppliersRepository.save(updatedSupplier);
    }

    @Transactional
    public void delete(UUID id) {
        suppliersRepository.deleteById(id);
    }

}
