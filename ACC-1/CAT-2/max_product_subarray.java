import java.util.Scanner; 
public class Main { 
    public static int maxProduct(int[] arr, int n) { 
        int prefix = 1; 
        int suffix = 1; 
        int maxProduct = Integer.MIN_VALUE; 
        for (int i = 0; i < n; i++) { 
            if (prefix == 0) prefix = 1; 
            if (suffix == 0) suffix = 1; 
            prefix *= arr[i]; 
            suffix *= arr[n - i - 1]; 
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix)); 
        } 
        return maxProduct; 
    } 
    
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt(); 
        int[] arr = new int[n]; 
        for (int i = 0; i < n; i++) { 
            arr[i] = sc.nextInt(); 
        } 
        System.out.println("Maximum Product Subarray: " + maxProduct(arr, n)); 
    } 
}