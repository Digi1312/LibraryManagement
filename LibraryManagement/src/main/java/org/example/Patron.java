package org.example;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String id;
    private List<Book> borrowingHistory;

    public Patron(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowingHistory = new ArrayList<>();
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public List<Book> getBorrowingHistory() { return borrowingHistory; }
    public void addToBorrowingHistory(Book book) { this.borrowingHistory.add(book); }
}
