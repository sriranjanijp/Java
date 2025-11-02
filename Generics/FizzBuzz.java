import java.util.*;
import java.io.*;

class FizzBuzz<T extends Number>{
    T num;
    
    FizzBuzz(T num){
        this.num = num;
    }
    
    void print(){
        int lim = num.intValue();
        for(int i = 1; i<= lim; i++){
            if(i%3 == 0)
                System.out.print("Fizz");
            if(i%5 == 0)
                System.out.print("Buzz"); 
            if(i%3 != 0 && i%5 != 0)
                System.out.print(i);
            System.out.println();
        }
    }
}

class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Integer in1 = Integer.parseInt(sc.next());
        FizzBuzz<Integer> area = new FizzBuzz<>(in1);
        area.print();
    }
}