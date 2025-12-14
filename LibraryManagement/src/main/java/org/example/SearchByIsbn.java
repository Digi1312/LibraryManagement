package org.example;

public class SearchByIsbn implements SearchStrategy {
    @Override
    public Book search(Library library, String query) {
        return library.getBookByIsbn(query);
    }
}
