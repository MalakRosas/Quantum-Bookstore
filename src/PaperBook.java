package src;

public class PaperBook extends Book implements Shippable {
  private int quantity;
  private String address;

  public PaperBook(String ISBN, String title, int year, double price, int quantity, String address) {
    super(ISBN, title, year, price);
    this.quantity = quantity;
    this.address = address;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getAddress() {
    return address;
  }

  public void reduceQuantity(int amount) {
    if (amount > quantity) {
      throw new IllegalArgumentException("There is no enough stock!");
    }
    quantity--;
  }
}
