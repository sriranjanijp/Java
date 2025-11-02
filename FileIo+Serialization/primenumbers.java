import java.io.*;

/**
 * Finds prime numbers from a file and writes them to another file.
 */
class Solution {

    /**
     * Checks if a number is prime.
     * @param n The number to check.
     * @return true if n is prime, false otherwise.
     */
    private boolean isPrime(int n) {
        // Prime numbers are greater than 1
        if (n <= 1) {
            return false;
        }
        // Check for divisibility from 2 up to the square root of n
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false; // Found a divisor, not prime
            }
        }
        return true; // No divisors found, it's prime
    }

    /**
     * Reads space-separated numbers from an input file, finds prime numbers,
     * and writes them space-separated to an output file.
     *
     * @param inputFilePath  The path to the input file.
     * @param outputFilePath The path to the output file.
     * @throws IOException If an I/O error occurs.
     */
    public void findPrimes(String inputFilePath, String outputFilePath) throws IOException {
        String[] numbers;
        
        // Read the single line of numbers from the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line = reader.readLine();
            if (line == null || line.trim().isEmpty()) {
                numbers = new String[0]; // No numbers to process
            } else {
                numbers = line.trim().split("\\s+");
            }
        }

        // Based on constraints, n <= 15
        int[] primesFound = new int[15];
        int primeCount = 0;

        // Check each number
        for (String numStr : numbers) {
            try {
                int number = Integer.parseInt(numStr);
                if (isPrime(number)) {
                    if (primeCount < primesFound.length) {
                        primesFound[primeCount] = number;
                        primeCount++;
                    }
                }
            } catch (NumberFormatException e) {
                // Ignore invalid number formats
            }
        }

        // Write the results to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            if (primeCount == 0) {
                writer.write("No primes found");
            } else {
                // Build the space-separated string of primes
                StringBuilder outputBuilder = new StringBuilder();
                for (int i = 0; i < primeCount; i++) {
                    outputBuilder.append(primesFound[i]);
                    if (i < primeCount - 1) {
                        outputBuilder.append(" ");
                    }
                }
                writer.write(outputBuilder.toString());
            }
        }
    }
}

/**
 * Main class to run the prime number finder.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String numbersLine = br.readLine().trim();

        File dataFile = null;
        File outputFile = null;

        try {
            dataFile = File.createTempFile("numbers", ".txt");
            outputFile = File.createTempFile("primes_result", ".txt");
            dataFile.deleteOnExit();
            outputFile.deleteOnExit();
        } catch (IOException e) {
            System.out.println("Error creating temp files: " + e.getMessage());
            return;
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile))) {
            writer.write(numbersLine);
            writer.newLine();
        }

        Solution solution = new Solution();
        solution.findPrimes(dataFile.getAbsolutePath(), outputFile.getAbsolutePath());

        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}

