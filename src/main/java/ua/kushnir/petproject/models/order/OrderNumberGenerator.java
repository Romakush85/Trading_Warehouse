package ua.kushnir.petproject.models.order;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderNumberGenerator {
    private static int orderCount = 0;

    public static String generateOrderNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyy");
        String datePart = dateFormat.format(new Date());
        String uniqueId = String.format("%02d", ++orderCount);
        return datePart + "-" + uniqueId;
    }
}
