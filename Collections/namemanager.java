import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages a list of student names.
 */
class NameManager {
    private ArrayList<String> names;

    public NameManager() {
        this.names = new ArrayList<>();
    }

    /**
     * Adds a name to the list.
     * @param name The student's name.
     */
    public void addName(String name) {
        names.add(name);
    }

    /**
     * Retrieves a name from a specific index.
     * @param index The index to retrieve from.
     * @return The name at the index, or null if the index is invalid.
     */
    public String getNameAtIndex(int index) {
        if (index >= 0 && index < names.size()) {
            return names.get(index);
        } else {
            return null;
        }
    }
}

/**
 * Main class to run the student registration program.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NameManager manager = new NameManager();

        int n = sc.nextInt();
        sc.nextLine(); // consume newline left-over

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            manager.addName(name);
        }

        int index = sc.nextInt();
        String result = manager.getNameAtIndex(index);

        if (result != null) {
            System.out.println("Element at index " + index + ": " + result);
        } else {
            System.out.println("Invalid index");
        }

        sc.close();
    }
}

