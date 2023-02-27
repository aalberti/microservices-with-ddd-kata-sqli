package p1.myshop.shipping;

import java.util.List;
import p1.myshop.catalog.HasWeight;
import p1.myshop.catalog.Item;

public class DeliveryService {

    public double calculateOrderWeight(List<Item> items) {
        return  items.stream()
                .mapToDouble(HasWeight::weight)
                .sum();
    }
}
