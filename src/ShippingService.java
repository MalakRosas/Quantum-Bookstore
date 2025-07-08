package src;

public class ShippingService {
  public void ship(Shippable item) {
    System.out.println("Shipping to " + item.getAddress());
  }
}
