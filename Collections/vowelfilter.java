import java.util.Scanner;
import java.util.ArrayList; // Added import for ArrayList

/**
 * Contains the logic for filtering words based on vowel count.
 */
    class VowelFilter {
        
        /**
        * Counts the number of vowels (a, e, i, o, u) in a given word.
        * The problem constraints state all words are lowercase.
        */
        private static int countVowels(String word) {
            int count = 0;
            String vowels = "aeiou";
            for (char c : word.toCharArray()) {
                // Check if the character is a vowel
                if (vowels.indexOf(c) != -1) {
                    count++;
                }
            }
            return count;
        }

        /**
        * Reads n words from the scanner into an ArrayList and then
        * prints only those with two or fewer vowels.
        *
        * @param n The number of words to read.
        * @param sc The Scanner object to read input from.
        */
        public static void filterWords(int n, Scanner sc) {
            // Create an ArrayList to store the words
            ArrayList<String> words = new ArrayList<>();
            
            // Read all n words into the list first
            for (int i = 0; i < n; i++) {
                words.add(sc.nextLine());
            }

            // Now, iterate through the ArrayList and filter
            for (String word : words) {
                // Filter and print if vowel count is 2 or less
                if (countVowels(word) <= 2) {
                    System.out.println(word);
                }
            }
        }
    }

/**
 * Main class to run the vowel filter program.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        sc.nextLine(); // Consume the newline after nextInt()
        VowelFilter.filterWords(n, sc);
        sc.close();
    }
}

