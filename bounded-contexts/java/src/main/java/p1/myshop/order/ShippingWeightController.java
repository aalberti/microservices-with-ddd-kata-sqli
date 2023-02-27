package p1.myshop.order;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import p1.myshop.catalog.CatalogService;
import p1.myshop.catalog.Item;
import p1.myshop.catalog.ItemId;
import p1.myshop.shipping.DeliveryService;
import p1.myshop.shoppingcart.Cart;
import p1.myshop.shoppingcart.CartItem;

@RestController
public class ShippingWeightController {

	@Autowired
	DeliveryService delivery;

	@Autowired
	CatalogService catalogService;


	@GetMapping("/shippingweight")
	public Object shippingweight(/* @RequestParam */ Cart cart) {
		List<Item> items = cart.items().stream()
				.map(CartItem::productId)
				.map(productId -> ItemId.from(productId.toString()))
				.map(catalogService::loadItem).collect(Collectors.toList());

		return delivery.calculateOrderWeight(items);
	}
}
