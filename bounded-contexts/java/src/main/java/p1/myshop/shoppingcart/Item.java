package p1.myshop.shoppingcart;

import p1.myshop.shipping.HasWeight;

public interface Item extends HasWeight {
  ItemId itemId();
}
