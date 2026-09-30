import java.util.*;

class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of equations: ");
        int size = sc.nextInt();

        int []div = new int[size];
        for(int i = 0; i < size; i++){
            div[i] = sc.nextInt();
        }

        int []rem = new int[size];
        for(int i = 0; i < size; i++){
            rem[i] = sc.nextInt();
        }

        int j, x = 1;
        while(true){
            for(j = 0; j < size; j++){
                if(x % div[j] != rem[j]){
                    break;
                }
            }

            if(j == size)
                break;

            x++;
        }
        System.out.println(x);
    }
}