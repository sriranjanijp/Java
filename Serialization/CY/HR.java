import java.io.*;
import java.util.Scanner;

/*
3
101 John HR 45000.00
102 Alice IT 60000.00
103 Bob Finance 90000.00
50000.00
/**
 * Employee class to store details of an employee.
 * It implements Serializable to allow objects of this class to be written to a file.
 */
class Employee implements Serializable {
    // serialVersionUID is used for version control during deserialization
    private static final long serialVersionUID = 1L;

    private int employee_id;
    private String name;
    private String department;
    private double salary;

    /**
     * Constructor to initialize an Employee object.
     * @param employee_id The unique ID of the employee.
     * @param name The employee's name.
     * @param department The department the employee works in.
     * @param salary The employee's salary.
     */
    public Employee(int employee_id, String name, String department, double salary) {
        this.employee_id = employee_id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    /**
     * Getter for the employee's salary.
     * @return The salary.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Overridden toString method to format the employee's details.
     * @return A formatted string with employee details.
     */
    @Override
    public String toString() {
        return employee_id + " " + name + " " + department + " " + salary;
    }
}

/**
 * Main class to manage employee records, serialization, deserialization, and filtering.
 */
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = "employees.ser";

        try {
            // Read the number of employees
            int n = Integer.parseInt(sc.nextLine());
            
            Employee[] employees = new Employee[n];

            // Read employee details
            for (int i = 0; i < n; i++) {
                String[] input = sc.nextLine().split(" ");
                int employee_id = Integer.parseInt(input[0]);
                String name = input[1];
                String department = input[2];
                double salary = Double.parseDouble(input[3]);
                employees[i] = new Employee(employee_id, name, department, salary);
            }

            // Read the salary threshold
            double salaryThreshold = Double.parseDouble(sc.nextLine());

            // Serialize the array of Employee objects to a file
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(employees);
            }

            // Deserialize the array of Employee objects from the file
            Employee[] loadedEmployees;
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                loadedEmployees = (Employee[]) ois.readObject();
            }

            // Filter and print employees above the threshold
            boolean foundEmployee = false;
            if (loadedEmployees != null) {
                for (Employee emp : loadedEmployees) {
                    if (emp.getSalary() > salaryThreshold) {
                        System.out.println(emp.toString());
                        foundEmployee = true;
                    }
                }
            }

            // Print message if no employees meet the criteria
            if (!foundEmployee) {
                System.out.println("No employees found above threshold");
            }

        } catch (Exception e) {
            // Handle potential exceptions like IOException, ClassNotFoundException, etc.
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}

