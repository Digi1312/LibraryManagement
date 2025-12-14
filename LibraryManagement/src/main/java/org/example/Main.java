package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Inventory inventory = new Inventory();
        LendingService lendingService = new LendingService(library, inventory);
        Scanner scanner = new Scanner(System.in);

        // Sample data
        Book book1 = new Book("English NCERT", "Suman", "9780134685991", 2018);
        Book book2 = new Book("Mathematics", "RD Sharma", "9780132350884", 2008);
        library.addBook(book1);
        library.addBook(book2);
        inventory.addBook(book1.getIsbn());
        inventory.addBook(book2.getIsbn());

        Patron patron1 = new Patron("Ram", "P001");
        library.addPatron(patron1);

        // Demonstrate search (Strategy Pattern)
        SearchStrategy searchByTitle = new SearchByTitle();
        Book found = searchByTitle.search(library, "English NCERT");
        System.out.println("Search by title: " + (found != null ? found.getTitle() : "Not found"));

        // Demonstrate checkout
        boolean checkedOut = lendingService.checkoutBook("9780134685991", "P001");
        System.out.println("Checkout English NCERT: " + (checkedOut ? "Success" : "Failed"));

        // Demonstrate return
        boolean returned = lendingService.returnBook("9780134685991", "P001");
        System.out.println("Return English NCERT: " + (returned ? "Success" : "Failed"));

        // Demonstrate observer (add observer, notify on return)
        BookAvailabilityNotifier notifier = new BookAvailabilityNotifier();
        notifier.addObserver((book, available) -> {
            System.out.println("Observer: Book '" + book.getTitle() + "' is now " + (available ? "available" : "unavailable"));
        });
        // Simulate notification on return
        notifier.notifyObservers(book1, true);
    }
}