import java.io.*;
import java.util.*;

//Playing 0.75

class Pet implements Serializable{
    
    String act;
    double time; 
    
    Pet(){
        Scanner sc = new Scanner(System.in);
        act = sc.next();
        time = sc.nextDouble();
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException{
        oos.writeDouble(time);
    }
    
    private void readObject(ObjectInputStream ois) throws IOException{
        System.out.println(ois.readDouble() + 0.5 + " hours");
    }
    
}

class Pet_Activity{
    public static void main(String[] args) throws Exception{
        Pet p = new Pet();
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dog.ser"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dog.ser"));
        oos.writeObject(p);
        ois.readObject();
    } 
}