package ua.kushnir.petproject.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kushnir.petproject.models.order.*;
import ua.kushnir.petproject.repositories.OrdersRepository;
import ua.kushnir.petproject.repositories.SuppliersRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Data
@Transactional(readOnly = true)
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final SuppliersService suppliersService;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository, SuppliersRepository suppliersRepository, SuppliersService suppliersService) {
        this.ordersRepository = ordersRepository;
        this.suppliersService = suppliersService;
    }

    public List<Order> findAll() {
        return ordersRepository.findAll();
    }

    public Order findOne(UUID id) {
        Optional<Order> foundOrder = ordersRepository.findById(id);
        return foundOrder.orElse(null);
    }

    public Order findOneByNumber(String number) {
        Optional<Order> foundOrder = ordersRepository.findByNumber(number);
        return foundOrder.orElse(null);
    }

    @Transactional
    public void update(UUID id, Order updatedOrder) {
        Order orderToBeUpdated = findOne(id);
        updatedOrder.setPositions(orderToBeUpdated.getPositions());
        updatedOrder.setId(id);
        ordersRepository.save(updatedOrder);

    }

    @Transactional
    public void delete(UUID id) {
        ordersRepository.deleteById(id);
    }

    @Transactional
    public Order createPurchaseOrder(UUID supplierId) {
        Order purchaseOrder = new Order();
        purchaseOrder.setOrderType(OrderType.PurchaseOrder);
        String number = OrderNumberGenerator.generateOrderNumber();
        purchaseOrder.setOrderNumber();
        purchaseOrder.setContractor(suppliersService.findOne(supplierId));
        purchaseOrder.setCompletionStatus(CompletionStatus.CREATED);
        purchaseOrder.setPaymentStatus(PaymentStatus.PAYMENT_WAITING);
        ordersRepository.save(purchaseOrder);
        return findOneByNumber(number);
    }
}
