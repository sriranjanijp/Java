import java.util.Scanner;
/*
Write generic functions that can be called with different types of arguments based on the type of arguments passed 
to the generic method; the compiler handles each method. 
Obtain an integer and a double value and pass them to the function.

Function Header: static <T> void genericDisplay (T element) 
*/

// 12 23.5

public class Main {

    public static <T> void genericDisplay(T element) {
        System.out.println(element.getClass().getName() + " = " + element);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intValue = sc.nextInt();
        double doubleValue = sc.nextDouble();
        genericDisplay(intValue);
        genericDisplay(doubleValue);
    }
}
