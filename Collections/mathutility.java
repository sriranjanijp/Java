import java.util.*;
import java.io.*;

class MathUtility {
    double calculateGeometricMean(List<Double> nums) {
        double p = 1.0;
        for (double n : nums) {
            p *= n;
        }
        int s = nums.size();
        if (s == 0) return 0.0;
        return Math.pow(p, 1.0 / s);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Double> numbersList = new ArrayList<>();
        MathUtility utility = new MathUtility();

        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            double num = input.nextDouble();
            numbersList.add(num);
        }

        double geometricMean = utility.calculateGeometricMean(numbersList);
        System.out.println("Geometric mean of the list: " + String.format("%.2f", geometricMean));

        input.close();
    }
}
