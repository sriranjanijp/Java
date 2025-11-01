import java.io.*;
import java.util.Scanner;

// 12 15
class Birthday implements Serializable {
    private static final long serialVersionUID = 2L;

    int month;
    int day;

    public Birthday(int month, int day) {
        this.month = month;
        this.day = day;
    }
}

class Birthdays {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String filename = "birthdays.ser";

        try {
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            
            Birthday originalBirthday = new Birthday(month, day);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                
                oos.writeObject(originalBirthday);
            }

            Birthday deserializedBirthday = null;
            try (FileInputStream fis = new FileInputStream(filename);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                
                deserializedBirthday = (Birthday) ois.readObject();
            }

            if (deserializedBirthday != null) {
                switch (deserializedBirthday.month) {
                    case 12:
                    case 1:
                    case 2:
                        System.out.println("Winter");
                        break;
                    case 3:
                    case 4:
                    case 5:
                        System.out.println("Spring");
                        break;
                    case 6:
                    case 7:
                    case 8:
                        System.out.println("Summer");
                        break;
                    case 9:
                    case 10:
                    case 11:
                        System.out.println("Fall");
                        break;
                    default:
                        System.out.println("Invalid month");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}

