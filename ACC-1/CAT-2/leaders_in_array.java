class Main{
    public static void main(String []args){
        int []a = {2, 4, 6, 3,1 ,2};
        int b = a[5];
        String s = ""+b;
        System.out.println(a[5]);
        for(int i  = 5; i >= 0; i--){
            if (b<a[i]) {

                System.out.println(a[i]);

                s += " " + a[i];
            }
            b = a[i];
        }
        System.out.println(s);
    }
}