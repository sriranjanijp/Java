import java.io.*;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

class Main{
    static void check() throws MyException, IOException{
        throw new MyException("Custom Exception Occurred");
    }

    public static void main(String[] args) {
       
    }
}