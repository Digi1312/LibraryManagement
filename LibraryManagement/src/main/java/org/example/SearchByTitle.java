package org.example;

public class SearchByTitle implements SearchStrategy {
    @Override
    public Book search(Library library, String query) {
        for (Book book : library.getAllBooks()) {
            if (book.getTitle().equalsIgnoreCase(query)) {
                return book;
            }
        }
        return null;
    }
}
