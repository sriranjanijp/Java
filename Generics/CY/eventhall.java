import java.util.*;

class Hall implements Comparable<Hall> {
    private String n;
    private String c;
    private double d;
    private String o;

    public Hall(String n, String c, double d, String o) {
        this.n = n;
        this.c = c;
        this.d = d;
        this.o = o;
    }

    public String getName() { return n; }
    public void setName(String n) { this.n = n; }

    public String getContactNumber() { return c; }
    public void setContactNumber(String c) { this.c = c; }

    public double getCostPerDay() { return d; }
    public void setCostPerDay(double d) { this.d = d; }

    public String getOwnerName() { return o; }
    public void setOwnerName(String o) { this.o = o; }

    @Override
    public int compareTo(Hall other) {
        return Double.compare(this.d, other.d);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        try {
            int n = Integer.parseInt(s.nextLine().trim());
            List<Hall> hs = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String hn = s.nextLine();
                String cn = s.nextLine();
                double cd = Double.parseDouble(s.nextLine());
                String on = s.nextLine();
                hs.add(new Hall(hn, cn, cd, on));
            }

            Collections.sort(hs);

            for (Hall h : hs) {
                System.out.printf("%s %s %.1f %s\n", 
                    h.getName(), 
                    h.getContactNumber(), 
                    h.getCostPerDay(), 
                    h.getOwnerName()
                );
            }
            
        } catch (Exception e) {
            
        } finally {
            s.close();
        }
    }
}
