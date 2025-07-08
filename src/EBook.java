package src;

public class EBook extends Book {
  private String fileType;
  private String email;

  public EBook(String ISBN, String title, int year, double price, String fileType, String email) {
    super(ISBN, title, year, price);
    this.fileType = fileType;
    this.email = email;
  }

  public String getFileType() {
    return fileType;
  }

  public String getEmail() {
    return email;
  }
}
