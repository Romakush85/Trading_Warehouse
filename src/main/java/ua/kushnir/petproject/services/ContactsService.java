package ua.kushnir.petproject.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kushnir.petproject.models.contractor.Contacts;
import ua.kushnir.petproject.repositories.ContactsRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Data
@Transactional(readOnly = true)
public class ContactsService {

    private final ContactsRepository contactsRepository;
    @Autowired
    public ContactsService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public List<Contacts> findAll() {
        return contactsRepository.findAll();
    }

    public Contacts findOne(UUID id) {
        Optional<Contacts> foundContacts = contactsRepository.findById(id);
        return foundContacts.orElse(null);
    }

    @Transactional
    public void save(Contacts contacts) {
        contactsRepository.save(contacts);
    }

    @Transactional
    public void delete(UUID id) {
        contactsRepository.deleteById(id);
    }
}
