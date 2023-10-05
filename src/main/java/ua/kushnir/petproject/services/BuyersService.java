package ua.kushnir.petproject.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kushnir.petproject.models.contractor.buyer.Buyer;
import ua.kushnir.petproject.repositories.BuyersRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Data
@Transactional(readOnly = true)
public class BuyersService {

    private final BuyersRepository buyersRepository;
    @Autowired
    public BuyersService(BuyersRepository buyersRepository) {
        this.buyersRepository = buyersRepository;
    }

    public List<Buyer> findAll() {
        return buyersRepository.findAll();
    }

    public Buyer findOne(UUID id) {
        Optional<Buyer> foundBuyer = buyersRepository.findById(id);
        return foundBuyer.orElse(null);
    }

    @Transactional
    public void save(Buyer buyer) {
        buyersRepository.save(buyer);
    }

    @Transactional
    public void update(UUID id, Buyer updatedBuyer) {
        Buyer buyerToBeUpdate = findOne(id);
        updatedBuyer.getContract().setId(buyerToBeUpdate.getContract().getId());
        updatedBuyer.getContacts().setId(buyerToBeUpdate.getContacts().getId());
        updatedBuyer.setId(id);
        buyersRepository.save(updatedBuyer);
    }

    @Transactional
    public void delete(UUID id) {
        buyersRepository.deleteById(id);
    }
}
