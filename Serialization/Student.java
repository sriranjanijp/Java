import java.io.*;
import java.util.*;

// Math 95

class Grade implements Serializable{
    
    String sub;
    int mark;
    
    Grade(){
        Scanner sc = new Scanner(System.in);
        sub = sc.next();
        mark = sc.nextInt();
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException{
        oos.writeInt(mark);
    }
    
    private void readObject(ObjectInputStream ois) throws IOException{
        int m = ois.readInt();
        
        if(m>=90)
            System.out.println("Excellent");
        else if(m>=70)
            System.out.println("Good");
        else
            System.out.println("Needs Improvement");
    }
}

class Student{
    public static void main(String[] args) throws Exception{
        Grade gr = new Grade();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("grade.ser"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("grade.ser"));
        oos.writeObject(gr);
        ois.readObject();
    }
}