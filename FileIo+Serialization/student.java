import java.io.*;
import java.util.Scanner; // Import Scanner

/**
 * Serializable Student class
 */
class Student implements Serializable {
    // Add serialVersionUID for version control
    private static final long serialVersionUID = 1L;

    private String name;
    private int rollNumber;
    private String enrolledCourses;

    public Student(String name, int rollNumber, String enrolledCourses) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.enrolledCourses = enrolledCourses;
    }

    public String getName() { return name; }
    public int getRollNumber() { return rollNumber; }
    public String getEnrolledCourses() { return enrolledCourses; }
}

/**
 * Manages serialization, deserialization, and validation for Student objects.
 */
class StudentManager {

    /**
     * Validates if the roll number is a positive integer.
     * @param rollNumber The roll number to validate.
     * @return true if rollNumber > 0, false otherwise.
     */
    public static boolean isValidRollNumber(int rollNumber) {
        return rollNumber > 0;
    }

    /**
     * Validates if the enrolled courses string is non-empty.
     * @param enrolledCourses The string of courses to validate.
     * @return true if the string is not null and not empty, false otherwise.
     */
    public static boolean isValidCourses(String enrolledCourses) {
        return enrolledCourses != null && !enrolledCourses.trim().isEmpty();
    }

    /**
     * Serializes a Student object into a byte array.
     * @param student The Student object to serialize.
     * @return A byte array containing the serialized object.
     * @throws IOException If an I/O error occurs.
     */
    public static byte[] serializeStudent(Student student) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(student);
        }
        return baos.toByteArray();
    }

    /**
     * Deserializes a Student object from a byte array.
     * @param data The byte array containing the serialized object.
     * @return The deserialized Student object.
     * @throws IOException If an I/O error occurs.
     * @throws ClassNotFoundException If the Student class cannot be found.
     */
    public static Student deserializeStudent(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            return (Student) ois.readObject();
        }
    }
}


/**
 * Main class provided by the user.
 */
public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        String name = sc.nextLine();
        
        int rollNumber = 0;
        try {
            // Read roll number as int
            rollNumber = sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            // This handles if the user enters non-numeric text
            System.out.println("Invalid roll number! Must be a positive integer.");
            sc.close();
            return;
        }
        
        sc.nextLine(); // Consume newline left-over
        String enrolledCourses = sc.nextLine();

        // Validation for positive number
        if (!StudentManager.isValidRollNumber(rollNumber)) {
            System.out.println("Invalid roll number! Must be a positive integer.");
            sc.close();
            return;
        }

        // Validation for non-empty courses
        if (!StudentManager.isValidCourses(enrolledCourses)) {
            System.out.println("Invalid enrolled courses! Must have at least one course.");
            sc.close();
            return;
        }

        Student student = new Student(name, rollNumber, enrolledCourses);

        try {
            // Serialize
            byte[] data = StudentManager.serializeStudent(student);

            // Deserialize
            Student s = StudentManager.deserializeStudent(data);

            // Output
            System.out.println("Name: " + s.getName());
            System.out.println("Roll Number: " + s.getRollNumber());
            System.out.println("Enrolled Courses: " + s.getEnrolledCourses());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}

