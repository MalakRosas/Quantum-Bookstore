package src;

public class ShowCaseBook extends Book {
  public ShowCaseBook(String ISBN, String title, int year, double price) {
    super(ISBN, title, year, price);
  }

  public boolean isSellable() {
    return false;
  }
}
