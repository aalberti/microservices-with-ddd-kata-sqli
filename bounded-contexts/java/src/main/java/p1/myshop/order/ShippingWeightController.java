package p1.myshop.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import p1.myshop.catalog.CatalogService;
import p1.myshop.shipping.DeliveryService;
import p1.myshop.shoppingcart.Cart;
import p1.myshop.shoppingcart.ShoppingCarService;

import java.util.stream.Collectors;

@RestController
public class ShippingWeightController {

	@Autowired
	DeliveryService delivery;

	@Autowired
	CatalogService catalogService;
	@Autowired
	ShoppingCarService shoppingCarService;

	@GetMapping("/shippingweight")
	public Object shippingweight(/* @RequestParam */ Cart cart) {
       return delivery.calculateOrderWeight(shoppingCarService.toItemIds(cart).stream().map(catalogService::loadItem).collect(Collectors.toList()));
	}
}
