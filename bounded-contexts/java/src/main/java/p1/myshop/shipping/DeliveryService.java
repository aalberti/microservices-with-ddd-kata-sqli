package p1.myshop.shipping;

import java.util.List;

public class DeliveryService {

    public double calculateOrderWeight(List<HasWeight> items) {
        return  items.stream()
                .mapToDouble(HasWeight::weight)
                .sum();
    }
}
