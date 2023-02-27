package p1.myshop.shipping;

import org.springframework.util.CollectionUtils;

public class ShippingService {

  public double calculateOrderWeight(Order order) {
    if (CollectionUtils.isEmpty(order.getItems())) return 0;
    return order.getItems().stream().mapToDouble(HasWeight::weight).sum();
  }
}
