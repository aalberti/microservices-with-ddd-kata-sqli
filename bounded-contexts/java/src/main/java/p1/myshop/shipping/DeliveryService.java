package p1.myshop.shipping;

import java.util.List;
import p1.myshop.catalog.CatalogService;
import p1.myshop.shoppingcart.Item;

public class DeliveryService {
  private final CatalogService catalogService;

  public DeliveryService(CatalogService catalogService) {
    this.catalogService = catalogService;
  }

  public double calculateOrderWeight(List<Item> items) {
    return items.stream().mapToDouble(HasWeight::weight).sum();
  }
}
