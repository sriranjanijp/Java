import java.io.*;
import java.util.*;

// Serializable class representing a book lending record
class BookLending implements Serializable {
    // Use serialVersionUID for version control during serialization
    private static final long serialVersionUID = 1L;
    
    private String title;
    private int bookID;
    private String borrowerName;

    public BookLending(String title, int bookID, String borrowerName) {
        this.title = title;
        this.bookID = bookID;
        this.borrowerName = borrowerName;
    }

    public String getTitle() { return title; }
    public int getBookID() { return bookID; }
    public String getBorrowerName() { return borrowerName; }
}

/**
 * Manages serialization, deserialization, and validation for BookLending objects.
 */
class BookLendingManager {

    /**
     * Validates if the book ID string is a positive integer.
     * @param bookIDStr The book ID string to validate.
     * @return true if it's a positive integer, false otherwise.
     */
    public boolean isValidBookID(String bookIDStr) {
        if (bookIDStr == null || bookIDStr.isEmpty()) {
            return false;
        }
        try {
            int id = Integer.parseInt(bookIDStr);
            return id > 0;
        } catch (NumberFormatException e) {
            return false; // Not an integer
        }
    }

    /**
     * Validates if the borrower's name is non-empty.
     * @param borrowerName The name to validate.
     * @return true if the name is not null and not empty, false otherwise.
     */
    public boolean isValidBorrowerName(String borrowerName) {
        return borrowerName != null && !borrowerName.trim().isEmpty();
    }

    /**
     * Serializes a BookLending object into a byte array.
     * @param book The BookLending object to serialize.
     * @return A byte array representing the serialized object.
     * @throws IOException If an I/O error occurs during serialization.
     */
    public byte[] serialize(BookLending book) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            
            oos.writeObject(book);
            return bos.toByteArray();
        }
    }

    /**
     * Deserializes a BookLending object from a byte array.
     * @param data The byte array to deserialize.
     * @return The deserialized BookLending object.
     * @throws IOException If an I/O error occurs during deserialization.
     * @throws ClassNotFoundException If the class of the serialized object cannot be found.
     */
    public BookLending deserialize(byte[] data) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            
            return (BookLending) ois.readObject();
        }
    }
}


// Main class for user input and output
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookLendingManager manager = new BookLendingManager();

        // Input
        String title = sc.nextLine();
        String bookIDStr = sc.nextLine();
        String borrowerName = sc.nextLine();

        // Validation
        if (!manager.isValidBookID(bookIDStr)) {
            System.out.println("Invalid book ID! Must be a positive integer.");
            sc.close();
            return;
        }

        // Note: The provided Main class has this check, but the sample output
        // doesn't show a case for it. We keep it as requested in the template.
        if (!manager.isValidBorrowerName(borrowerName)) {
            System.out.println("Invalid borrower's name! Name cannot be empty.");
            sc.close();
            return;
        }

        int bookID = Integer.parseInt(bookIDStr);
        BookLending book = new BookLending(title, bookID, borrowerName);

        try {
            // Serialization
            byte[] data = manager.serialize(book);

            // Deserialization
            BookLending b = manager.deserialize(data);

            // Output
            System.out.println("Book Title: " + b.getTitle());
            System.out.println("Book ID: " + b.getBookID());
            System.out.println("Borrower's Name: " + b.getBorrowerName());

        } catch (IOException | ClassNotFoundException e) {
            // Print stack trace for debugging purposes in a real app
            // For this problem, we just let it fail silently if an error occurs
            // e.printStackTrace(); 
        }

        sc.close();
    }
}

