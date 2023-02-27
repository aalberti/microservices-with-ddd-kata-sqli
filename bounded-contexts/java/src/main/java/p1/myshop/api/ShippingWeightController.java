package p1.myshop.api;

import java.util.List;
import p1.myshop.catalog.CatalogService;
import p1.myshop.shipping.DeliveryService;
import p1.myshop.shoppingcart.Cart;
import p1.myshop.shoppingcart.CartItem;
import p1.myshop.shoppingcart.Item;

// @RestController
public class ShippingWeightController {

  // @Autowired
  private DeliveryService delivery;
  private CatalogService catalogService;

  // @GetMapping("/shippingweight")
  public Object shippingweight(/* @RequestParam */ Cart cart) {
    List<Item> items = mapCartItemsToCatalogItem(cart);
    return delivery.calculateOrderWeight(items);
  }

  private List<Item> mapCartItemsToCatalogItem(Cart cart) {
    return cart.items().stream().map(CartItem::itemId).map(catalogService::loadItem).toList();
  }
}
