import java.io.*;
import java.util.*;

//Hello world
//x

class VowelReplacer {
    
    void writeToFile(String filename, String text) throws IOException {
        File f = new File(filename);
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(text);
        }
        catch(Exception e){
            
        }
    }

    String replaceVowels(String fileIn, String fileOut, char consonant) throws IOException {
        String content;
        try (Scanner fileScanner = new Scanner(new FileReader(fileIn))) {
            if (fileScanner.hasNextLine()) {
                content = fileScanner.nextLine();
            } else {
                content = "";
            }
        }

        String modifiedContent = content.replaceAll("[aeiouAEIOU]", String.valueOf(consonant));

        writeToFile(fileOut, modifiedContent);
        
        return modifiedContent;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char consonant = sc.nextLine().charAt(0);
        
        VowelReplacer replacer = new VowelReplacer();
        replacer.writeToFile("file1.txt", input);
        String modifiedResult = replacer.replaceVowels("file1.txt", "file2.txt", consonant);
        System.out.println(modifiedResult);
        
        sc.close();
    }
}
