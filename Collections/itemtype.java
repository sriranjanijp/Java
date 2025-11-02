import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ItemType {
    private String name;
    private double deposit;
    private double costPerDay;

    public ItemType(String name, double deposit, double costPerDay) {
        this.name = name;
        this.deposit = deposit;
        this.costPerDay = costPerDay;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20.1f%-20.1f", 
                             this.name, this.deposit, this.costPerDay);
    }
}

public class Main {
    public static void main(String args[]) {
        List<ItemType> items = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double deposit = Double.parseDouble(sc.nextLine());
            double costPerDay = Double.parseDouble(sc.nextLine());
            items.add(new ItemType(name, deposit, costPerDay));
        }
        
        System.out.format("%-20s%-20s%-20s\n", "Name", "Deposit", "Cost Per Day");
        
        for (ItemType item : items) {
            System.out.println(item);
        }
        
        sc.close();
    }
}

