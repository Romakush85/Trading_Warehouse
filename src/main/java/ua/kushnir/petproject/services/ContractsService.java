package ua.kushnir.petproject.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kushnir.petproject.models.contractor.Contract;
import ua.kushnir.petproject.repositories.ContractsRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Data
@Transactional(readOnly = true)
public class ContractsService {

    private final ContractsRepository contractsRepository;

    @Autowired
    public ContractsService(ContractsRepository contractsRepository) {
        this.contractsRepository = contractsRepository;
    }

    public List<Contract> findAll() {
        return contractsRepository.findAll();
    }

    public Contract findOne(UUID id) {
        Optional<Contract> foundContract = contractsRepository.findById(id);
        return foundContract.orElse(null);
    }

    @Transactional
    public void save(Contract contract) {
        contractsRepository.save(contract);
    }

    @Transactional
    public void delete(UUID id) {
        contractsRepository.deleteById(id);
    }

}
