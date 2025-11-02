import java.util.Scanner;

public class Main {

    /**
     * A generic method to reverse the elements of an array in place.
     * <T> is a type parameter that stands for any object type.
     */
    public static <T> void reverseArray(T[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            // Swap the elements at the start and end pointers
            T temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            // Move the pointers toward the center
            start++;
            end--;
        }
    }

    /**
     * A generic helper method to print an array in the format [e1, e2, e3].
     */
    public static <T> void printArray(T[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the size of the array
        int n = sc.nextInt();

        // Create an array of Integer objects.
        // Generics require object types, not primitives (like int).
        Integer[] intArray = new Integer[n];

        // Read the elements into the array
        for (int i = 0; i < n; i++) {
            intArray[i] = sc.nextInt();
        }

        // 1. Print the original array
        printArray(intArray);

        // 2. Reverse the array using the generic method
        reverseArray(intArray);

        // 3. Print the reversed array
        printArray(intArray);

        sc.close();
    }
}