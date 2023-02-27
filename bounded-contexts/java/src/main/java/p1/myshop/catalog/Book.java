package p1.myshop.catalog;

import p1.myshop.shoppingcart.Item;
import p1.myshop.shoppingcart.ItemId;

public class Book implements Item {
  @Override
  public ItemId itemId() {
    return null;
  }

  @Override
  public double weight() {
    return 0;
  }
}
