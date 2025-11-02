import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Manages inventory by calculating stock values from an input file
 * and writing the results to an output file.
 */
class InventoryManager {

    /**
     * Reads product data from an input file, calculates stock value for each product
     * and the total stock value, then writes the results to an output file.
     *
     * @param inputFilePath  The path to the file containing inventory data.
     * @param outputFilePath The path to the file where stock values will be written.
     */
    public void calculateStockValue(String inputFilePath, String outputFilePath) throws IOException {
        double totalStockValue = 0.0;
        StringBuilder outputBuilder = new StringBuilder();

        // Read from the inventory file and calculate values
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // Skip empty lines
                }
                String[] parts = line.split(" ");
                String productName = parts[0];
                double unitPrice = Double.parseDouble(parts[1]);
                int stockQuantity = Integer.parseInt(parts[2]);

                double stockValue = unitPrice * stockQuantity;
                totalStockValue += stockValue;

                // Add product's stock value to the output
                outputBuilder.append(String.format("%s: Rs.%.1f\n", productName, stockValue));
            }
        }

        // Add the total stock value to the output
        outputBuilder.append(String.format("Total Stock Value: Rs.%.1f\n", totalStockValue));

        // Write the consolidated results to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(outputBuilder.toString());
        }
    }
}

/**
 * Main class to run the inventory management system.
 * It reads input from the console, writes it to a temporary inventory file,
 * processes it using InventoryManager, and prints the results from the output file.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfProducts = Integer.parseInt(br.readLine().trim());
        StringBuilder inventoryDataBuilder = new StringBuilder();
        for (int i = 0; i < numberOfProducts; i++) {
            inventoryDataBuilder.append(br.readLine()).append("\n");
        }

        // Create temporary files for input and output
        File inputFile = null;
        File outputFile = null;
        try {
            inputFile = File.createTempFile("inventory", ".txt");
            outputFile = File.createTempFile("stock_value", ".txt");
            
            // Ensure temporary files are deleted on exit
            inputFile.deleteOnExit();
            outputFile.deleteOnExit();
        } catch (IOException e) {
            System.out.println("Error creating temporary files: " + e.getMessage());
            return;
        }


        // Write console input to the temporary inventory file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write(inventoryDataBuilder.toString());
        }

        // Process the inventory file and create the stock value file
        InventoryManager manager = new InventoryManager();
        manager.calculateStockValue(inputFile.getAbsolutePath(), outputFile.getAbsolutePath());

        // Read the results from the stock value file and print to console
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}

