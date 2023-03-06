package p1.myshop.shoppingcart;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCarService {
    public List<ProductId> toItemIds(Cart cart) {
        return cart.items().stream()
                .map(CartItem::productId).collect(Collectors.toList());
    }
}
