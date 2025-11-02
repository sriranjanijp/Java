import java.io.*;
import java.util.*;

//Hello

class Decryptor {
    public String decryptFromFile(String filename) throws IOException {
        String encryptedMessage;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            encryptedMessage = reader.readLine();
        }
        
        if (encryptedMessage == null) {
            return "";
        }
        StringBuilder decrypted = new StringBuilder();
        for (char ch : encryptedMessage.toCharArray()) {
            decrypted.append((char)(ch - 1));
        }
        
        return decrypted.toString();
    }
}
class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();

        StringBuilder encrypted = new StringBuilder();
        for (char ch : message.toCharArray()) {
            encrypted.append((char)(ch + 1));
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted_data.txt"))) {
            writer.write(encrypted.toString());
        }

        System.out.println("Encrypted Message: " + encrypted.toString());

        Decryptor decryptor = new Decryptor();
        String decrypted = decryptor.decryptFromFile("encrypted_data.txt");
        System.out.println("Decrypted Message: " + decrypted);
        
        sc.close();
    }
}

