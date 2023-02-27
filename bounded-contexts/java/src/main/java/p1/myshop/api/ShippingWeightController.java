package p1.myshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import p1.myshop.services.shipping.DeliveryService;
import p1.myshop.services.shoppingcart.Cart;

@RestController
public class ShippingWeightController {

	@Autowired
	DeliveryService delivery;

	@GetMapping("/shippingweight")
	public Object shippingweight(/* @RequestParam */ Cart cart) {
		return delivery.calculateOrderWeight(cart);
	}
}
