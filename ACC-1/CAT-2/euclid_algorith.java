
class Main{
    public static int gcd(int a, int b){
        if(a == 0)
            return b;
        return gcd(b%a, a);
    }

    public static void main(String []args){
        int a = 15, b = 10;
        System.out.println(gcd(a,b));
    }
}