package src;

import java.util.ArrayList;
import java.util.List;

public class QuantumBookstoreFullTest {
  public static void main(String[] args) {
    PaperBook paperBook = new PaperBook("1", "A Brief History of Time", 2016, 500, 5, "Alexandria, behind AAST");
    PaperBook paperBook1 = new PaperBook("2", "Why We Sleep", 2000, 550, 10, "Cairo, Maadi");
    EBook eBook = new EBook("3", "On the Origin of Species", 2017, 250, "PDF", "malakrosass@gmail.com");
    EBook eBook1 = new EBook("4", "Silent Spring", 1962, 350, "PDF", "merna@gmail.com");
    ShowCaseBook showCaseBook = new ShowCaseBook("5", "The Selfish Gene", 2020, 300);
    Inventory inventory = new Inventory();
    inventory.addBook(paperBook);
    inventory.addBook(eBook);
    inventory.addBook(showCaseBook);
    inventory.addBook(eBook1);
    inventory.addBook(paperBook1);

    System.out.println("Available books:\n");
    List<Book> booksList = new ArrayList<>(inventory.getAllBooks());
    for (Book book : booksList) {
      System.out.println(book);
    }
    System.out.println("\nRemoving books older than 10 years");
    List<Book> removedBooks = inventory.removeOldBooks(10);
    for (Book old : removedBooks) {
      System.out.println("Removed: " + old);
    }

    try {
      System.out.println("\nBuying 2 copies of A Brief History of Time");
      double paid = inventory.buyBook("1", 2, "", "Alexandria, behind AAST");
      System.out.println("Paid: " + paid + " EGP");
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }

    try {
      System.out.println("\nBuying On the Origin of Species eBook");
      double paid = inventory.buyBook("3", 1, "malakrosass@gmail.com", "");
      System.out.println("Paid: " + paid + " EGP");
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }

    try {
      System.out.println("\nTrying to buy The Selfish Gene");
      inventory.buyBook("5", 1, "", "");
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
