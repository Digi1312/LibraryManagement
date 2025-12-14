package org.example;

import java.util.*;

public class LendingService {
    private final Library library;
    private final Inventory inventory;

    public LendingService(Library library, Inventory inventory) {
        this.library = library;
        this.inventory = inventory;
    }

    public boolean checkoutBook(String isbn, String patronId) {
        Book book = library.getBookByIsbn(isbn);
        Patron patron = library.getPatronById(patronId);
        if (book != null && patron != null && inventory.isAvailable(isbn)) {
            inventory.borrowBook(isbn);
            book.setBorrowed(true);
            patron.addToBorrowingHistory(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn, String patronId) {
        Book book = library.getBookByIsbn(isbn);
        Patron patron = library.getPatronById(patronId);
        if (book != null && patron != null && book.isBorrowed()) {
            inventory.returnBook(isbn);
            book.setBorrowed(false);
            return true;
        }
        return false;
    }
}
