import java.util.*;

class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter limit: ");
        int limit = sc.nextInt();
        boolean []prime = new boolean[limit+1];
        for(int i = 2; i <= limit; i++){
            prime[i] = true;
        }

        for(int i = 2; i*i <= limit; i++){
            if(prime[i]){
                for(int j = i*i; j <= limit; j += i){
                    prime[j] = false;
                }
            }
        }

        System.out.println("Prime nos ");
        for(int i = 2; i <= limit; i++){
            if(prime[i]){
                System.out.println(i + " ");
            }
        }
    }
}