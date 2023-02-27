package p1.myshop.shipping;

import java.util.List;

public class Order {

  private final List<HasWeight> items;

  public Order(List<HasWeight> items) {
    this.items = items;
  }

  public List<HasWeight> getItems() {
    return items;
  }
}
