package src;

import java.time.LocalDate;
import java.util.*;

public class Inventory {
  private List<Book> books = new ArrayList<>();
  private ShippingService shippingService = new ShippingService();
  private MailService mailService = new MailService();

  public void addBook(Book book) {
    books.add(book);
  }

  public List<Book> removeOldBooks(int maxAgeYears) {
    List<Book> removed = new ArrayList<>();
    int currentYear = LocalDate.now().getYear();

    Iterator<Book> iterator = books.iterator();
    while (iterator.hasNext()) {
      Book book = iterator.next();
      int age = currentYear - book.getYear();
      if (age > maxAgeYears) {
        removed.add(book);
        iterator.remove();
      }
    }

    return removed;
  }

  public double buyBook(String isbn, int quantity, String email, String address) {
    for (Book book : books) {
      if (book.getISBN().equals(isbn)) {
        if (!book.isSellable()) {
          throw new IllegalStateException("Quantum bookstore: This book is not for sale.");
        }

        if (book instanceof PaperBook) {
          PaperBook paperBook = (PaperBook) book;
          if (paperBook.getQuantity() < quantity) {
            throw new IllegalArgumentException("Quantum bookstore: Not enough quantity in stock.");
          }
          paperBook.reduceQuantity(quantity);
          shippingService.ship(paperBook);
          return paperBook.getPrice() * quantity;

        } else if (book instanceof EBook) {
          EBook eBook = (EBook) book;
          mailService.send(eBook.getEmail());
          return eBook.getPrice();
        }
      }
    }
    throw new NoSuchElementException("Quantum bookstore: Book with ISBN not found.");
  }

  public List<Book> getAllBooks() {
    return books;
  }
}
