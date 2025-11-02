import java.util.*;

class CourseAnalyzer {
    Map<String, String> identifyHighestAndLowestRatedCourses(Map<String, Double> cr) {
        String h = "";
        double hr = Double.MIN_VALUE;
        String l = "";
        double lr = Double.MAX_VALUE;

        if (cr.isEmpty()) {
            Map<String, String> r = new HashMap<>();
            r.put("highest", "N/A");
            r.put("lowest", "N/A");
            return r;
        }

        for (Map.Entry<String, Double> e : cr.entrySet()) {
            String cn = e.getKey();
            double r = e.getValue();

            if (r > hr) {
                hr = r;
                h = cn;
            }
            if (r < lr) {
                lr = r;
                l = cn;
            }
        }

        Map<String, String> r = new HashMap<>();
        r.put("highest", h);
        r.put("lowest", l);
        return r;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<String, Double> cr = new HashMap<>();

        while (true) {
            String cn = s.nextLine();
            if (cn.equalsIgnoreCase("done")) {
                break;
            }
            try {
                String rStr = s.nextLine().trim();
                double r = Double.parseDouble(rStr);
                cr.put(cn, r);
            } catch (NoSuchElementException | NumberFormatException e) {
                // Handle cases where input is incomplete or not a number before "done"
                break; 
            }
        }

        CourseAnalyzer a = new CourseAnalyzer();
        Map<String, String> r = a.identifyHighestAndLowestRatedCourses(cr);

        System.out.printf("Highest Rated Course: %s\n", r.get("highest"));
        System.out.printf("Lowest Rated Course: %s", r.get("lowest"));

        s.close();
    }
}
