import java.io.*;
import java.util.*;

/*
 * 2
201
Bottle
100.0
202
Water
300.0
 */

class Prod implements Serializable{
    
    int ID;
    String name;
    double cost;
    
    Prod(Scanner sc){
        ID = sc.nextInt();
        sc.next();
        name = sc.nextLine();
        
        cost = sc.nextDouble();
    }
    
     void writeObject(ObjectOutputStream oos) throws IOException{
        oos.writeDouble(cost);
    }
    
     void readObject(ObjectInputStream oos) throws IOException{
        oos.readDouble();
    }

}

class Online_Store{
    public static void main(String[]args) throws Exception{
        Scanner sc = new Scanner(System.in);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.ser"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.ser"));
        
        int num = sc.nextInt();
        Prod []p = new Prod[num];
        
        for(int i = 0; i<num; i++)
        {
            p[i] = new Prod(sc);
            oos.writeObject(p[i]);
        }
        
        Prod []s = new Prod[num];
        double sum = 0;
        
        for(int i = 0; i<num; i++)
        {
            s[i] = (Prod)ois.readObject();
            sum += s[i].cost;
        }
        System.out.println("Successfully serialized " + num + " products to products.dat");
        System.out.println("Total cost of all products: " + sum);
        
    }
}

