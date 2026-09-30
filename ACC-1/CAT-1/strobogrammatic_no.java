import java.util.*;

class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        String n = sc.next();

        System.out.println(isStrobo(n));
    }

    public static boolean isStrobo(String n){
        Map <Character, Character> map = new HashMap<Character, Character>();
        map.put('6','9');
        map.put('9','6');
        map.put('8','8');
        map.put('1','1');
        map.put('0','0');
        int l = 0, r = n.length() - 1;

        while(l<=r){
            if(!map.containsKey(n.charAt(l))){
                return false;
            }

            if(map.get(n.charAt(l)) != n.charAt(r)){
                return false;
            }

            l++;
            r--;
        }
        return true;
    }
}