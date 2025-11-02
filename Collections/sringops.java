import java.util.*;
import java.io.*;

class StringListOperations {
    public static void insertItem(ArrayList<String> l, String i) {
        l.add(i);
        System.out.println(i + " has been added to the list.");
    }

    public static void deleteItem(ArrayList<String> l, String i) {
        if (l.remove(i)) {
            System.out.println(i + " has been removed from the list.");
        }
    }

    public static void displayList(ArrayList<String> l) {
        if (l.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Items in the list:");
            for (String i : l) {
                System.out.println(i);
            }
        }
    }

    public static void searchItem(ArrayList<String> l, String i) {
        if (l.contains(i)) {
            System.out.println(i + " is found in the list.");
        } else {
            System.out.println(i + " not found in the list.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        String input = sc.nextLine();
        String[] commands = input.split(" ");
        int i = 0;
        while (i < commands.length) {
            try {
                int choice = Integer.parseInt(commands[i]);
                switch (choice) {
                    case 1:
                        if (i + 1 < commands.length) {
                            StringListOperations.insertItem(list, commands[i + 1]);
                            i += 2;
                        } else {
                            i++;
                        }
                        break;
                    case 2:
                        if (i + 1 < commands.length) {
                            StringListOperations.deleteItem(list, commands[i + 1]);
                            i += 2;
                        } else {
                            i++;
                        }
                        break;
                    case 3:
                        StringListOperations.displayList(list);
                        i += 1;
                        break;
                    case 4:
                        if (i + 1 < commands.length) {
                            StringListOperations.searchItem(list, commands[i + 1]);
                            i += 2;
                        } else {
                            i++;
                        }
                        break;
                    default:
                        i++;
                }
            } catch (NumberFormatException e) {
                i++;
            }
        }
        sc.close();
    }
}
