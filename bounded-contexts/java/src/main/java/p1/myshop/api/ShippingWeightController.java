package p1.myshop.api;

import java.util.List;
import java.util.stream.Collectors;
import p1.myshop.catalog.CatalogService;
import p1.myshop.catalog.ItemId;
import p1.myshop.shipping.HasWeight;
import p1.myshop.shipping.Order;
import p1.myshop.shipping.ShippingItem;
import p1.myshop.shipping.ShippingService;
import p1.myshop.shoppingcart.Cart;
import p1.myshop.shoppingcart.CartItem;

// @RestController
public class ShippingWeightController {

  // @Autowired
  private ShippingService delivery;
  private CatalogService catalogService;

  // @GetMapping("/shippingweight")
  public Object shippingweight(/* @RequestParam */ Cart cart) {
    List<HasWeight> items = mapCartItemsToShippingItem(cart);
    return delivery.calculateOrderWeight(new Order(items));
  }

  private List<HasWeight> mapCartItemsToShippingItem(Cart cart) {
    return cart.items().stream()
        .map(CartItem::itemId)
        .map(i -> new ItemId())
        .map(catalogService::loadItem)
        .map(item -> new ShippingItem(item.weight()))
        .collect(Collectors.toList());
  }
}
