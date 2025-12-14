package org.example;

public class SearchByAuthor implements SearchStrategy {
    @Override
    public Book search(Library library, String query) {
        for (Book book : library.getAllBooks()) {
            if (book.getAuthor().equalsIgnoreCase(query)) {
                return book;
            }
        }
        return null;
    }
}

