package p1.myshop.shipping;

public class ShippingItem implements HasWeight {

  private double weight;

  public ShippingItem(double weight) {
    this.weight = weight;
  }

  @Override
  public double weight() {
    return weight;
  }
}
