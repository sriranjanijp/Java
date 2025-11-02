import java.io.*;
import java.util.*;

// Serializable Student class
class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int studentID;
    private String enrolledCourses;

    public Student(String name, int studentID, String enrolledCourses) {
        this.name = name;
        this.studentID = studentID;
        this.enrolledCourses = enrolledCourses;
    }

    // Getter methods
    public String getName() { return name; }
    public int getStudentID() { return studentID; }
    public String getEnrolledCourses() { return enrolledCourses; }
}

/**
 * Manages processing, validation, serialization, and deserialization of Student objects.
 */
class StudentManager {

    /**
     * Validates if the student ID string represents a positive integer.
     * @param studentIDString The input string for the student ID.
     * @return The integer ID if valid, or -1 if invalid.
     */
    private static int validateStudentID(String studentIDString) {
        try {
            int id = Integer.parseInt(studentIDString);
            if (id > 0) {
                return id;
            } else {
                return -1; // Not a positive integer
            }
        } catch (NumberFormatException e) {
            return -1; // Not an integer
        }
    }

    /**
     * Serializes a Student object into a byte array.
     * @param student The Student object to serialize.
     * @return A byte array containing the serialized object.
     * @throws IOException If an I/O error occurs.
     */
    private static byte[] serializeStudent(Student student) throws IOException {
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
    private static Student deserializeStudent(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            return (Student) ois.readObject();
        }
    }

    /**
     * Main processing logic: validates, serializes, deserializes, and prints.
     * @param name The student's name.
     * @param studentIDString The student's ID as a string.
     * @param enrolledCourses The student's courses.
     */
    public static void processStudent(String name, String studentIDString, String enrolledCourses) {
        int studentID = validateStudentID(studentIDString);

        if (studentID == -1) {
            System.out.println("Invalid student ID! Must be a positive integer.");
            return;
        }

        Student student = new Student(name, studentID, enrolledCourses);

        try {
            // Serialize
            byte[] data = serializeStudent(student);
            
            // Deserialize
            Student deserializedStudent = deserializeStudent(data);

            // Output
            System.out.println("Name: " + deserializedStudent.getName());
            System.out.println("Student ID: " + deserializedStudent.getStudentID());
            System.out.println("Enrolled Courses: " + deserializedStudent.getEnrolledCourses());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String studentIDString = sc.nextLine();
        String enrolledCourses = sc.nextLine();

        // Delegate processing to StudentManager
        StudentManager.processStudent(name, studentIDString, enrolledCourses);

        sc.close();
    }
}

