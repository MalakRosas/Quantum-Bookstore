📘Quantum Bookstore
==================
This Java project simulates a simple online bookstore.

📌Features
--------
- Add books to the inventory
- Remove old books (older than a number of years)
- Buy a book by ISBN and quantity
- Handle different types of books:
  - PaperBook → shipped to address
  - EBook → sent to email
  - ShowCaseBook → not for sale

Classes
-------
- Book → parent class (ISBN, title, year, price, author)
- PaperBook, EBook, ShowCaseBook → extend Book
- Inventory → manages books
- ShippingService, MailService → print shipping/email info
- QuantumBookstoreFullTest → main class that tests everything

Test Cases in QuantumBookstoreFullTest
--------------------------------------
- Add 5 books to inventory
- Remove books older than 10 years
- Buy a paper book (should print shipping info)
- Buy an ebook (should print email info)
- Try to buy a showcase book (should show error)
