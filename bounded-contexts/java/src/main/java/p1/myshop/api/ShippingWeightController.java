package p1.myshop.api;

import p1.myshop.shipping.DeliveryService;
import p1.myshop.shoppingcart.Cart;

// @RestController
public class ShippingWeightController {

  // @Autowired
  DeliveryService delivery;

  // @GetMapping("/shippingweight")
  public Object shippingweight(/* @RequestParam */ Cart cart) {
    return delivery.calculateOrderWeight(cart);
  }
}
