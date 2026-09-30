import java.util.*;

class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter upper limit: ");
        int upper = sc.nextInt();
        System.out.println("Enter lower limit: ");
        int lower = sc.nextInt();

        boolean []prime = new boolean[upper+1];
        for(int i = lower; i <= upper; i++){
            prime[i] = true;
        }

        for(int i = 2; i*i <= upper; i++){
            int sm = (lower/i) * i;   //smallest multiple in range
            if (sm < lower){
                sm += i;
            }
            for(int j = sm; j <= upper; j += i){
                prime[j] = false;
            }
        }

        System.out.println("Prime nos ");
        for(int i = lower; i <= upper; i++){
            if(prime[i]){
                System.out.println(i + " ");
            }
        }
    }
}
