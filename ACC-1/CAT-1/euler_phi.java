import java.util.*;

class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter limit: ");
        int limit = sc.nextInt();
        
        int result = limit;

        for(int i = 2; i*i <= limit; i++){
            if(limit % i == 0){
                while(limit % i == 0){
                    limit /= i; 
                }

                result -= result/i;
            }
        }

        if(limit>1){
            result -= result/limit;
        }

        System.out.println("Result: "+result);
        
    }
}