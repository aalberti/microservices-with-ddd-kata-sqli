package p1.myshop.catalog;

import p1.myshop.shipping.HasWeight;

public interface Item extends HasWeight {
    ItemId itemId();
}
