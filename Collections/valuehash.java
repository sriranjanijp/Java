import java.util.*;

class ValueProcessor {
    public static Map<String, Double> readValues(Scanner sc) {
        Map<String, Double> m = new HashMap<>();
        while (true) {
            String l = sc.nextLine();
            if (l.equals("done")) {
                break;
            }

            String[] p = l.split(":");

            if (p.length != 2) {
                System.out.println("Invalid format");
                return null;
            }

            String n = p[0];
            String q = p[1];

            if (!n.matches("[a-zA-Z]+")) {
                System.out.println("Invalid format");
                return null;
            }

            try {
                double d = Double.parseDouble(q);
                m.put(n, d);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                return null;
            }
        }
        return m;
    }

    public static double calculateSum(Map<String, Double> m) {
        double s = 0.0;
        for (double v : m.values()) {
            s += v;
        }
        return s;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> valueMap = ValueProcessor.readValues(scanner);
        if (valueMap != null) {
            double sum = ValueProcessor.calculateSum(valueMap);
            System.out.printf("%.2f\n", sum);
        }
        scanner.close();
    }
}

