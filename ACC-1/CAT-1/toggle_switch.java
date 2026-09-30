import java.util.*;

class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of switches: ");
        int sw = sc.nextInt();
        System.out.println("Enter no of operations: ");
        int ops = sc.nextInt();

        int []a = new int[sw+1];

        for(int i = 0; i < ops; i++){
            int x = sc.nextInt();
            for(int j = x; j <= sw; j+=x){
                a[j] ^= 1;
            }
        }

        for(int i = 1; i <=sw; i++){
            System.out.print(a[i] + " ");
        }
    }
}