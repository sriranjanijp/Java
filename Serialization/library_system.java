import java.io.*;
import java.util.*;
/*
 * 3
401 AlgorithmsAndData BobDavis 4
402 DatabaseManagement CarlaMoore 6
403 MobileDevelopment JakeBrown 3
3
 */
class Book implements Serializable {
    
    private static final long serialVersionUID = 1L;

    int book_id;
    String title;
    String author;
    int copies;

    public Book(int book_id, String title, String author, int copies) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public int getCopies() {
        return copies;
    }

    @Override
    public String toString() {
        return book_id + " " + title + " " + author + " " + copies;
    }
}

class Library_System{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String filename = "books.ser";

        Book[] bookList;

        try {
            int n = scanner.nextInt();
            bookList = new Book[n];
            
            for (int i = 0; i < n; i++) {
                int id = scanner.nextInt();
                String title = scanner.next();
                String author = scanner.next();
                int copies = scanner.nextInt();
                bookList[i] = new Book(id, title, author, copies); // Assign to array index
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(bookList);
            }

            int threshold = scanner.nextInt();

            Book[] deserializedBooks = null;
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
    
                deserializedBooks = (Book[]) ois.readObject();
            }
            
            boolean found = false;
            if (deserializedBooks != null) {
                for (Book book : deserializedBooks) {
                    if (book.getCopies() > threshold) {
                        System.out.println(book);
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println("No books found above threshold");
            }


        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        
    }
}
}