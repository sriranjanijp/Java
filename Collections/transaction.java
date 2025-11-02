import java.util.Scanner;
import java.util.ArrayList;

/**
 * Handles the logic for processing bank transactions
 * and filtering duplicates.
 */
class TransactionProcessor {

    /**
     * Reads n transactions, filters out duplicates using an ArrayList, 
     * and prints the unique transactions in their first-seen order.
     *
     * @param n The number of transactions to read.
     * @param sc The Scanner object to read input from.
     */
    public static void processTransactions(int n, Scanner sc) {
        
        // Use an ArrayList to store the unique transactions in the order
        // they are first encountered.
        ArrayList<Integer> uniqueTransactions = new ArrayList<>();
        
        // Read all n transaction amounts
        for (int i = 0; i < n; i++) {
            int amount = sc.nextInt();
            
            // Check if this amount is already in our list of unique transactions.
            // The .contains() method checks for existence.
            if (!uniqueTransactions.contains(amount)) {
                // If it's not present, it's the first occurrence. Add it.
                uniqueTransactions.add(amount);
            }
        }

        // Now, print all the unique transactions that were stored
        for (int amount : uniqueTransactions) {
            System.out.println(amount);
        }
    }
}

/**
 * Main class to run the transaction processing program.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  
        TransactionProcessor.processTransactions(n, sc);
        sc.close();
    }
}

