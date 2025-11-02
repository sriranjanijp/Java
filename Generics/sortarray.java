import java.util.Arrays;
import java.util.Scanner;

/**
 * A generic class to sort an array of any type that implements Comparable.
 * @param <T> The generic type parameter, which must extend Comparable.
 */
class ArraySorter<T extends Comparable<T>> {
    private T[] array;

    /**
     * Constructor to initialize the ArraySorter with an array.
     * @param array The array to be sorted.
     */
    public ArraySorter(T[] array) {
        this.array = array;
    }

    /**
     * Sorts the array in ascending order.
     * We can use Arrays.sort() because T is guaranteed to be Comparable.
     */
    public void sort() {
        Arrays.sort(array);
    }

    /**
     * Prints the array in the format [e1, e2, e3].
     */
    public void printArray() {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

/**
 * Main class to demonstrate the generic ArraySorter with Doubles.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of double values
        int N = sc.nextInt();

        // Create an array of Double objects.
        // We use the wrapper class Double for generics, not the primitive double.
        Double[] doubleArray = new Double[N];

        // Read the double values into the array
        for (int i = 0; i < N; i++) {
            doubleArray[i] = sc.nextDouble();
        }

        // Create an instance of our generic ArraySorter for the Double type
        ArraySorter<Double> sorter = new ArraySorter<>(doubleArray);

        // Sort the array
        sorter.sort();

        // Print the sorted array
        sorter.printArray();

        sc.close();
    }
}

