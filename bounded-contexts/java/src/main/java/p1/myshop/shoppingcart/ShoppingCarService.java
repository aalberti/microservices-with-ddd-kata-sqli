package p1.myshop.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import p1.myshop.catalog.CatalogService;
import p1.myshop.catalog.ItemId;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCarService {
   @Autowired
    CatalogService catalogService;
    public List<ItemId> toItemIds(Cart cart) {
       return cart.items().stream()
                .map(CartItem::productId)
                .map(productId -> ItemId.from(productId.toString())).collect(Collectors.toList());
    }
}
