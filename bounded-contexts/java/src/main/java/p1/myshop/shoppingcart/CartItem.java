package p1.myshop.shoppingcart;


public class CartItem {
    public final ProductId productId;
    public final Quantity quantity;

    public CartItem(ProductId productIdId, Quantity quantity) {
        this.productId = productIdId;
        this.quantity = quantity;
    }

    public ProductId productId() {
        return productId;
    }
}
