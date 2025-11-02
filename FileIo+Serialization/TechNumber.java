import java.io.*;

class Solution {

    private boolean isTechNumber(String numStr) {
        int len = numStr.length();
        
        if (len % 2 != 0) {
            return false;
        }

        try {
            int mid = len / 2;
            String firstHalfStr = numStr.substring(0, mid);
            String secondHalfStr = numStr.substring(mid);

            int firstHalf = Integer.parseInt(firstHalfStr);
            int secondHalf = Integer.parseInt(secondHalfStr);
            int originalNum = Integer.parseInt(numStr);

            int sum = firstHalf + secondHalf;
            long sumSquared = (long) sum * sum; 

            return sumSquared == originalNum;
            
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void findTechNumbers(String inputFilePath, String outputFilePath) throws IOException {
        String[] numbers;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line = reader.readLine();
            if (line == null || line.trim().isEmpty()) {
                numbers = new String[0]; 
            } else {
                numbers = line.split(" ");
            }
        }

        // Use an array based on constraints (n <= 15)
        String[] techNumbersFound = new String[15];
        int techCount = 0;
        
        for (String num : numbers) {
            if (isTechNumber(num)) {
                if (techCount < techNumbersFound.length) { // Add to array
                    techNumbersFound[techCount] = num;
                    techCount++;
                }
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            if (techCount == 0) {
                writer.write("Empty");
            } else {
                // Manually build the space-separated string
                StringBuilder outputBuilder = new StringBuilder();
                for (int i = 0; i < techCount; i++) {
                    outputBuilder.append(techNumbersFound[i]);
                    if (i < techCount - 1) {
                        outputBuilder.append(" ");
                    }
                }
                writer.write(outputBuilder.toString());
            }
        }
    }
}

/**
 * Main class to run the tech number finder.
 * It reads console input, writes to a temporary file, processes it,
 * and prints the result from the output file.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String numbersLine = br.readLine();
        
        File numbersFile = null;
        File resultsFile = null;
        
        try {
            numbersFile = File.createTempFile("numbers", ".txt");
            resultsFile = File.createTempFile("results", ".txt");
            numbersFile.deleteOnExit();
            resultsFile.deleteOnExit();
        } catch (IOException e) {
            System.out.println("Error creating temp files: " + e.getMessage());
            return;
        }


        try (BufferedWriter numbersFileWriter = new BufferedWriter(new FileWriter(numbersFile))) {
            numbersFileWriter.write(numbersLine);
        }

        Solution solution = new Solution();
        solution.findTechNumbers(numbersFile.getAbsolutePath(), resultsFile.getAbsolutePath());

        try (BufferedReader resultsReader = new BufferedReader(new FileReader(resultsFile))) {
            String line;
            while ((line = resultsReader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}

