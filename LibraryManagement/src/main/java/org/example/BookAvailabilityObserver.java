package org.example;

import java.util.ArrayList;
import java.util.List;

// Use simple class name for Book, as it is in the same package
public interface BookAvailabilityObserver {
    void update(Book book, boolean available);
}

class BookAvailabilityNotifier {
    private final List<BookAvailabilityObserver> observers = new ArrayList<>();

    public void addObserver(BookAvailabilityObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BookAvailabilityObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Book book, boolean available) {
        for (BookAvailabilityObserver observer : observers) {
            observer.update(book, available);
        }
    }
}
