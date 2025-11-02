import java.io.*;
import java.util.Scanner;

/*
 * 2
201
E=mc^2
Albert Einstein
202
C++ Primer
Stanley B. Lippman
 */

class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class IshaLibrary {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String filename = "books.dat";
        
        try {
            int n = Integer.parseInt(scanner.nextLine());
            
            Book[] books = new Book[n];

            for (int i = 0; i < n; i++) {
                int id = Integer.parseInt(scanner.nextLine());
                String title = scanner.nextLine();
                String author = scanner.nextLine();
                books[i] = new Book(id, title, author);
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(books);
            }

            System.out.println("Successfully serialized " + n + " books to " + filename);
            
            System.out.println("Summary of Books:");
            for (int i = 0; i < books.length; i++) {
                Book book = books[i];
                System.out.println((i + 1) + ". [BookId: " + book.getId() + "] Title: " + 
                                   book.getTitle() + ", Author: " + book.getAuthor());
            }

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}

