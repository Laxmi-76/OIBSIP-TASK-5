package digital_library;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    
    private String title;           // title of book
    private String author;          // author name
    private int ISBN;               // ISBN(International Standard Book Number)

    public Book(String title, String author, int ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getISBN() {
        return ISBN;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " has been added to the library.");
    }

    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book found:");
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getISBN());
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void removeBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                System.out.println(book.getTitle() + " has been removed from the library.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

class Admin {
    private Library library;

    public Admin(Library library) {
        this.library = library;
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the book ISBN: ");
        int ISBN = scanner.nextInt();
        scanner.nextLine();
        Book book = new Book(title, author, ISBN);
        library.addBook(book);
    }

    public void removeBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book title to remove: ");
        String title = scanner.nextLine();
        library.removeBook(title);
    }
}

class User {
    private Library library;

    public User(Library library) {
        this.library = library;
    }

    public void searchBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book title to search for: ");
        String title = scanner.nextLine();
        library.searchBook(title);
    }
}

public class digital_library {
    public static void main(String[] args) {
        Library library = new Library();
        Admin admin = new Admin(library);
        User user = new User(library);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter 1. Admin module");
            System.out.println("Enter 2. User module");
            System.out.println("Enter 3. To exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nEnter 1 to add a book");
                    System.out.println("Enter 2 to remove a book");
                    int adminChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (adminChoice) {
                        case 1:
                            admin.addBook();
                            break;
                        case 2:
                            admin.removeBook();
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\nEnter 1 to search for a book");
                    int userChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (userChoice) {
                        case 1:
                            user.searchBook();
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}

