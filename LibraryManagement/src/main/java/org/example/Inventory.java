package org.example;

import java.util.HashSet;
import java.util.Set;

public class Inventory {
    private Set<String> availableBooks = new HashSet<>();
    private Set<String> borrowedBooks = new HashSet<>();

    public void addBook(String isbn) {
        availableBooks.add(isbn);
    }

    public void removeBook(String isbn) {
        availableBooks.remove(isbn);
        borrowedBooks.remove(isbn);
    }

    public boolean isAvailable(String isbn) {
        return availableBooks.contains(isbn);
    }

    public void borrowBook(String isbn) {
        if (availableBooks.remove(isbn)) {
            borrowedBooks.add(isbn);
        }
    }

    public void returnBook(String isbn) {
        if (borrowedBooks.remove(isbn)) {
            availableBooks.add(isbn);
        }
    }

    public Set<String> getAvailableBooks() {
        return availableBooks;
    }

    public Set<String> getBorrowedBooks() {
        return borrowedBooks;
    }
}
