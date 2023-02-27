package p1.myshop.shipping;

import p1.myshop.catalog.HasWeight;
import p1.myshop.catalog.CatalogService;
import p1.myshop.catalog.ItemId;
import p1.myshop.shoppingcart.Cart;
import p1.myshop.shoppingcart.CartItem;

public class DeliveryService {
    private final CatalogService catalogService;

    public DeliveryService(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    public double calculateOrderWeight(Cart cart) {
        return cart.items().stream()
                .map(CartItem::productId)
                .map(productId -> ItemId.from(productId.toString()))
                .map(catalogService::loadItem)
                .mapToDouble(HasWeight::weight)
                .sum();
    }
}
