import java.util.*;

class NumberProcessor {
    ArrayList<Integer> nl;

    NumberProcessor(ArrayList<Integer> nl) {
        this.nl = nl;
    }

    void processNumbers() {
        ArrayList<Integer> r = new ArrayList<>();

        for (int n : nl) {
            if (r.isEmpty() || n > r.get(r.size() - 1)) {
                r.add(n);
            }
        }

        System.out.println(r);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if (n <= 0) {
            s.close();
            return;
        }

        ArrayList<Integer> nl = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nl.add(s.nextInt());
        }
        
        NumberProcessor p = new NumberProcessor(nl);
        p.processNumbers();
        
        s.close();
    }
}
