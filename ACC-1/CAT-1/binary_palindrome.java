import java.util.*;

class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input: ");
        int n = sc.nextInt();
        int ori = n;
        int rev = 0;
        while(n>0){
            rev <<= 1;
            rev |= (n & 1);
            n >>= 1;
        }
        if(rev == ori){
            System.out.println("Palindrome ");
        } else {
            System.out.println("Not palindrome");
        }
    }
}