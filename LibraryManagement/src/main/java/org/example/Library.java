package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> booksByIsbn = new HashMap<>();
    private Map<String, Patron> patronsById = new HashMap<>();

    public void addBook(Book book) {
        booksByIsbn.put(book.getIsbn(), book);
    }

    public void removeBook(String isbn) {
        booksByIsbn.remove(isbn);
    }

    public void updateBook(String isbn, Book updatedBook) {
        booksByIsbn.put(isbn, updatedBook);
    }

    public Book getBookByIsbn(String isbn) {
        return booksByIsbn.get(isbn);
    }

    public Collection<Book> getAllBooks() {
        return booksByIsbn.values();
    }

    public void addPatron(Patron patron) {
        patronsById.put(patron.getId(), patron);
    }

    public void updatePatron(String id, Patron updatedPatron) {
        patronsById.put(id, updatedPatron);
    }

    public Patron getPatronById(String id) {
        return patronsById.get(id);
    }

    public Collection<Patron> getAllPatrons() {
        return patronsById.values();
    }
}
