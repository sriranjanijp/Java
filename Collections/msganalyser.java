import java.util.*;
import java.io.*;

class MessageAnalyzer {
    void analyzeMessageFrequency(List<String> l) {
        Map<Character, Integer> tm = new TreeMap<>();

        for (String s : l) {
            for (char ch : s.toCharArray()) {
                if (Character.isLetter(ch)) {
                    tm.put(ch, tm.getOrDefault(ch, 0) + 1);
                }
            }
        }

        System.out.println("Character Frequency:");
        for (Map.Entry<Character, Integer> entry : tm.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lines.add(sc.nextLine());
        }

        MessageAnalyzer analyzer = new MessageAnalyzer();
        analyzer.analyzeMessageFrequency(lines);
        sc.close();
    }
}
