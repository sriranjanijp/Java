import java.io.*;
import java.util.Scanner;

/*
4
2001 Joker A1 150.0
2002 Interstellar B2 180.0
2003 Joker C3 200.0
2004 Tenet D5 220.0
Inception
/**
 * Ticket class to store details of a movie ticket.
 * It implements Serializable to allow objects of this class to be written to a file.
 */
class Ticket implements Serializable {
    // serialVersionUID is used for version control during deserialization
    private static final long serialVersionUID = 1L;

    private int ticketId;
    private String movieName;
    private String seatNumber;
    private double price;

    /**
     * Constructor to initialize a Ticket object.
     * @param ticketId The unique ID of the ticket.
     * @param movieName The name of the movie.
     * @param seatNumber The seat number (e.g., "A5").
     * @param price The price of the ticket.
     */
    public Ticket(int ticketId, String movieName, String seatNumber, double price) {
        this.ticketId = ticketId;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    /**
     * Getter for the movie name.
     * @return The movie name.
     */
    public String getMovieName() {
        return movieName;
    }

    // Other getters can be added if needed, but are not required for this problem.
}

/**
 * Main class to manage ticket booking, serialization, deserialization, and search.
 */
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = "tickets.ser";

        try {
            // Read the number of tickets
            int n = Integer.parseInt(sc.nextLine());
            
            Ticket[] tickets = new Ticket[n];

            // Read ticket details
            for (int i = 0; i < n; i++) {
                String[] input = sc.nextLine().split(" ");
                int ticketId = Integer.parseInt(input[0]);
                String movieName = input[1];
                String seatNumber = input[2];
                double price = Double.parseDouble(input[3]);
                tickets[i] = new Ticket(ticketId, movieName, seatNumber, price);
            }

            // Read the movie name to search for
            String searchMovie = sc.nextLine();

            // Serialize the array of Ticket objects to a file
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(tickets);
            }

            // Deserialize the array of Ticket objects from the file
            Ticket[] loadedTickets;
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                loadedTickets = (Ticket[]) ois.readObject();
            }

            // Count the tickets for the specified movie
            int count = 0;
            if (loadedTickets != null) {
                for (Ticket ticket : loadedTickets) {
                    if (ticket.getMovieName().equals(searchMovie)) {
                        count++;
                    }
                }
            }

            // Print the result
            if (count > 0) {
                System.out.println(count);
            } else {
                System.out.println("No tickets booked for this movie");
            }

        } catch (Exception e) {
            // Handle potential exceptions like IOException, ClassNotFoundException, etc.
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}

