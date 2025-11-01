import java.io.*;
import java.util.Scanner;


// 1000.7
//500.5
//100.6

class BankAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
        }
    }

    public double getBalance() {
        return this.balance;
    }
}

class Bank {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String filename = "bankAccount.ser";
        BankAccount loadedAccount = null;

        try {
            double initialBalance = scanner.nextDouble();
            double depositAmount = scanner.nextDouble();
            double withdrawalAmount = scanner.nextDouble();
            
            BankAccount account = new BankAccount(initialBalance);
            account.deposit(depositAmount);
            account.withdraw(withdrawalAmount);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(account);
            }

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                loadedAccount = (BankAccount) ois.readObject();
            }

            if (loadedAccount != null) {
                System.out.printf("%.2f%n", loadedAccount.getBalance());
            }

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}

