import java.io.*;
import java.util.*;

class Movie implements Serializable{
    String name;
    long date;
    Movie(){
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        date = sc.nextLong();
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException{
        oos.writeLong(date);
    }
    
    private void readObject(ObjectInputStream ois) throws IOException{
        long d = ois.readLong();
        
        
        
        System.out.println(d-3);
    }
}

class MovieManager{
    public static void main(String[]args) throws Exception{
        Movie m = new Movie();
        File f = new File("movie.ser");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        oos.writeObject(m);
        oos.close();
        ois.readObject();
        ois.close();
    }
}