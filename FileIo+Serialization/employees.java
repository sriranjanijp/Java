import java.io.*;
import java.util.*;

// Serializable Employee class
class Employee implements Serializable {
    // Add serialVersionUID for version control
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return "Employee[ID=" + id + ", Name=" + name + ", Salary=" + salary + "]";
    }
}

/**
 * Manages serialization, deserialization, and business logic for Employee objects.
 */
class EmployeeManager {

    /**
     * Serializes an array of Employee objects to a file.
     * @param employees The array of employees to serialize.
     * @param filePath The file path to write to.
     * @throws IOException If an I/O error occurs.
     */
    public void serializeEmployees(Employee[] employees, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employees);
        }
    }

    /**
     * Deserializes an array of Employee objects from a file.
     * @param filePath The file path to read from.
     * @return The deserialized array of employees.
     * @throws IOException If an I/O error occurs.
     * @throws ClassNotFoundException If the Employee class cannot be found.
     */
    public Employee[] deserializeEmployees(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Employee[]) ois.readObject();
        }
    }

    /**
     * Finds the employee with the highest salary from an array.
     * @param employees The array of employees to search.
     * @return The Employee object with the highest salary.
     */
    public Employee findHighestSalaryEmployee(Employee[] employees) {
        if (employees == null || employees.length == 0) {
            return null;
        }

        Employee highestPaid = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() > highestPaid.getSalary()) {
                highestPaid = employees[i];
            }
        }
        return highestPaid;
    }
}


// Main class for input/output
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        String filePath = "employees.ser"; // Use a local file name

        try {
            int n = sc.nextInt();
            if (n <= 0) {
                 System.out.println("No employees to process.");
                 sc.close();
                 return;
            }
            Employee[] employees = new Employee[n];

            for (int i = 0; i < n; i++) {
                int id = sc.nextInt();
                String name = sc.next();
                double salary = sc.nextDouble();
                employees[i] = new Employee(id, name, salary);
            }

            // --- We are using a temp file path for this environment ---
            // Creating a temp file for serialization
            File tempFile = File.createTempFile("employees", ".ser");
            filePath = tempFile.getAbsolutePath();
            tempFile.deleteOnExit(); // Ensure the file is deleted when the program exits
            // --- End of temp file logic ---


            // Serialize employees
            manager.serializeEmployees(employees, filePath);

            // Deserialize employees
            Employee[] deserializedEmployees = manager.deserializeEmployees(filePath);

            // Find highest salary employee
            Employee topEmployee = manager.findHighestSalaryEmployee(deserializedEmployees);
            if (topEmployee != null) {
                System.out.println("Highest Salary: " + topEmployee);
            } else {
                System.out.println("No employee data found.");
            }


        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Please enter numeric ID and Salary.");
        } finally {
            sc.close();
        }
    }
}

