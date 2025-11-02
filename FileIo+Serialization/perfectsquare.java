import java.io.*;

/**
 * Finds perfect squares from a file and writes them to another file,
 * also printing the results to the console.
 */
class PerfectSquareFinder {

    /**
     * Checks if a number is a perfect square.
     * @param n The number to check.
     * @return true if n is a perfect square, false otherwise.
     */
    private boolean isPerfectSquare(int n) {
        if (n < 0) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        // Calculate the integer part of the square root
        int sqrt = (int) Math.sqrt(n);
        // Check if the square of the integer root equals the original number
        return (sqrt * sqrt) == n;
    }

    /**
     * Reads numbers from an input file, finds perfect squares,
     * and writes them to an output file and the console.
     *
     * @param inputFilePath  The path to the input file.
     * @param outputFilePath The path to the output file.
     * @throws IOException If an I/O error occurs.
     */
    public void findPerfectSquares(String inputFilePath, String outputFilePath) throws IOException {
        // Based on constraints, n <= 100
        int[] perfectSquares = new int[100];
        int count = 0;

        // Read from the input file and find perfect squares
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                try {
                    int number = Integer.parseInt(line.trim());
                    if (isPerfectSquare(number)) {
                        if (count < perfectSquares.length) {
                            perfectSquares[count] = number;
                            count++;
                        }
                    }
                } catch (NumberFormatException e) {
                    // Ignore invalid number lines
                }
            }
        }

        // Write to the output file and print to console
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            if (count == 0) {
                writer.write("No perfect squares found");
                System.out.println("No perfect squares found");
            } else {
                for (int i = 0; i < count; i++) {
                    String squareStr = String.valueOf(perfectSquares[i]);
                    writer.write(squareStr);
                    writer.newLine();
                    System.out.println(squareStr);
                }
            }
        }
    }
}

/**
 * Main class to run the perfect square finder.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        int[] numbers = new int[n];
        
        String[] inputNumbers = br.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        File inputFile = null;
        File outputFile = null;

        try {
            inputFile = File.createTempFile("integers", ".txt");
            outputFile = File.createTempFile("perfect_squares", ".txt");
            inputFile.deleteOnExit();
            outputFile.deleteOnExit();
        } catch (IOException e) {
            System.out.println("Error creating temp files: " + e.getMessage());
            return;
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            for (int i = 0; i < n; i++) {
                writer.write(String.valueOf(numbers[i]));
                writer.newLine();
            }
        }

        PerfectSquareFinder finder = new PerfectSquareFinder();
        finder.findPerfectSquares(inputFile.getAbsolutePath(), outputFile.getAbsolutePath());
    }
}

