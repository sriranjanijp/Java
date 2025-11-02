import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Analyzes numbers from a file to find those greater than their reverse.
 */
class NumberAnalyzer {

    /**
     * Reverses the digits of an integer.
     * @param num The integer to reverse.
     * @return The reversed integer.
     */
    private int reverseInteger(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    /**
     * Reads numbers from an input file, finds those greater than their reverse,
     * and writes the results to an output file.
     *
     * @param inputFilePath  The path to the file containing input numbers.
     * @param outputFilePath The path to the file where results will be written.
     * @throws IOException If an I/O error occurs.
     */
    public void findNumbersGreaterThanReverse(String inputFilePath, String outputFilePath) throws IOException {
        // Using an array. Assuming max 30 numbers based on problem constraints.
        String[] validNumbers = new String[30];
        int validCount = 0;
        
        // Read from the input file and find valid numbers
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // Skip empty lines
                }
                try {
                    int number = Integer.parseInt(line.trim());
                    int reversedNumber = reverseInteger(number);

                    if (number > reversedNumber) {
                        if (validCount < validNumbers.length) { // Prevent overflow
                            validNumbers[validCount] = String.valueOf(number);
                            validCount++;
                        }
                    }
                } catch (NumberFormatException e) {
                    // Ignore lines that are not valid numbers
                }
            }
        }

        // Write the results to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            if (validCount == 0) {
                writer.write("No numbers found");
            } else {
                // Manually join the valid numbers from the array
                StringBuilder outputBuilder = new StringBuilder();
                for (int i = 0; i < validCount; i++) {
                    outputBuilder.append(validNumbers[i]);
                    if (i < validCount - 1) {
                        outputBuilder.append(" ");
                    }
                }
                writer.write(outputBuilder.toString());
            }
        }
    }
}

/**
 * Main class to run the number analysis.
 * It reads console input, writes to a temporary file, processes it,
 * and prints the result from the output file.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder inputData = new StringBuilder();
        String[] numbers = br.readLine().split(" ");
        for (String num : numbers) inputData.append(num).append("\n");

        File inputFile = null;
        File outputFile = null;

        try {
            inputFile = File.createTempFile("input", ".txt");
            outputFile = File.createTempFile("output", ".txt");
            inputFile.deleteOnExit();
            outputFile.deleteOnExit();
        } catch (IOException e) {
            System.out.println("Error creating temporary files: " + e.getMessage());
            return;
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write(inputData.toString());
        }

        NumberAnalyzer analyzer = new NumberAnalyzer();
        analyzer.findNumbersGreaterThanReverse(inputFile.getAbsolutePath(), outputFile.getAbsolutePath());

        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) System.out.println(line);
        }
    }
}

