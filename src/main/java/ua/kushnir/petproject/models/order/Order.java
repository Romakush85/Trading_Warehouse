package ua.kushnir.petproject.models.order;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import ua.kushnir.petproject.models.contractor.Contractor;
import ua.kushnir.petproject.models.product.Product;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Entity
@Table(name="orders")
public class Order {

    private static int orderCount = 0;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private final Date date = new Date();
    @Column(name = "number")
    private String number;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractor_id", referencedColumnName = "id", nullable = false)
    private Contractor contractor;
    @OneToMany(mappedBy="order")
    private List<OrderPosition> positions;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    @Enumerated(EnumType.STRING)
    private CompletionStatus completionStatus;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    public Order() {

    }

    public void setOrderNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyy");
        String datePart = dateFormat.format(new Date());
        String uniqueId = String.format("%02d", ++orderCount);
        String number =  this.orderType.equals(OrderType.SaleOrder) ? "SAL" : "PUR" + datePart + "/" + uniqueId;
        setNumber(number);
    }

    public BigDecimal getTotalPrice() {
        return positions.stream()
                .map(position -> position.getPrice().multiply(BigDecimal.valueOf(position.getQuantity())))
                .reduce(BigDecimal.valueOf(0), BigDecimal::add).setScale(2, RoundingMode.HALF_EVEN);
    }
}
